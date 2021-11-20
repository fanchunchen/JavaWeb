package com.atiguigu.test;

import com.atiguigu.dao.OrderItemDao;
import com.atiguigu.dao.impl.OrderItemImpl;
import com.atiguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null, "java从入门到放弃", 1, new BigDecimal(100), new BigDecimal(100), "123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaScript", 1, new BigDecimal(100), new BigDecimal(100), "123456789"));
    }
}