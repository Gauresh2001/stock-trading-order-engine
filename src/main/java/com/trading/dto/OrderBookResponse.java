package com.trading.dto;



import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderBookResponse {

    private String stockSymbol;
    private List<OrderResponse> buyOrders;
    private List<OrderResponse> sellOrders;
}
