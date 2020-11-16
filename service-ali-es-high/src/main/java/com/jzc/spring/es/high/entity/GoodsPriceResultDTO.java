package com.jzc.spring.es.high.entity;

import java.math.BigDecimal;

/**
 * @Author: zhouqi
 * @Date: 2020/8/19 15:44
 */
public class GoodsPriceResultDTO {
    private String channelGoodsId;
    private Integer priceType;
    private Integer priceCategory;
    private BigDecimal amount;

    public String getChannelGoodsId() {
        return channelGoodsId;
    }

    public void setChannelGoodsId(String channelGoodsId) {
        this.channelGoodsId = channelGoodsId;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Integer getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(Integer priceCategory) {
        this.priceCategory = priceCategory;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
