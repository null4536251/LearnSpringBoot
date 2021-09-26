package com.tang.service;

import com.tang.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void insertUser();

}
