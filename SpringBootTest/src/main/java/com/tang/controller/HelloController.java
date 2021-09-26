package com.tang.controller;

import com.tang.domain.Student;
import com.tang.domain.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Student2 student;
    @Autowired
    private Student stu;
    @RequestMapping("/hello")
    public String hello(){
        return "HelloSpringBoot";
    }
    @RequestMapping("/test1")
    public String test()
    {
        return "test";
    }
}
