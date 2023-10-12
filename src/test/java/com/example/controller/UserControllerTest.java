package com.example.controller;


import com.example.domain.User;
import com.example.service.UserService;
import org.apache.ibatis.javassist.NotFoundException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
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
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
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
        // Optionalの値が存在しないとHTML側の方でエラーが引っかかる
        Mockito.when(service.getListOne(Mockito.any())).thenReturn(Optional.of(
                new User(1, "takayama", "4422244")));

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
        Mockito.when(service.getListOne(Mockito.any())).thenReturn(Optional.of(
                new User(1, "tukishima", "443244")));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/update/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attributeExists("userUpdate"))
                .andExpect(MockMvcResultMatchers.view().name("user/update"))
                .andReturn();
    }

    @Test
    @WithMockUser
    void deleteOneTest() throws Exception {
        Mockito.when(service.getListOne(1)).thenReturn(Optional.of(
                new User(1, "nakazma", "77699")));
        mockMvc.perform(MockMvcRequestBuilders.post("/user/deletePause/1")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(model().attributeExists("user"))
                        .andExpect(MockMvcResultMatchers.view().name("/user/deletePause"))
                        .andReturn();
    }
    @Test
    void deleteTest() throws Exception{
//        Mockito.when(service.delete(1L)).thenReturn(Optional.of(
//                new User(1L, "takahashi", "333442")));
       mockMvc.perform(MockMvcRequestBuilders.post("/user/delete/1")
               .param("id", "1")
               .with(csrf()))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(redirectedUrl("user/delete"))
               .andExpect(MockMvcResultMatchers.view().name("user/delete"));
    }
}