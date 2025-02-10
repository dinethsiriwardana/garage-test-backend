package com.kushan.garage_backend.controller;

import com.kushan.garage_backend.entity.User;
import com.kushan.garage_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class UserController {

    @Autowired
    private UserService userService;

    //Build Add Customer REST API
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.createCustomer(user);

        return "success add user";
    }
}
