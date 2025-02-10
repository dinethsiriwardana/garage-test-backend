package com.kushan.garage_backend.entity;

import lombok.Data;

@Data
public class LoginResponse {
    private String role;
    private String message;
    private String redirectUrl;

    public LoginResponse(String role, String message,String redirectUrl) {
        this.role = role;
        this.message = message;
        this.redirectUrl = redirectUrl;
    }

    // Getters and Setters
}
