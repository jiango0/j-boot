package com.jzc.spring.boot.order.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单促销
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
public class OrderPromotion extends OrderBaseEntity implements Serializable {

    public static enum PromotionType {
        normal, //普通促销
        member, //会员权益
        other //其他
        ;
    }


    /** 主键 */
    private Long id;

    /** 订单编号 */
    @Field("OrderPromotion_order_code")
    private String order_code;

    /** 订单明细ID */
    private String order_item_code;

    /** 促销编码 */
    private String promotion_code;

    /** 促销金额 */
    private BigDecimal promotion_fee;

    /** 赠品SKU */
    private String promotion_sku;

    /** 赠品数量 */
    private BigDecimal promotion_qty;

    /**
     * 促销内容
     */
    private String content;

    /** 商户ID */
    private String merchant_id;

    /** 优惠的票数 */
    private Integer discounted_ticket;

    /** 促销类型 */
    private PromotionType promotion_type;

    /** 优惠的游戏币数 */
    private Integer discounted_coin;

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

    public String getOrder_item_code() {
        return order_item_code;
    }

    public void setOrder_item_code(String order_item_code) {
        this.order_item_code = order_item_code;
    }

    public String getPromotion_code() {
        return promotion_code;
    }

    public void setPromotion_code(String promotion_code) {
        this.promotion_code = promotion_code;
    }

    public BigDecimal getPromotion_fee() {
        return promotion_fee;
    }

    public void setPromotion_fee(BigDecimal promotion_fee) {
        this.promotion_fee = promotion_fee;
    }

    public String getPromotion_sku() {
        return promotion_sku;
    }

    public void setPromotion_sku(String promotion_sku) {
        this.promotion_sku = promotion_sku;
    }

    public BigDecimal getPromotion_qty() {
        return promotion_qty;
    }

    public void setPromotion_qty(BigDecimal promotion_qty) {
        this.promotion_qty = promotion_qty;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Integer getDiscounted_ticket() {
        return discounted_ticket;
    }

    public void setDiscounted_ticket(Integer discounted_ticket) {
        this.discounted_ticket = discounted_ticket;
    }

    public PromotionType getPromotion_type() {
        return promotion_type;
    }

    public void setPromotion_type(PromotionType promotion_type) {
        this.promotion_type = promotion_type;
    }

    public Integer getDiscounted_coin() {
        return discounted_coin;
    }

    public void setDiscounted_coin(Integer discounted_coin) {
        this.discounted_coin = discounted_coin;
    }
}
