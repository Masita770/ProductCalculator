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

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    void 一件検索() throws Exception{
//        Mockito.when(user.getId()).thenReturn(1L, "kobayashi", "333424");
//                Mockito.when(service.getListOne(1L)).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/user/{id}", 1L))
                .with(user("user").roles("user")
                .andExpect(MockMvcResultMatchers.status().isNoContent()));
//                .andExpect(MockMvcResultMatchers.model()
////                        .attribute("user", Matchers.hasItem(1L, "kobayashi", "33323")));
//                        .attribute("user", User(1L, "kobayashi", "33324"));
//                .andExpect(MockMvcResultMatchers.status().isFound())
//                .andExpect(model().attribute("user", (1L, "yamashita", "224442")));
    }
}