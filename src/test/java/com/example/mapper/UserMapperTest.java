package com.example.mapper;

import com.example.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;

import java.util.List;
import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
class UserMapperTest {


    @Autowired
    UserMapper mapper;


    @Test
    void selectAllTest() {
        List<User> users = mapper.selectAll();
        assertEquals(35,users.size());
//        int count = users.size();
//        assertAll("ユーザー情報",
//                () -> assertEquals("test01", users.get(0).getId(),"idが一致"),
//                () -> assertEquals("テスト01", users.get(0).getUsername(),"名前が一致"),
//                () -> assertEquals("パスワード", users.get(0).getUsername(), "パスワードが一致"),
//                () -> assertEquals(5, count, "取得件数")
//    );
        //assertEquals(users.size(), users.size());
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
        //assertEquals(35, "yamashita")
//        for (User newUser : userList) {
//            System.out.println(newUser);

    }
}