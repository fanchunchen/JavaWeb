package com.atiguigu.web;

import com.atiguigu.pojo.Book;
import com.atiguigu.pojo.Cart;
import com.atiguigu.pojo.CartItem;
import com.atiguigu.service.impl.BookService;
import com.atiguigu.service.impl.BookServiceImpl;
import com.atiguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void cartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        System.out.println(id);


        Book book = bookService.queryBookById(id);
       req.getSession().setAttribute("lastName",book.getName());
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice()));

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.deleteItem(id);

        resp.sendRedirect(req.getHeader("Referer"));


    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("cart");
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Cart cart= (Cart) req.getSession().getAttribute("cart");
      Integer id=WebUtils.parseInt(req.getParameter("id"),0);
      Integer count=WebUtils.parseInt(req.getParameter("count"),0);
      cart.updateCount(id,count);
      resp.sendRedirect(req.getHeader("Referer"));
    }

}
