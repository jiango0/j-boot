package com.jzc.spring.boot.test.model;

import java.math.BigDecimal;

public class GoodsPrice {

    //定价类型0金额、1积分、2彩票
    private Integer priceType;

    //价格种类（0参考价 1售卖价）
    private String priceCategory;

    //金额
    private BigDecimal amount;

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
