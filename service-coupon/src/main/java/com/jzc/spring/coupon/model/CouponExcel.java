package com.jzc.spring.coupon.model;

import java.math.BigDecimal;
import java.util.Date;

public class CouponExcel {

    private String customerId;

    private String customerName;

    private String couponId;

    private String couponCode;

    private String couponName;

    private Double deductible;

    private String productName;

    private BigDecimal peeAmount;

    private Date date_activation;

    private Date date_consume;

    private String shopId;

    private String orderCode;

    private String couponStatus;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Double getDeductible() {
        return deductible;
    }

    public void setDeductible(Double deductible) {
        this.deductible = deductible;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPeeAmount() {
        return peeAmount;
    }

    public void setPeeAmount(BigDecimal peeAmount) {
        this.peeAmount = peeAmount;
    }

    public Date getDate_activation() {
        return date_activation;
    }

    public void setDate_activation(Date date_activation) {
        this.date_activation = date_activation;
    }

    public Date getDate_consume() {
        return date_consume;
    }

    public void setDate_consume(Date date_consume) {
        this.date_consume = date_consume;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(String couponStatus) {
        this.couponStatus = couponStatus;
    }
}
