package com.atiguigu.test;

import com.atiguigu.dao.impl.UserDaoImpl;
import com.atiguigu.pojo.User;

class UserDaoImplTest {

    @org.junit.jupiter.api.Test
    void queryUserByUsername() {
        UserDaoImpl userDao=new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @org.junit.jupiter.api.Test
    void queryUserByUsernameAndPassword() {
        UserDaoImpl userDao=new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPassword("admin","admin"));
    }

    @org.junit.jupiter.api.Test
    void saveUser() {
        UserDaoImpl userDao=new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(1,"admin1","admin1","admin@163.com")));
    }
}