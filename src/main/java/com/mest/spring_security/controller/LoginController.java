package com.mest.spring_security.controller;

import com.mest.spring_security.domain.ResponseResult;
import com.mest.spring_security.domain.User;
import com.mest.spring_security.server.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring_security
 * @description:
 * @author: Mest
 * @create: 2022-11-20 23:21
 **/

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/hello")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
//    @PreAuthorize("hasAuthority('system:dept:list')")
    public String hello() {
        return "hello";
    }


    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {

        return loginService.login(user);

    }

    @RequestMapping("/user/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }
}
