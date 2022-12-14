package com.mest.spring_security.server;

import com.mest.spring_security.domain.ResponseResult;
import com.mest.spring_security.domain.User;

public interface LoginService  {
    ResponseResult login(User user);

    ResponseResult logout();
}
