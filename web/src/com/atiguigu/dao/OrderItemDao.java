package com.atiguigu.dao;

import com.atiguigu.dao.impl.BaseDao;
import com.atiguigu.pojo.OrderItem;

public interface OrderItemDao  {
    public int saveOrderItem(OrderItem orderItem);
}
