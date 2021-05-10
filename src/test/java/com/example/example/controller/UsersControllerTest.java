package com.example.example.controller;

import com.example.example.model.Users;
import com.example.example.model.UsersDto;
import com.example.example.repository.UsersRepository;
import com.example.example.service.UsersService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class UsersControllerTest {

    @InjectMocks
    UsersController usersControllerTest;
    private MockMvc mockMvc;
    @Mock
    private UsersService usersService;
    @Mock
    private UsersRepository usersRepository;

    Users user1;
    UsersDto usersDto1;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usersControllerTest).build();

        user1 = new Users();
        user1.setFullName("Alexei Casian");
        user1.setEmail("alexei@gmail.ru");
        user1.setPassword("12345678");
        user1.setRoleId("user");
    }

    @Test
    public void testGET_getUser_isOkIfUserPresent() throws Exception{
        System.out.println("-------------------------------------------start test1");
        when(usersService.getUserById(1L)).thenReturn(user1);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(status().isOk());
    }
    @Test
    public void testGET_getUserById_notFoundIfNotUserWithId() throws Exception {
        when(usersService.getUserById(1L)).thenReturn(user1);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/2")).andExpect(status().isNotFound());
    }
    @Test
    public void testGET_getUserById_isBadRequestIfUserIsNull() throws Exception {
        when(usersService.getUserById(1L)).thenReturn(user1);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/null")).andExpect(status().isNotFound());
    }
}