package com.tang.interceptor;

import com.tang.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的token
        String token = request.getHeader("token");
        //判断token是否为空
        if (!StringUtils.hasText(token)) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("未登录， 请登录后重试");
        }
        //解析token判断是否成功
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String subject = claims.getSubject();
            System.out.println(subject);
        } catch (Exception e) {
            e.printStackTrace();
            //如果解析过程中没有异常，说明是登录状态
            //如果出现异常，说明未登录，发送提示(401)
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
