package com.trading.controller;



import com.trading.dto.OrderBookResponse;
import com.trading.service.OrderBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderbook")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderBookController {

    private final OrderBookService orderBookService;

    @GetMapping("/{symbol}")
    public OrderBookResponse getOrderBook(@PathVariable String symbol) {
        return orderBookService.getOrderBook(symbol);
    }
}
