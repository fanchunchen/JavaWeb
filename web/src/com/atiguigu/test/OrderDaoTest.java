package com.atiguigu.test;

import com.atiguigu.dao.OrderDao;
import com.atiguigu.dao.impl.OrderDaoImpl;
import com.atiguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();

        System.out.println(orderDao.saveOrder(new Order("123456789", new Date(), new BigDecimal(100), 0, 1)));
    }
}