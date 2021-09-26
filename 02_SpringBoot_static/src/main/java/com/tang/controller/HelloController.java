package com.tang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/testPath")
    public String testPath(){
        return "testPath";
    }
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod处理了请求");
        return "testMethod";
    }
}
