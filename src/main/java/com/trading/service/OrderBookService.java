package com.trading.service;



import com.trading.dto.OrderBookResponse;
import com.trading.dto.OrderResponse;
import com.trading.enums.OrderStatus;
import com.trading.enums.OrderType;
import com.trading.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderBookService {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public OrderBookResponse getOrderBook(String symbol) {
        log.info("Fetching order book for stock: {}", symbol);

        List<OrderStatus> activeStatuses = Arrays.asList(OrderStatus.OPEN, OrderStatus.PARTIAL);

        List<OrderResponse> buyOrders = orderRepository
                .findByStockSymbolAndOrderTypeAndStatusInOrderByPriceDescCreatedAtAsc(
                        symbol.toUpperCase(),
                        OrderType.BUY,
                        activeStatuses
                )
                .stream()
                .map(orderService::mapToResponse)
                .toList();

        List<OrderResponse> sellOrders = orderRepository
                .findByStockSymbolAndOrderTypeAndStatusInOrderByPriceAscCreatedAtAsc(
                        symbol.toUpperCase(),
                        OrderType.SELL,
                        activeStatuses
                )
                .stream()
                .map(orderService::mapToResponse)
                .toList();

        return OrderBookResponse.builder()
                .stockSymbol(symbol.toUpperCase())
                .buyOrders(buyOrders)
                .sellOrders(sellOrders)
                .build();
    }
}
