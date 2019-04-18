package com.jzc.spring.boot.order.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 订单物流
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
public class OrderShipping extends OrderBaseEntity implements Serializable {
    /** 主键 */
    private Long id;

    /** 订单编号 */
    @Field("OrderShipping_order_code")
    private String order_code;

    /** 收货人 */
    private String customer_name;

    /** 收货人电话 */
    private String customer_phone;

    /** 省份编码 */
    private String province_code;

    /** 省份名称 */
    private String province_name;

    /** 市编码 */
    private String city_code;

    /** 市名称 */
    private String city_name;

    /** 区编码 */
    private String district_code;

    /** 区名称 */
    private String district_name;

    /** 详细地址 */
    private String customer_addr;

    /** 邮政编码 */
    private String customer_post;

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

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDistrict_code() {
        return district_code;
    }

    public void setDistrict_code(String district_code) {
        this.district_code = district_code;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getCustomer_addr() {
        return customer_addr;
    }

    public void setCustomer_addr(String customer_addr) {
        this.customer_addr = customer_addr;
    }

    public String getCustomer_post() {
        return customer_post;
    }

    public void setCustomer_post(String customer_post) {
        this.customer_post = customer_post;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }
}
