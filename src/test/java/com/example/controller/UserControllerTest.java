package com.example.controller;


import com.example.domain.User;
import com.example.service.UserService;
import org.apache.ibatis.javassist.NotFoundException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@AutoConfigureMockMvc
//@Profile("UserControllerTest")
@WebMvcTest
class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Mock
    User user;

    @MockBean
    private UserService service;

    @InjectMocks
    UserController controller;

//    @BeforeEach
//    private void setup() {
//        MockitoAnnotations.openMocks(this);
//        this.id = 5;
//    }


    @Test
    @WithMockUser
    void listTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("user/list"))
                .andReturn();
    }


    @Test
    @WithMockUser
    void insertTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/form")
                .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("user/form"));
    }
    @Test
    @WithMockUser
    void editヘ遷移() throws Exception {
        mockMvc.perform((MockMvcRequestBuilders.post("/user/edit"))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .param("nakazima", "33342"))
                        .andExpect(MockMvcResultMatchers.status().isFound())
                        .andExpect(MockMvcResultMatchers.view().name("redirect:list"));
    }

    @Test
    @WithMockUser
    void getListOneTest() throws Exception{
//        Long id = 1L;
//        String username = "yamahashi";
//        String password = "88979";

        mockMvc.perform(MockMvcRequestBuilders.get("/user/user",1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attributeDoesNotExist("user/user"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attributeDoesNotExist())
                .andExpect(MockMvcResultMatchers.view().name("user/user"));
    }

    @Test
    @WithMockUser
    void updateTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/update/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("user/update"))
                .andReturn();
    }
}