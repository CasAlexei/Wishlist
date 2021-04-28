package com.example.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name ="full_name")
    private String fullName;
    @Column(name ="email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role_id")
    private String roleId;

    public static Users from(UsersDto usersDto) {
        return builder()
                .fullName(usersDto.getFullName())
                .email(usersDto.getEmail())
                .password(usersDto.getPassword())
                .roleId(usersDto.getRoleId())
                .build();
    }
}
