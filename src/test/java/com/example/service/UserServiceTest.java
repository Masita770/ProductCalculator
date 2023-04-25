package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserMapper mapper;

    @InjectMocks
    UserService service;

    User User;

//    @Test
//    void getListOne() {
//        Long id = 1L;
//        String username = "yamashita";
//        String password = "33302";
//        Optional<User> user = service.getListOne(id);
//        assertAll("取得結果確認",
//                () -> assertEquals(1L, User.getId(), "id一致"),
//                () -> assertEquals("yamashita", User.getUsername()), "usernameが一致"
//                );
//                assertEquals(1L, User.getId());



    //}
//    private User user() {
//        int id = 1;
//        String username = "yamashita";
//        String password = "33302";
//        return null;
//    }

//    @Mock
//    List<User> testUser = getAll(1,'yashima',2222);

//    @Test
//    void test() {
//        doReturn(List.of(new User(1, "hon"))).when(mapper).selectAll();
//
//        List<User> users = service.getAll();
//        assertThat(users).isEqualTo(
//                List.of(new User(1, "hon");
//                        verify(mapper).selectAll();
//
//    }
//
//    @Test
//    void Test1() {
//        User user = mock(User.class);
//        doReturn(List.of(user).when(user).method());
//    }
}