package com.atiguigu.service.impl;

import com.atiguigu.dao.BookDao;
import com.atiguigu.dao.OrderDao;
import com.atiguigu.dao.OrderItemDao;
import com.atiguigu.dao.impl.BookDaoImpl;
import com.atiguigu.dao.impl.OrderDaoImpl;
import com.atiguigu.dao.impl.OrderItemImpl;
import com.atiguigu.pojo.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        // 创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);
int i=12/0;
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {

            CartItem cartItem = entry.getValue();

            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);

            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
