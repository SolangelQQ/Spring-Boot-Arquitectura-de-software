package com.ucb.product.dto;

import javax.validation.constraints.NotEmpty;

public class tarjeta {
    @NotEmpty
    private String cardNumber;
    
    @NotEmpty
    private String cvv;
    
    @NotEmpty
    private String expirationDate;

    public tarjeta() {
        // Constructor vacío requerido por algunas bibliotecas/frameworks
    }

    public tarjeta(String cardNumber, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
