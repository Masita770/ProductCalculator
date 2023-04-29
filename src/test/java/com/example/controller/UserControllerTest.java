package com.example.controller;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.web.servlet.function.ServerResponse.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {



    @InjectMocks
    private UserController controller;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void list() throws Exception {
//        User users = new User(1L, "nakayama", "889348");
//        List<User> usersTest = new ArrayList<>();
//        usersTest.add(users);
        MvcResult mvcResult = mockMvc.perform(get("/user/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("list"))
                .andReturn();
                //.andExpect(MockMvcResultMatchers.model().attribute("message", "hello world");
    }


    @Test
    void insertTest() throws Exception {
        mockMvc.perform(post("/user/form"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((MockMvcResultMatchers.view().name("form")));
    }
}