package com.swiftbus_backend.application.dto;


import lombok.Data;

@Data
public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String profileImageUrl;
}
