package com.swiftbus_backend.domain.repository;

import com.swiftbus_backend.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save (User user);
    Optional<User> findByEmail(String email);
}
