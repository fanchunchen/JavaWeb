package com.atiguigu.web;

import com.atiguigu.pojo.Cart;
import com.atiguigu.pojo.User;
import com.atiguigu.service.impl.OrderService;
import com.atiguigu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /*** 生成订单 ** @param req * @param resp * @throws ServletException * @throws IOException */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取 Cart 购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = loginUser.getId();
        orderService.createOrder(cart, userId);
        String orderId = orderService.createOrder(cart, userId);
        req.setAttribute("orderId", orderId);

//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}