package com.jzc.spring.coupon.model;

import java.util.Date;

public class MessageNoticeRecord {
    private Long id;

    private String partner_sign;

    private String shop_guid;

    private String order_code;

    private String card_number;

    private Integer type;

    private Integer status;

    private String content;

    private String error_message;

    private Integer retry_num;

    private String flow_guid;

    private Date create_time;

    private Date update_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartner_sign() {
        return partner_sign;
    }

    public void setPartner_sign(String partner_sign) {
        this.partner_sign = partner_sign == null ? null : partner_sign.trim();
    }

    public String getShop_guid() {
        return shop_guid;
    }

    public void setShop_guid(String shop_guid) {
        this.shop_guid = shop_guid == null ? null : shop_guid.trim();
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code == null ? null : order_code.trim();
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number == null ? null : card_number.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message == null ? null : error_message.trim();
    }

    public Integer getRetry_num() {
        return retry_num;
    }

    public void setRetry_num(Integer retry_num) {
        this.retry_num = retry_num;
    }

    public String getFlow_guid() {
        return flow_guid;
    }

    public void setFlow_guid(String flow_guid) {
        this.flow_guid = flow_guid == null ? null : flow_guid.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}