package com.atiguigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet1 extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            System.out.println("登录成功");
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
        } else {
            System.out.println("登陆失败");
        }
    }
}
