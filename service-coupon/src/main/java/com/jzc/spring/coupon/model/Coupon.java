package com.jzc.spring.coupon.model;

import java.util.Date;

public class Coupon {
    private String id;

    private Integer num;

    private String coupon_send_id;

    private String partner_id;

    private String coupon_name;

    private Integer coupon_type;

    private String coupon_img;

    private Integer coupon_stock;

    private Integer send_qty;

    private Date begin_time;

    private Date end_time;

    private Integer valid_type;

    private Integer valid_day;

    private Double discount;

    private Double reduction;

    private Double deductible;

    private String usage_notes;

    private String discount_detail;

    private String service_phone;

    private Date date_added;

    private Integer after_day;

    private String use_scope;

    public String getCoupon_send_id() {
        return coupon_send_id;
    }

    public void setCoupon_send_id(String coupon_send_id) {
        this.coupon_send_id = coupon_send_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    /**
     * 单笔优惠上限
     */
    private Double reduction_limit;

    /**
     * 获取方式
     */
    private Integer obtain_type;

    /**
     * 所需积分或金额
     */
    private Double obtain_value;

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

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name == null ? null : coupon_name.trim();
    }

    public Integer getCoupon_type() {
        return coupon_type;
    }

    public void setCoupon_type(Integer coupon_type) {
        this.coupon_type = coupon_type;
    }

    public String getCoupon_img() {
        return coupon_img;
    }

    public void setCoupon_img(String coupon_img) {
        this.coupon_img = coupon_img;
    }

    public Integer getCoupon_stock() {
        return coupon_stock;
    }

    public void setCoupon_stock(Integer coupon_stock) {
        this.coupon_stock = coupon_stock;
    }

    public Integer getSend_qty() {
        return send_qty;
    }

    public void setSend_qty(Integer send_qty) {
        this.send_qty = send_qty;
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

    public Integer getValid_type() {
        return valid_type;
    }

    public void setValid_type(Integer valid_type) {
        this.valid_type = valid_type;
    }

    public Integer getValid_day() {
        return valid_day;
    }

    public void setValid_day(Integer valid_day) {
        this.valid_day = valid_day;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    public Double getDeductible() {
        return deductible;
    }

    public void setDeductible(Double deductible) {
        this.deductible = deductible;
    }

    public String getUsage_notes() {
        return usage_notes;
    }

    public void setUsage_notes(String usage_notes) {
        this.usage_notes = usage_notes == null ? null : usage_notes.trim();
    }

    public String getDiscount_detail() {
        return discount_detail;
    }

    public void setDiscount_detail(String discount_detail) {
        this.discount_detail = discount_detail == null ? null : discount_detail.trim();
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone == null ? null : service_phone.trim();
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Integer getAfter_day() {
        return after_day;
    }

    public void setAfter_day(Integer after_day) {
        this.after_day = after_day;
    }

    public String getUse_scope() {
        return use_scope;
    }

    public void setUse_scope(String use_scope) {
        this.use_scope = use_scope == null ? null : use_scope.trim();
    }

    public Double getReduction_limit() {
        return reduction_limit;
    }

    public void setReduction_limit(Double reduction_limit) {
        this.reduction_limit = reduction_limit;
    }

    public Integer getObtain_type() {
        return obtain_type;
    }

    public void setObtain_type(Integer obtain_type) {
        this.obtain_type = obtain_type;
    }

    public Double getObtain_value() {
        return obtain_value;
    }

    public void setObtain_value(Double obtain_value) {
        this.obtain_value = obtain_value;
    }
}