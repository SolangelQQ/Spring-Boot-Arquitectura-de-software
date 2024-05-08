package com.ucb.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    
    @NotNull
    final String message;
    public ErrorResponse(String message) {
        this.message = message;
    }
}
