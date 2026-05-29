package com.trading.dto;



import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class OrderResponse {

    private Long orderId;
    private String userName;
    private String stockSymbol;
    private String orderType;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;
    private String status;
    private LocalDateTime createdAt;
}
