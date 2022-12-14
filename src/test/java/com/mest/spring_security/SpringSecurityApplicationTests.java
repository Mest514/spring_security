package com.mest.spring_security;

import com.mest.spring_security.domain.User;
import com.mest.spring_security.mapper.MenuMapper;
import com.mest.spring_security.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class SpringSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void TestBCryptPasswordEncoder() {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
        //$2a$10$kIRFMcTohMDQvI8TT29tl.hYJBKtTh61SceUPjwkAOMSp8Z2N0zdy
        System.out.println(passwordEncoder.matches("1234", encode));
    }

    @Test
    public void selectPermsByUserId() {
        List<String> list = menuMapper.selectPermsByUserId(2l);
        System.out.println(list);
    }
}

