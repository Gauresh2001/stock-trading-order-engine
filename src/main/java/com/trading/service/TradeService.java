package com.trading.service;



import com.trading.dto.TradeResponse;
import com.trading.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TradeService {

    private final TradeRepository tradeRepository;

    public List<TradeResponse> getRecentTradesByStock(String symbol) {
        log.info("Fetching recent trades for stock: {}", symbol);

        return tradeRepository
                .findByBuyOrderStockSymbolOrSellOrderStockSymbolOrderByExecutedAtDesc(
                        symbol.toUpperCase(),
                        symbol.toUpperCase()
                )
                .stream()
                .map(trade -> TradeResponse.builder()
                        .tradeId(trade.getId())
                        .buyOrderId(trade.getBuyOrder().getId())
                        .sellOrderId(trade.getSellOrder().getId())
                        .stockSymbol(trade.getBuyOrder().getStock().getSymbol())
                        .price(trade.getPrice())
                        .quantity(trade.getQuantity())
                        .executedAt(trade.getExecutedAt())
                        .build())
                .toList();
    }
}
