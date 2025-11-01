package com.swiftbus_backend.infrastructure.repository;


import com.swiftbus_backend.domain.model.User;
import com.swiftbus_backend.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface  JpaUserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaRepo;

    public UserRepositoryImpl(JpaUserRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public User save(User user) {
        return jpaRepo.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepo.findByEmail(email);
    }
}
