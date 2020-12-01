package com.jzc.spring.boot.order.service;

import com.jzc.spring.boot.order.dto.SubOrderDTO;
import com.jzc.spring.boot.order.entity.SubOrder;

public interface SubOrderService {

    void save(SubOrder subOrder);

    int update(SubOrderDTO subOrderDTO);

}
