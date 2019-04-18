package com.jzc.spring.boot.order.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 虚拟商品物流
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
public class OrderShippingVirtual extends OrderBaseEntity implements Serializable {
    public enum ReceiverType {
        http,
        /** mqtt */
        mqtt,
        /** 短信 */
        sms,
        /** 邮箱 */
        email,
        /** 微信模板消息 */
        wechat_template,
        /** 其它 */
        other;
    }

    /** 主键 */
    private Long id;

    /** 订单号 */
    @Field("OrderShippingVirtual_order_code")
    private String order_code;

    /** 收货帐户 */
    private String target;

    private String content;

    /** 店铺id */
    private String shop_id;

    /** 收货类型 */
    private ReceiverType receiver_type;

//    /** 递送地址 */
//    @ApiModelProperty(notes = "递送地址", example = "http://mall.toonyoo.net")
//    private String notify_url;

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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public ReceiverType getReceiver_type() {
        return receiver_type;
    }

    public void setReceiver_type(ReceiverType receiver_type) {
        this.receiver_type = receiver_type;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }
}
