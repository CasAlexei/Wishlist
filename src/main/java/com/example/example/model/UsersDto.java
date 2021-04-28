package com.example.example.model;

import lombok.Data;

@Data
public class UsersDto {
    private String fullName;
    private String email;
    private String password;
    private String roleId;
}
