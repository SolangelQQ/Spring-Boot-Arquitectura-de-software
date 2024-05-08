package com.ucb.product.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucb.product.dto.tarjeta;
import com.ucb.product.dto.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {

    @PostMapping("/payment")
    @Operation(summary = "Procesar pago con tarjeta de crédito", description = "Permite procesar un pago con tarjeta de crédito")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Pago exitoso"),
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<?> processPayment(@RequestBody tarjeta paymentRequest) {
    
        if (paymentRequest == null || !isValidPaymentRequest(paymentRequest)) {
            ErrorResponse errorResponse = new ErrorResponse("La solicitud de pago es incorrecta");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        
        try {
            if (!isValidCardDetails(paymentRequest)) {
                ErrorResponse errorResponse = new ErrorResponse("Detalles de tarjeta de crédito inválidos");
                return ResponseEntity.badRequest().body(errorResponse);
            }

    boolean paymentProcessed = processPayment(paymentRequest).hasBody();

        if (paymentProcessed) {
            return ResponseEntity.ok("Pago exitoso");
        } else {

            ErrorResponse errorResponse = new ErrorResponse("Error al procesar el pago");
            return ResponseEntity.status(500).body(errorResponse);
        }
        } catch (Exception e) {

            ErrorResponse errorResponse = new ErrorResponse("Error interno del servidor");
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    private boolean isValidCardDetails(tarjeta paymentRequest) {
     return false;
    }

    private boolean isValidPaymentRequest(tarjeta tarjeta) {

    if (tarjeta == null) {
        return false;
    }
    
    String cardNumber = tarjeta.getCardNumber();
    String cvv = tarjeta.getCvv();
    String expirationDate = tarjeta.getExpirationDate();
    

    if (cardNumber == null || cardNumber.isEmpty() ||
        cvv == null || cvv.isEmpty() ||
        expirationDate == null || expirationDate.isEmpty()) {
        return false;
    }
    
    return true;
}
}
