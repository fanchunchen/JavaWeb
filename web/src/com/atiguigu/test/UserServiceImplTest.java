package com.atiguigu.test;

import com.atiguigu.pojo.User;
import com.atiguigu.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
UserServiceImpl userService=new UserServiceImpl();
    @Test
    void registUser() {
       userService.registUser(new User(null,"admin1","admin","admin@163.com"));
    }

    @Test
    void login() {
        System.out.println(userService.login(new User(null,"admin","admin","admin@163.com")));
    }

    @Test
    void existsUsername() {
        System.out.println(userService.existsUsername("admin"));;
    }
}