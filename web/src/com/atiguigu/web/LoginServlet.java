package com.atiguigu.web;

import com.atiguigu.pojo.User;
import com.atiguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if(userService.login(new User(null,username,password,null))==null){
            System.out.println("用户名或密码错误");
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登陆成功");
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
