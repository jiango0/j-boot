package com.jzc.spring.boot.order.controller;

import com.jzc.spring.boot.common.web.ResultEntity;
import com.jzc.spring.boot.order.entity.Order;
import com.jzc.spring.boot.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "save")
    public ResultEntity<Integer> save(@RequestBody Order order) {
        orderService.save(order);
        return ResultEntity.returnSuccess(1);
    }

    @RequestMapping(value = "run")
    public ResultEntity<Integer> run (@RequestBody Order order) {
        return ResultEntity.returnSuccess(1);
    }

}
