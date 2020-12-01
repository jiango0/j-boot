package com.jzc.spring.boot.order.controller;

import com.jzc.spring.boot.order.dto.SubOrderDTO;
import com.jzc.spring.boot.order.entity.SubOrder;
import com.jzc.spring.boot.order.service.SubOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sub/order")
public class SubOrderController {

    @Autowired
    private SubOrderService subOrderService;

    @RequestMapping(value = "save")
    public void save(@RequestBody SubOrder subOrder) {
        subOrderService.save(subOrder);
    }

    @RequestMapping(value = "update")
    public int update(@RequestBody SubOrderDTO subOrderDTO) {
        return subOrderService.update(subOrderDTO);
    }

}
