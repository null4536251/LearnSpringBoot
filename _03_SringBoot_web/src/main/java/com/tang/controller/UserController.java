package com.tang.controller;

import com.tang.domain.ResponseResult;
import com.tang.domain.User;
import com.tang.resolver.CurrentUserId;
import com.tang.service.UserService;
import com.tang.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public ResponseResult insertUser(){
        userService.insertUser();
        return new ResponseResult(200, "添加成功");
    }
    @RequestMapping("/findAll")
    public ResponseResult findAll(@CurrentUserId String userId) throws Exception {
//        //获取请求头中的token
//        String token = request.getHeader("token");
//        if(StringUtils.hasText(token)){
//            //解析token获取用户id
//            Claims claims = JwtUtil.parseJWT(token);
//            String userId = claims.getSubject();
//            System.out.println("userId:" + userId);
//        }
        System.out.println(userId);
        //调用service查询数据，进行返回
        List<User> users = userService.findAll();
        return new ResponseResult(200, users);
    }

}
