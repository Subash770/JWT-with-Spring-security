package com.project.auth_api.dto;

public class RegisterUserDto {
    private String fullName;
    private String email;
    private String password;

    // Setter methods with fluent return
    public RegisterUserDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public RegisterUserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    // Getter methods (if needed)
    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
