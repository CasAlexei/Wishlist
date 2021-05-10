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
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id){
        Users users = this.usersService.getUserById(id);
        if(users==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsersDto usersDto){
        Users users = this.usersService.addUser(usersDto);
        return new ResponseEntity<>("User added", HttpStatus.CREATED);
    }
}
