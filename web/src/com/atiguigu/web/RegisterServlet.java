package com.atiguigu.web;

import com.atiguigu.pojo.User;
import com.atiguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("6n6np".equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                req.setAttribute("msg", "用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
                System.out.println("用户名" + username + "已存在");
            } else {
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.setAttribute("msg", "验证码输入错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            System.out.println("验证码输入错误");
        }

    }
}
