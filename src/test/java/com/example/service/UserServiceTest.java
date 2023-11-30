package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.domain.Users;
import com.example.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
                new Users(1,"Nagano", "33024"),
                new Users(2, "nakazima", "34287"),
                new Users(3, "Yamashita", "55435")
        ));
        List<Users> users = service.getAll();
        assertEquals(3, users.size());
        List.of(new Users(1, "Nagano", "33024"),
                new Users(2, "nakazima", "34287"),
                new Users(3, "Yamashita", "55435"));
        verify(mapper).selectAll();
    }

    @Test
    void createTest() {
        Users newUser = new Users(1, "yamazaki", "33463");
        doNothing().when(mapper).add(newUser);
        service.create(newUser);
        verify(mapper).add(newUser);
    }

    @Test
    void getListOne() {
        Mockito.doReturn(Optional.of(new Users(1, "takahashi", "33424"))).when(mapper).selectOne(1);
        Optional<Users> userTest = service.getListOne(1);
        Assertions.assertThat(userTest).isEqualTo(
                Optional.of(new Users(1, "takahashi", "33424")));
    }

    @Test
    void updateTest() {
//        doReturn(Optional.of(new User(1L, "yamazaki", "33463")))
//                .when(mapper).selectOne(1L);

//        Optional<User> userUpdate = Optional.of(new User(1L, "nalabati", "33324"));
        Users userUpdate = new Users(1, "nakabati", "33324");
        service.update( userUpdate);
        verify(mapper).update(userUpdate);
    }

    @Test
    void deleteTest() {
        Users deleteUser = new Users(1, "nakayama", "33344");
        service.delete(deleteUser);
        verify(mapper).delete(deleteUser);
    }
}