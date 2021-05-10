package com.example.example.service;

import com.example.example.model.Users;
import com.example.example.model.UsersDto;
import com.example.example.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public Users getUserById(Long id){
        log.info("IN UsersService getUserById {}", id);
        return usersRepository.findById(id).orElse(null);
    }

    public Users addUser(UsersDto usersDto){
        Users users = new Users();

        // need to check fullName and email if is correct
        users.setEmail(usersDto.getEmail());
        users.setFullName(usersDto.getFullName());
        users.setPassword(usersDto.getPassword());
        users.setRoleId(usersDto.getRoleId());

        log.info("IN UsersService addUser {}", users.getFullName());

        return usersRepository.save(users);
    }

}
