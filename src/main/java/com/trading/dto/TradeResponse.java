package com.trading.dto;



import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TradeResponse {

    private Long tradeId;
    private Long buyOrderId;
    private Long sellOrderId;
    private String stockSymbol;
    private BigDecimal price;
    private Integer quantity;
    private LocalDateTime executedAt;
}
