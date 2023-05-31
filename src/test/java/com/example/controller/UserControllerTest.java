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
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
//@Profile("UserControllerTest")
@WebMvcTest(value = UserController.class)
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
                .andExpect(model().attributeExists("list"))
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
//        User user1 = new User(1L, "nakazima,", "333432");
//        Long id = 1L;
//        Optional<User> user = Optional.of(new User(1L, "takahashi", "33343"));
        // Optionalの値が存在しないとHTML側の方でエラーが引っかかる
        Mockito.when(service.getListOne(Mockito.anyLong())).thenReturn(Optional.of(
                new User(1L, "takayama", "4422244")));

        mockMvc.perform(MockMvcRequestBuilders.get("/user/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(model().attributeDoesNotExist("user"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attributeDoesNotExist())
                .andExpect(MockMvcResultMatchers.view().name("user/user"))
                .andReturn();
    }

    @Test
    public void 権限無し() throws Exception {
        Integer id = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", id))
                .andExpect(status().is3xxRedirection());
    }

//    @Test
//    @WithMockUser
//    void 詳細検索() throws Exception {
////        User user = new User();
////        user.setId(1L);
////        user.setUsername("yamashita");
////        user.setPassword("33543");
//        Optional<User> user = Optional.of(new User(1L, "takahashi", "33343"));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/user", 1))
//                .andExpect(status().isOk());
//        mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("username", is(user.equals())));
//    }

    @Test
    @WithMockUser
    void updateTest() throws Exception {
        Mockito.when(service.getListOne(Mockito.anyLong())).thenReturn(Optional.of(
                new User(1L, "tukishima", "443244")));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/update/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attributeExists("userUpdate"))
                .andExpect(MockMvcResultMatchers.view().name("user/update"))
                .andReturn();
    }

//    public User testData() {
//        Optional<User> user1 = new Optional<User> User();
//
//        user.setId(1L);
//        user.setUsername("kobayashi");
//        user.setPassword("333422");
//        return user1;
//    }

}