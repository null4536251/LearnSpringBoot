package com.tang.controller;

import com.tang.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String insertUser(@RequestBody List<User> users) {
        System.out.println(users);
        return "insertUser";
    }

    //    @RequestMapping("testRequestParam")
//    public String testRequestParam(Integer id, String name, String[] likes){
//        System.out.println("testRequestParam");
//        System.out.println(id);
//        System.out.println(name);
//        System.out.println(Arrays.toString(likes));
//        return "testRequestParam";
//    }
    @RequestMapping("testRequestParam")
    public String testRequestParam(User user) {
        System.out.println("testRequestParam");
        System.out.println(user);
        return "testRequestParam";
    }
}
