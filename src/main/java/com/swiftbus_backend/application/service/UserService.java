package com.swiftbus_backend.application.service;

import com.swiftbus_backend.application.dto.UserRegisterDTO;
import com.swiftbus_backend.domain.model.User;
import com.swiftbus_backend.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CloudinaryService cloudinaryService;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CloudinaryService cloudinaryService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.cloudinaryService = cloudinaryService;
    }

    public User registerUser(UserRegisterDTO dto, MultipartFile profileImage){
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("Email already Registered");
        }

        String imageUrl=null;

        if(profileImage !=null && !profileImage.isEmpty()){
            imageUrl=cloudinaryService.uploadFile(profileImage);
        }

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .phoneNumber(dto.getPhoneNumber())
                .profileImageUrl(imageUrl)
                .role(User.Role.USER)
                .build();

        return  userRepository.save(user);

    }
}
