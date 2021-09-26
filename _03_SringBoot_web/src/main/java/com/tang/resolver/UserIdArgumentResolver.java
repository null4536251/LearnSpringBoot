package com.tang.resolver;

import com.tang.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {

    //判断方法参数是否能使用当前的参数解析器进行解析
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果方法参数有加上CurrentUserId注解，就能被解析器解析
        System.out.println(111);
        return parameter.hasParameterAnnotation(CurrentUserId.class);
    }

    //进行参数解析的方法，可以在方法中获取对应的数据，然后把数据作为返回值返回，方法的返回值就会赋值给对应的方法参数
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //获取请求头中的token
        String token = webRequest.getHeader("token");
        if (StringUtils.hasText(token)) {
            //解析token，返回userId
            Claims claims = JwtUtil.parseJWT(token);
            String userId = claims.getSubject();
            //返回结果
            return userId;
        }
        return null;
    }
}
