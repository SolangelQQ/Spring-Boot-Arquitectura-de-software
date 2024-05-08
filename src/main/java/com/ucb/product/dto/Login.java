package com.ucb.product.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Login {
    @Email
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String password;

    public Login() {
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
