package com.example.example.controller;

import com.example.example.model.UsersDto;
import com.example.example.model.Users;
import com.example.example.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UsersService usersService;

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Integer id){
        Users user = this.usersService.getUserById(id);
        return user;
    }

    @GetMapping("/hello")
    public String getUser(){
        return "Hello my friend";
    }

    @PostMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody UsersDto usersDto){
        return new ResponseEntity<>("User added", HttpStatus.CREATED);
    }
}
