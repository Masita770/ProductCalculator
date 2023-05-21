package com.example.mapper;

import com.example.domain.User;
import com.example.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
class UserMapperTest {

    @InjectMocks
    UserService service;

    @Mock
    UserMapper mapper;
    List testUsers = List.of(
            new User(1L, "yamashita", "3344"));
    User user = new User(1L, "takahashi", "334532");


    @Test
    void selectAllTest() {
//        List<User> users = mapper.selectAll();
        Mockito.doReturn(testUsers).when(mapper).selectAll();
        List<User> testUser = service.getAll();
        assertEquals(1,testUser.size());
    }

    private User createUsers() {
        User user = new User();
        user.setId(1L);
        user.setUsername("yamashita");
        user.setPassword("33282");
        return user;
    }

    @Test
    void insertTest() {
        User newUser = new User(1L, "yamashita", "33453");
        mapper.add(newUser);
       System.out.println(newUser);
    }

    @Test
    void selectOneTest() throws Exception {
        Mockito.doReturn(Optional.of(user)).when(mapper).selectOne(1L);
        Optional<User> testUser1 = service.getListOne(1L);
        //Optional<User> user = mapper.selectOne(1L);
        Assertions.assertThat(testUser1).isEqualTo(
                Optional.of(new User(1L, "takahashi", "334532")));
    }
}