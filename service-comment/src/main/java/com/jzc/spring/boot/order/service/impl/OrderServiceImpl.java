package com.jzc.spring.boot.order.service.impl;

import com.jzc.spring.boot.order.dao.OrderMongoDao;
import com.jzc.spring.boot.order.entity.Order;
import com.jzc.spring.boot.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMongoDao orderMongoDao;

    public void save (Order order) {
        orderMongoDao.insert(order);
    }

}
