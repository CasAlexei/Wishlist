package com.example.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class Users {

    @Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name ="full_name")
    private String fullName;
    @Column(name ="email")
    private String email;

    public static Users from(UsersDto usersDto) {
        return builder()
                .fullName(usersDto.getFullName())
                .email(usersDto.getEmail())
                .build();
    }
}
