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

    public Users getUserById(long id){
        log.info("IN UsersService getUserById {}", id);
        return usersRepository.findById(id).orElse(null);
    }

    public Users addUser(UsersDto usersDto){
        Users user = new Users();

        // need to check fullname and email if is correct
        user.setEmail(usersDto.getEmail());
        user.setFullName(usersDto.getFullName());

        log.info("IN UsersService addUser {}", user.getFullName());

        return usersRepository.save(user);
    }

}
