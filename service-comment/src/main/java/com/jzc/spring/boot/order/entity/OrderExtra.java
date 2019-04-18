package com.jzc.spring.boot.order.entity;

/**
 * @author ShionWong
 * @version V1.0, 19/01/2018
 * @see
 * @since V1.0
 */
public class OrderExtra extends OrderBaseEntity {
    //主键
    private Long id;
    //订单号
    private String order_code;
    //额外信息KEY
    private String key;
    //额外信息VALUE
    private String value;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }
}
