package com.jzc.spring.boot.order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * OrderBaseEntity
 *
 * @author baoxiongwei
 * @version [V1.0, 2019-03-08]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OrderBaseEntity {
    /** 订单编号 */
    @JsonProperty("OrderBaseEntity_order_code")
    protected String order_code;

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }
}
