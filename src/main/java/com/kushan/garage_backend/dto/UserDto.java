package com.kushan.garage_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private Date dateJoin;
    private int age;
    private String gender;
    private String nationality;
    private String nic;
    private String email;
    private String password;
    private String role;
}
