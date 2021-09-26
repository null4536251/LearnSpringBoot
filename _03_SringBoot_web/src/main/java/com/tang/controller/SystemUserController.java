package com.tang.controller;

import com.tang.domain.ResponseResult;
import com.tang.domain.SystemUser;
import com.tang.service.SystemUserService;
import com.tang.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@CrossOrigin
@RestController
@RequestMapping("/sys_user")
public class SystemUserController {

    @Autowired
    private SystemUserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody SystemUser user) {
        //校验用户名密码是否正确
        SystemUser loginUser = userService.login(user);
        //如果正确， 生成token返回
        Map<String, Object> map;
        if (loginUser != null) {
            map = new HashMap<>();
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getId()), null);
            map.put("token", token);
        }
        //如果不正确， 给出相应提示
        else {
            return new ResponseResult(300, "用户名或密码错误， 请重新登录");
        }
        return new ResponseResult(200, "登录成功", map);
    }

}
