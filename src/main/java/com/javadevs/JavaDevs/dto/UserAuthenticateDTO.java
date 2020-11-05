package com.javadevs.JavaDevs.dto;

import com.javadevs.JavaDevs.entity.User;

public class UserAuthenticateDTO {
    private String email;
    private String name;
    private String token;

    public UserAuthenticateDTO(String email, String name, String token) {
        this.email = email;
        this.name = name;
        this.token = token;
    }

    public UserAuthenticateDTO() {
    }

    public static UserAuthenticateDTO toDTO(User user) {
        return new UserAuthenticateDTO(user.getEmail(), user.getName(), user.getToken());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
