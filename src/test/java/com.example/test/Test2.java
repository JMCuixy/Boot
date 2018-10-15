package com.example.test;

import com.example.Example;
import com.example.entity.User;
import com.example.service.UserSercice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class Test2 {

    @MockBean
    private UserSercice userSercice;

    @Test
    public void test2(){
        User user = new User("111111", "张三", "15980292662", 23, 1);
        given(this.userSercice.getUserByUuid("111111")).willReturn(user);
        User userByUuid = userSercice.getUserByUuid("111111");
        System.out.println(userByUuid);
    }
}
