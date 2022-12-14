package com.mest.spring_security.handler;

import com.alibaba.fastjson.JSON;
import com.mest.spring_security.domain.ResponseResult;
import com.mest.spring_security.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring_security
 * @description: 自定义失败处理
 * @author: Mest
 * @create: 2022-12-06 22:23
 **/
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //处理异常
        ResponseResult result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败，请重新登录");

        String json = JSON.toJSONString(result);
        //使用WebUtil工具类处理异常
        WebUtils.renderString(response, json);

    }
}
