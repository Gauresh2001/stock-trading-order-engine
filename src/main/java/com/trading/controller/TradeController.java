package com.trading.controller;



import com.trading.dto.TradeResponse;
import com.trading.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TradeController {

    private final TradeService tradeService;

    @GetMapping("/stock/{symbol}")
    public List<TradeResponse> getRecentTrades(@PathVariable String symbol) {
        return tradeService.getRecentTradesByStock(symbol);
    }
}
