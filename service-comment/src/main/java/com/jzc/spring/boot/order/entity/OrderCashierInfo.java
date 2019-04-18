package com.jzc.spring.boot.order.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 收银台信息
 * @author ShionWong
 * @version V1.0, 2017/11/23
 * @see
 * @since V1.0
 */
public class OrderCashierInfo extends OrderBaseEntity {
    /** 主键 */
    private Long id;//	bigint

    @Field("OrderCashierInfo_order_code")
    private String order_code;//	varchar

    private String cashier_code;//	varchar

    private String cashier_name;//	varchar

    private String device_num;

    private String device_name;

    /** 商户ID */
    private String merchant_id;

    /** 授权人ID */
    private String authorizer_id;

    /** 授权人姓名 */
    private String authorizer_name;

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

    public String getCashier_code() {
        return cashier_code;
    }

    public void setCashier_code(String cashier_code) {
        this.cashier_code = cashier_code;
    }

    public String getCashier_name() {
        return cashier_name;
    }

    public void setCashier_name(String cashier_name) {
        this.cashier_name = cashier_name;
    }

    public String getDevice_num() {
        return device_num;
    }

    public void setDevice_num(String device_num) {
        this.device_num = device_num;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getAuthorizer_id() {
        return authorizer_id;
    }

    public void setAuthorizer_id(String authorizer_id) {
        this.authorizer_id = authorizer_id;
    }

    public String getAuthorizer_name() {
        return authorizer_name;
    }

    public void setAuthorizer_name(String authorizer_name) {
        this.authorizer_name = authorizer_name;
    }
}
