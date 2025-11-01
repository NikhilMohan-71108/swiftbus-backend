package com.swiftbus_backend.presentation.controller;


import com.swiftbus_backend.application.dto.UserRegisterDTO;
import com.swiftbus_backend.application.service.UserService;
import com.swiftbus_backend.domain.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
     public User registerUser(@RequestBody UserRegisterDTO dto){
        return userService.registerUser(dto);
    }
}
