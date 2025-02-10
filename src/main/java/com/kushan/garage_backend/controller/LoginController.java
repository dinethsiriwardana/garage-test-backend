package com.kushan.garage_backend.controller;

import com.kushan.garage_backend.entity.User;
import com.kushan.garage_backend.service.UserService;
import com.kushan.garage_backend.entity.LoginRequest;
import com.kushan.garage_backend.entity.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userService.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + loginRequest.getEmail()));


        if (user != null) {
            String redirectUrl;
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                redirectUrl = "/admin/home";
            } else if ("CUSTOMER".equalsIgnoreCase(user.getRole())) {
                redirectUrl = "/customer/home";
            } else {
                redirectUrl = "/default";
            }
            return new LoginResponse(user.getRole(), "Login successful", redirectUrl);
        } else {
            return new LoginResponse(null, "User not found", null);
        }
    }
}
