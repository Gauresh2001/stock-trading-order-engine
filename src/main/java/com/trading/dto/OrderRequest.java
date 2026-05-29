package com.trading.dto;



import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Stock symbol is required")
    private String stockSymbol;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be minimum 1")
    private Integer quantity;
}
