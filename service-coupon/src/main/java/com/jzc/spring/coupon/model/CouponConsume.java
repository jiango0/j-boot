package com.jzc.spring.coupon.model;

import java.util.Date;

public class CouponConsume {
    private String id;

    private String partner_id;

    private String coupon_id;

    private String send_id;

    private String send_batch_code;

    private String coupon_code;

    private Integer verify_method;

    private Date date_consume;

    private String orders_code;

    private String shop_id;

    private String shop_name;

    private Double deductible;

    private String remark;

    private String union_id;

    private String open_id;

    private String customer_id;

    private String customer_name;

    private String id_number;

    private Double order_fee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id == null ? null : partner_id.trim();
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id == null ? null : coupon_id.trim();
    }

    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id == null ? null : send_id.trim();
    }

    public String getSend_batch_code() {
        return send_batch_code;
    }

    public void setSend_batch_code(String send_batch_code) {
        this.send_batch_code = send_batch_code == null ? null : send_batch_code.trim();
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code == null ? null : coupon_code.trim();
    }

    public Integer getVerify_method() {
        return verify_method;
    }

    public void setVerify_method(Integer verify_method) {
        this.verify_method = verify_method;
    }

    public Date getDate_consume() {
        return date_consume;
    }

    public void setDate_consume(Date date_consume) {
        this.date_consume = date_consume;
    }

    public String getOrders_code() {
        return orders_code;
    }

    public void setOrders_code(String orders_code) {
        this.orders_code = orders_code == null ? null : orders_code.trim();
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id == null ? null : shop_id.trim();
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name == null ? null : shop_name.trim();
    }

    public Double getDeductible() {
        return deductible;
    }

    public void setDeductible(Double deductible) {
        this.deductible = deductible;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUnion_id() {
        return union_id;
    }

    public void setUnion_id(String union_id) {
        this.union_id = union_id == null ? null : union_id.trim();
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id == null ? null : open_id.trim();
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id == null ? null : customer_id.trim();
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name == null ? null : customer_name.trim();
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number == null ? null : id_number.trim();
    }

    public Double getOrder_fee() {
        return order_fee;
    }

    public void setOrder_fee(Double order_fee) {
        this.order_fee = order_fee;
    }
}