package com.kushan.garage_backend.service;

import com.kushan.garage_backend.entity.User;

import java.util.Optional;

public interface UserService {
    void createCustomer(User user);

    Optional<User> findByEmail(String email);
}
