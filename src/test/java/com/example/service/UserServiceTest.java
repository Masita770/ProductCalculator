package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService service;

    @Mock
    UserMapper mapper;

    @Test
    public void selectAllTest() {
        when(mapper.selectAll()).thenReturn(List.of(
                new User(1L,"Nagano", "33024"),
                new User(2L, "nakazima", "34287"),
                new User(3L, "Yamashita", "55435")
        ));
        List<User> users = service.getAll();
        assertEquals(3, users.size());
        List.of(new User(1L, "Nagano", "33024"),
                new User(2L, "nakazima", "34287"),
                new User(3L, "Yamashita", "55435"));
        verify(mapper).selectAll();
    }

    @Test
    void createTest() {
        User newUser = new User(1L, "yamazaki", "33463");
        doNothing().when(mapper).add(newUser);
        service.create(newUser);
        verify(mapper).add(newUser);
    }

//    @Test
//    void selectAllTest() {
//        List<User> users = mapper.selectAll();
//        int count = users.size();
//        assertAll("ユーザー情報取得",
//                () -> assertEquals("test01",users.get(0).getId(), "id一致"),
//                () -> assertEquals("テスト1", users.get(0).getUsername(), "名前一致"),
//                () -> assertEquals("test", users.get(0).getPassword(), "パスワード一致"),
//                () -> assertEquals(35, count, "取得件数")
//        );
//        List<User> users = service.getAll();
//        assertEquals(5L, users.size());
//        verify(mapper, times(1)).selectAll();
//    }
}