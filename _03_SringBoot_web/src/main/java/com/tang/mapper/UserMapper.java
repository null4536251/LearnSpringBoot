package com.tang.mapper;

import com.tang.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    List<User> findAll();

    void insertUser(User user);
}
