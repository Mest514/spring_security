package com.mest.spring_security.expression;

import com.mest.spring_security.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: spring_security
 * @description: 自定义权限校验方法
 * @author: Mest
 * @create: 2022-12-07 21:50
 **/
@Component("ex")
public class SGExpressionRoot {
    public boolean hasAuthority(String authority) {

        //获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        //判断用户权限集合中是否存在authority
        return permissions.contains(authority);
    }

}
