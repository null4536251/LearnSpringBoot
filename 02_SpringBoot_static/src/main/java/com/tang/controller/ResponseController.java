package com.tang.controller;

import com.tang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {
    @RequestMapping("/user/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") Integer id){
        User user = new User(id, "tang", 15);
        return user;

    }
}
