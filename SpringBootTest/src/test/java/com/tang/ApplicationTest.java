package com.tang;

import com.tang.controller.HelloController;
import com.tang.domain.User;
import com.tang.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    private HelloController helloController;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testJunit(){
        System.out.println(1);
        System.out.println(helloController);
    }
    @Test
    public void testMapper(){
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }
}

