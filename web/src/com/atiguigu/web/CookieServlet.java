package com.atiguigu.web;

import com.atiguigu.utils.CookieUtils;
import sun.security.ssl.CookieExtension;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1", "value1");
        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("key2", "value2");
        resp.addCookie(cookie1);
        resp.getWriter().write("cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            resp.getWriter().write(cookie.getName() + "=" + cookie.getValue());
//        }
        Cookie cookie = CookieUtils.findCookie("key1", cookies);
        if (cookie != null) {
            resp.getWriter().write("cookie:" + cookie.getName() + "=" + cookie.getValue());
        }
    }

    protected void setCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie = new Cookie("key1", "newValue");
//        resp.addCookie(cookie);
//
//        resp.addCookie(cookie);
//        resp.getWriter().write("cookie修改成功");
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtils.findCookie("key1", cookies);
        cookie.setValue("newValue1");
        resp.addCookie(cookie);
        resp.getWriter().write("cookie修改成功");


    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("deleteCookie", "deleteCookie");

        cookie.setMaxAge(0);
        resp.addCookie(cookie);

    }

    protected void deleteCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("deleteCookie", "deleteCookie");

        cookie.setMaxAge(60);
        resp.addCookie(cookie);

    }

    protected void setPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("setPath", "setPath");
        cookie.setPath(req.getContextPath() + "/abc");
        System.out.println(req.getContextPath());
        resp.addCookie(cookie);
        resp.getWriter().write("设置成功");
    }
}


