package com.jzc.spring.boot.order.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单用券
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
public class OrderCouponRelation extends OrderBaseEntity implements Serializable {
    /** 主键 */
    private Long id;

    /** 订单号 */
    @Field("OrderCouponRelation_order_code")
    private String order_code;

    /** 优惠券码 */
    private String coupon_code;

    /** 优惠券金额 */
    private BigDecimal coupon_fee;

    /** 商户ID */
    private String merchant_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getOrder_code() {
        return order_code;
    }

    @Override
    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public BigDecimal getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(BigDecimal coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }
}
