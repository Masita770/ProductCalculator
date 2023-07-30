package com.example.mapper;

import com.example.domain.User;
import com.example.service.UserService;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@DBRider
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
class UserMapperTest {

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
        List<User> tests = mapper.selectAll();
        org.assertj.core.api.Assertions.assertThat(tests)
                .hasSize(1)
                .contains(
                        new User(1L, "yamashita", "444535")
                );
//        List<User> users = mapper.selectAll();
//        Mockito.doReturn(testUsers).when(mapper).selectAll();
//        List<User> testUser = service.getAll();
//        assertEquals(1,testUser.size());
    }

    private User createUsers() {
        User user = new User(1L, "yamashita", "33282");
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
//        Mockito.doReturn(Optional.of(user)).when(mapper).selectOne(1L);
//        Optional<User> testUser1 = service.getListOne(1L);
//        //Optional<User> user = mapper.selectOne(1L);
//        Assertions.assertThat(testUser1).isEqualTo(
//                Optional.of(new User(1L, "takahashi", "334532")));
    }

    @Test
    void updateTest() throws Exception {
        User userUpdate = new User(1L, "yamazaki", "44424");
        mapper.update(userUpdate);
        System.out.println(userUpdate);
    }

    @Test
    void deleteTest() {
        User deleteUser = new User(1L, "yamazaki", "333243");
        mapper.delete(deleteUser);
    }
}