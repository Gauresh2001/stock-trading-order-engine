package com.trading.repository;



import com.trading.entity.Order;
import com.trading.enums.OrderStatus;
import com.trading.enums.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<Order> findByStockSymbolAndOrderTypeAndStatusInOrderByPriceDescCreatedAtAsc(
            String symbol,
            OrderType orderType,
            List<OrderStatus> statuses
    );

    List<Order> findByStockSymbolAndOrderTypeAndStatusInOrderByPriceAscCreatedAtAsc(
            String symbol,
            OrderType orderType,
            List<OrderStatus> statuses
    );
}
