package com.atiguigu.service.impl;

import com.atiguigu.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
