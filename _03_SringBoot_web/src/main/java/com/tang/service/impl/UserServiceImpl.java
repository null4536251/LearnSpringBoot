package com.tang.service.impl;

import com.tang.aop.InvokeLog;
import com.tang.domain.User;
import com.tang.mapper.UserMapper;
import com.tang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @InvokeLog
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    @Transactional
    public void insertUser() {
        //添加2个用户到数据库
        User user = new User(null, "sg666", 15, "上海");
        User user2 = new User(null, "sg777", 16, "上海");
        userMapper.insertUser(user);
        userMapper.insertUser(user2);
    }
}
