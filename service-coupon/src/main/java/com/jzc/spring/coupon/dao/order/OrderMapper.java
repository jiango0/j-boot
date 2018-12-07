package com.jzc.spring.coupon.dao.order;

import com.jzc.spring.coupon.model.Order;
import com.jzc.spring.coupon.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
@Mapper
public interface OrderMapper {

    List<Order> selectOrders(@Param("ids") List<String> ids);

    List<OrderItem> selectOrderItem(@Param("ids") List<String> ids);

}
