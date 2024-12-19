package com.project.auth_api.response;

public class LoginResponse {
    private String token;
    private long expiresIn;

    // Setter for token with chaining
    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    // Setter for expiresIn with chaining
    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}
