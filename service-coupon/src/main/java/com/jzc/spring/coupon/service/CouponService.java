package com.jzc.spring.coupon.service;

import com.jzc.spring.coupon.dao.coupon.CouponMapper_My;
import com.jzc.spring.coupon.dao.order.OrderMapper;
import com.jzc.spring.coupon.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class CouponService {

    @Autowired
    CouponMapper_My couponMapper_my;

    @Autowired
    OrderMapper orderMapper;

    public List<CouponExcel> selectCustomerCoupon(Date start, Date end, String partner_id, Integer dateType) {
        List<CouponExcel> list = new ArrayList<>();
        List<String> couponIds = new ArrayList<>();
        List<String> couponCodes = new ArrayList<>();

        List<CustomersCoupon> customersCoupons = couponMapper_my.selectCustomersCoupon(start, end, partner_id, dateType);
        if(!CollectionUtils.isEmpty(customersCoupons)) {
            customersCoupons.forEach(customersCoupon -> {
                if(!couponIds.contains(customersCoupon.getCoupon_id())) {
                    couponIds.add(customersCoupon.getCoupon_id());
                }
                if( Integer.valueOf(2).equals(customersCoupon.getCoupon_status()) ) {
                    couponCodes.add(customersCoupon.getCoupon_code());
                }

                CouponExcel couponExcel = new CouponExcel();
                couponExcel.setCouponCode(customersCoupon.getCoupon_code());
                couponExcel.setCouponId(customersCoupon.getCoupon_id());
                couponExcel.setCouponName(customersCoupon.getCoupon_name());
                couponExcel.setCustomerId(customersCoupon.getCustomer_id());
                couponExcel.setCustomerName(customersCoupon.getCustomer_name());
                couponExcel.setDate_activation(customersCoupon.getDate_activation());
                couponExcel.setDate_consume(customersCoupon.getDate_consume());
                couponExcel.setShopId(customersCoupon.getShop_guid());
                couponExcel.setCouponStatus(this.getCouponStatus(customersCoupon.getCoupon_status()));

                list.add(couponExcel);
            });

            Map<String, Coupon> stringCouponMap = null;
            if(!couponIds.isEmpty()) {
                stringCouponMap = this.selectCoupon(couponIds);
            }
            Map<String, CouponConsume> stringCouponConsumeMap = null;
            if(!couponCodes.isEmpty()) {
                stringCouponConsumeMap = this.selectCouponConsume(couponCodes);
            }

            List<String> orderCodes = new ArrayList<>();
            for(CouponExcel couponExcel : list) {
                if(stringCouponMap != null && !stringCouponMap.isEmpty()) {
                    Coupon coupon = stringCouponMap.get(couponExcel.getCouponId());
                    if(coupon != null) {
                        couponExcel.setDeductible(coupon.getDeductible());
                    }
                }

                if(stringCouponConsumeMap != null && !stringCouponConsumeMap.isEmpty()) {
                    CouponConsume couponConsume = stringCouponConsumeMap.get(couponExcel.getCouponCode());
                    if(couponConsume != null) {
                        couponExcel.setOrderCode(couponConsume.getOrders_code());
                        orderCodes.add(couponConsume.getOrders_code());
                    }
                }
            }

            Map<String, Order> stringOrderMap = null;
            Map<String, OrderItem> stringOrderItemMap = null;
            if(!orderCodes.isEmpty()) {
                stringOrderMap = this.selectOrder(orderCodes);
                stringOrderItemMap = this.selectOrderItem(orderCodes);
            }

            for(CouponExcel couponExcel : list) {
                if(stringOrderMap != null && !stringOrderMap.isEmpty()) {
                    Order order = stringOrderMap.get(couponExcel.getOrderCode());
                    if(order != null) {
                        couponExcel.setPeeAmount(order.getPayable_fee());
                    }
                }

                if(stringOrderItemMap != null && !stringOrderItemMap.isEmpty()) {
                    OrderItem orderItem = stringOrderItemMap.get(couponExcel.getOrderCode());
                    if(orderItem != null) {
                        couponExcel.setProductName(orderItem.getPackage_name());
                    }
                }
            }

        }

        return list;
    }

    private Map<String, Coupon> selectCoupon(List<String> couponIds) {
        Map<String, Coupon> map = new HashMap<>();
        List<Coupon> coupons = couponMapper_my.selectCouponByIds(couponIds);
        if(!CollectionUtils.isEmpty(coupons)) {
            coupons.forEach(coupon -> {
                map.put(coupon.getId(), coupon);
            });
        }

        return map;
    }

    private Map<String, CouponConsume> selectCouponConsume(List<String> couponCodes) {
        Map<String, CouponConsume> map = new HashMap<>();
        List<CouponConsume> couponConsumes = couponMapper_my.selectCouponConsumeByIds(couponCodes);
        if(!CollectionUtils.isEmpty(couponConsumes)) {
            couponConsumes.forEach(couponConsume -> {
                map.put(couponConsume.getCoupon_code(), couponConsume);
            });
        }

        return map;
    }

    private Map<String, Order> selectOrder(List<String> orderCodes) {
        Map<String, Order> map = new HashMap<>();
        List<Order> orders = orderMapper.selectOrders(orderCodes);
        if(!CollectionUtils.isEmpty(orders)) {
            orders.forEach(order -> {
                map.put(order.getOrder_code(), order);
            });
        }
        return map;
    }

    private Map<String, OrderItem> selectOrderItem(List<String> orderCodes) {
        Map<String, OrderItem> map = new HashMap<>();
        List<OrderItem> orderItems = orderMapper.selectOrderItem(orderCodes);
        if(!CollectionUtils.isEmpty(orderItems)){
            orderItems.forEach(orderItem -> {
                map.put(orderItem.getOrder_code(), orderItem);
            });
        }
        return map;
    }

    private String getCouponStatus(Integer status) {
        if(Integer.valueOf(2).equals(status)) {
            return "已使用";
        }

        if(Integer.valueOf(5).equals(status)) {
            return "未使用";
        }

        if(Integer.valueOf(3).equals(status)) {
            return "已过期";
        }

        if(Integer.valueOf(4).equals(status)) {
            return "已作废";
        }

        return "未知";
    }


}
