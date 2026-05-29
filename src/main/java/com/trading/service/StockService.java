package com.trading.service;



import com.trading.dto.StockRequest;
import com.trading.entity.Stock;
import com.trading.exception.BadRequestException;
import com.trading.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockService {

    private final StockRepository stockRepository;

    public Stock addStock(StockRequest request) {
        log.info("Adding stock: {}", request.getSymbol());

        if (stockRepository.findBySymbol(request.getSymbol()).isPresent()) {
            throw new BadRequestException("Stock already exists");
        }

        Stock stock = Stock.builder()
                .symbol(request.getSymbol().toUpperCase())
                .companyName(request.getCompanyName())
                .build();

        return stockRepository.save(stock);
    }

    public List<Stock> getAllStocks() {
        log.info("Fetching all stocks");
        return stockRepository.findAll();
    }
}
