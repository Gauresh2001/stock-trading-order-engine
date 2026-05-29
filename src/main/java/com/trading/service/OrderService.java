package com.trading.service;


import com.trading.dto.OrderRequest;
import com.trading.dto.OrderResponse;
import com.trading.entity.Order;
import com.trading.entity.Stock;
import com.trading.entity.Trade;
import com.trading.entity.User;
import com.trading.enums.OrderStatus;
import com.trading.enums.OrderType;
import com.trading.exception.BadRequestException;
import com.trading.exception.ResourceNotFoundException;
import com.trading.repository.OrderRepository;
import com.trading.repository.StockRepository;
import com.trading.repository.TradeRepository;
import com.trading.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final UserRepository userRepository;
    private final StockRepository stockRepository;
    private final OrderRepository orderRepository;
    private final TradeRepository tradeRepository;

    @Transactional
    public synchronized OrderResponse placeBuyOrder(OrderRequest request) {
        log.info("Placing BUY order for userId: {}, stock: {}",
                request.getUserId(),
                request.getStockSymbol());

        return placeOrder(request, OrderType.BUY);
    }

    @Transactional
    public synchronized OrderResponse placeSellOrder(OrderRequest request) {
        log.info("Placing SELL order for userId: {}, stock: {}",
                request.getUserId(),
                request.getStockSymbol());

        return placeOrder(request, OrderType.SELL);
    }

    private OrderResponse placeOrder(OrderRequest request, OrderType orderType) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Stock stock = stockRepository.findBySymbol(
                        request.getStockSymbol().toUpperCase())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Stock not found"));

        Order order = Order.builder()
                .user(user)
                .stock(stock)
                .orderType(orderType)
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .remainingQuantity(request.getQuantity())
                .status(OrderStatus.OPEN)
                .build();

        Order savedOrder = orderRepository.save(order);

        matchOrder(savedOrder);

        return mapToResponse(savedOrder);
    }

    private void matchOrder(Order incomingOrder) {

        List<OrderStatus> activeStatuses =
                Arrays.asList(OrderStatus.OPEN, OrderStatus.PARTIAL);

        if (incomingOrder.getOrderType() == OrderType.BUY) {

            List<Order> sellOrders =
                    orderRepository
                            .findByStockSymbolAndOrderTypeAndStatusInOrderByPriceAscCreatedAtAsc(
                                    incomingOrder.getStock().getSymbol(),
                                    OrderType.SELL,
                                    activeStatuses);

            for (Order sellOrder : sellOrders) {

                if (incomingOrder.getRemainingQuantity() <= 0) {
                    break;
                }

                if (sellOrder.getPrice()
                        .compareTo(incomingOrder.getPrice()) <= 0) {

                    executeTrade(
                            incomingOrder,
                            sellOrder,
                            sellOrder.getPrice());
                }
            }

        } else {

            List<Order> buyOrders =
                    orderRepository
                            .findByStockSymbolAndOrderTypeAndStatusInOrderByPriceDescCreatedAtAsc(
                                    incomingOrder.getStock().getSymbol(),
                                    OrderType.BUY,
                                    activeStatuses);

            for (Order buyOrder : buyOrders) {

                if (incomingOrder.getRemainingQuantity() <= 0) {
                    break;
                }

                if (buyOrder.getPrice()
                        .compareTo(incomingOrder.getPrice()) >= 0) {

                    executeTrade(
                            buyOrder,
                            incomingOrder,
                            buyOrder.getPrice());
                }
            }
        }

        updateOrderStatus(incomingOrder);
        orderRepository.save(incomingOrder);
    }

    private void executeTrade(
            Order buyOrder,
            Order sellOrder,
            java.math.BigDecimal tradePrice) {

        int tradeQuantity = Math.min(
                buyOrder.getRemainingQuantity(),
                sellOrder.getRemainingQuantity());

        buyOrder.setRemainingQuantity(
                buyOrder.getRemainingQuantity() - tradeQuantity);

        sellOrder.setRemainingQuantity(
                sellOrder.getRemainingQuantity() - tradeQuantity);

        updateOrderStatus(buyOrder);
        updateOrderStatus(sellOrder);

        orderRepository.save(buyOrder);
        orderRepository.save(sellOrder);

        Trade trade = Trade.builder()
                .buyOrder(buyOrder)
                .sellOrder(sellOrder)
                .price(tradePrice)
                .quantity(tradeQuantity)
                .build();

        tradeRepository.save(trade);

        log.info("Trade Executed Successfully");
    }

    private void updateOrderStatus(Order order) {

        if (order.getRemainingQuantity() == 0) {
            order.setStatus(OrderStatus.FILLED);
        } else if (order.getRemainingQuantity()
                < order.getQuantity()) {
            order.setStatus(OrderStatus.PARTIAL);
        } else {
            order.setStatus(OrderStatus.OPEN);
        }
    }

    // ===== GET ALL ORDERS =====

    public List<OrderResponse> getAllOrders() {

        log.info("Fetching all orders");

        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ===== USER ORDER HISTORY =====

    public List<OrderResponse> getUserOrders(Long userId) {

        return orderRepository
                .findByUserIdOrderByCreatedAtDesc(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ===== CANCEL ORDER =====

    @Transactional
    public void cancelOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found"));

        if (order.getStatus() == OrderStatus.FILLED) {
            throw new BadRequestException(
                    "Filled order cannot be cancelled");
        }

        order.setStatus(OrderStatus.CANCELLED);

        orderRepository.save(order);
    }

    // ===== DTO MAPPING =====

    public OrderResponse mapToResponse(Order order) {

        return OrderResponse.builder()
                .orderId(order.getId())
                .userName(order.getUser().getName())
                .stockSymbol(order.getStock().getSymbol())
                .orderType(order.getOrderType().name())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .remainingQuantity(order.getRemainingQuantity())
                .status(order.getStatus().name())
                .createdAt(order.getCreatedAt())
                .build();
    }
}
