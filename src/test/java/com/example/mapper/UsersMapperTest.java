package com.example.mapper;

import com.example.domain.Users;
import com.example.service.UserService;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@DBRider
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
class UsersMapperTest {

    @InjectMocks
    UserService service;

//    @Mock
    @Autowired
    UserMapper mapper;
//    List testUsers = List.of(
//            new User(1L, "yamashita", "3344"));
//    User user = new User(1L, "takahashi", "334532");


    @Test
//    @DataSet("dbunit.yml")
//    @ExpectedDataSet("test.yml")
    @DataSet(value = "test/tests.yml", cleanAfter = true)
//    @ExpectedDataSet("test/tests-expected.yml")
//    @ExpectedDataSet(value = "users.yml")
//    @DataSet("test.yml")
//    @ExpectedDataSet("tests-expected.yml")
//    @Sql(scripts = {"classpath:/selectAll-test.sql"},
//            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    void selectAllTest() {
        List<Users> tests = mapper.selectAll();
        org.assertj.core.api.Assertions.assertThat(tests)
//                .hasSize(
//        org.assertj.core.api.Assertions.assertThat(tests).isNotNull();
//        org.assertj.core.api.Assertions.assertThat(tests.stream().count()).isEqualTo(3L);
//        mapper.selectAll(tests).ifPresents
                .hasSize(1)
                .contains(
                        new Users(1, "yamashita", "444535")
                );
//        List<User> users = mapper.selectAll();
//        Mockito.doReturn(testUsers).when(mapper).selectAll();
//        List<User> testUser = service.getAll();
//        assertEquals(1,testUser.size());
    }

//    private User createUsers() {
//        User user = new User(1L, "yamashita", "33282");
//        user.setId(1L);
//        user.setUsername("yamashita");
//        user.setPassword("33282");
//        return user;
//    }

    @Test
    @DataSet(value = "test/tests.yml", cleanAfter = true)
    @Transactional
    void insertTest() {
        Users newUsers = new Users(1, "yamashita", "33453");
        mapper.add(newUsers);
       System.out.println(newUsers);
    }

    @Test
    @DataSet(value = "test/tests.yml", cleanAfter = true)
    @Transactional
    void selectOneTest() throws Exception {
//        Mockito.doReturn(Optional.of(user)).when(mapper).selectOne(1L);
        Optional<Users> testUser1 = mapper.selectOne(1);

//        //Optional<User> user = mapper.selectOne(1L);
        Assertions.assertThat(testUser1).isEqualTo(
                Optional.of(new Users(1, "takahashi", "334532")));
    }

    @Test
    @DataSet(value = "test/tests.yml", cleanAfter = true)
    @Transactional
    void updateTest() throws Exception {
        Users usersUpdate = new Users(1, "yamazaki", "44424");
        mapper.update(usersUpdate);
        System.out.println(usersUpdate);
    }

    @Test
    @DataSet(value = "test/test.yml", cleanAfter = true)
    @Transactional
    void deleteTest() {
        Users deleteUsers = new Users(1, "yamazaki", "333243");
        mapper.delete(deleteUsers);
    }
}