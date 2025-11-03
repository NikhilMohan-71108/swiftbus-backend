package com.swiftbus_backend.presentation.controller;


import com.swiftbus_backend.application.dto.UserRegisterDTO;
import com.swiftbus_backend.application.service.UserService;
import com.swiftbus_backend.domain.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

     @PostMapping(value = "/register",consumes = {"multipart/form-data"})
     public ResponseEntity<User> registerUser(
             @RequestPart("user") UserRegisterDTO userDto,
             @RequestPart(value = "profileImage",required = false) MultipartFile profileImage
     ){
        User savedUser = userService.registerUser(userDto,profileImage);
        return ResponseEntity.ok(savedUser);
     }
}
