package com.trading.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StockRequest {

    @NotBlank(message = "Symbol is required")
    private String symbol;

    @NotBlank(message = "Company name is required")
    private String companyName;
}
