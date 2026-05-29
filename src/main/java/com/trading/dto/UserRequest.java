package com.trading.dto;



import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Enter valid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Balance is required")
    @DecimalMin(value = "0.0", message = "Balance cannot be negative")
    private BigDecimal balance;

}
