package com.jzc.spring.coupon.model;

import java.util.Date;

public class CustomersCoupon {
    private String id;

    private String partner_id;

    private String customer_id;

    private String customer_name;

    private String send_id;

    private String coupon_id;

    private String coupon_code;

    private String coupon_name;

    private Integer coupon_status;

    private Date begin_time;

    private Date end_time;

    private Date date_activation;

    private Date date_consume;

    private String send_batch_code;

    private Integer is_notify;

    private String shop_guid;

    /**
     * 活动类型 0幸运砸蛋 1 大转盘 2刮刮乐
     */
    private Integer activity_type;

    /**
     * 礼品guid
     */
    private String prize_customs_guid;

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

    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code == null ? null : coupon_code.trim();
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name == null ? null : coupon_name.trim();
    }

    public Integer getCoupon_status() {
        return coupon_status;
    }

    public void setCoupon_status(Integer coupon_status) {
        this.coupon_status = coupon_status;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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

    public String getSend_batch_code() {
        return send_batch_code;
    }

    public void setSend_batch_code(String send_batch_code) {
        this.send_batch_code = send_batch_code == null ? null : send_batch_code.trim();
    }

    public Integer getIs_notify() {
        return is_notify;
    }

    public void setIs_notify(Integer is_notify) {
        this.is_notify = is_notify;
    }

    public String getShop_guid() {
        return shop_guid;
    }

    public void setShop_guid(String shop_guid) {
        this.shop_guid = shop_guid == null ? null : shop_guid.trim();
    }

    public Integer getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(Integer activity_type) {
        this.activity_type = activity_type;
    }

    public String getPrize_customs_guid() {
        return prize_customs_guid;
    }

    public void setPrize_customs_guid(String prize_customs_guid) {
        this.prize_customs_guid = prize_customs_guid;
    }
}