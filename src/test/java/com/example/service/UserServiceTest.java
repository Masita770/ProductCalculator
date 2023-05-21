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
import java.util.Optional;

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

    @Test
    void getListOne() {
        Mockito.doReturn(Optional.of(new User(1L, "takahashi", "33424"))).when(mapper).selectOne(1L);
        Optional<User> userTest = service.getListOne(1L);
        Assertions.assertThat(userTest).isEqualTo(
                new User(1L, "takahashi", "33424"));
    }
}