package com.jzc.spring.boot.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class SubOrderDTO {

    /**
     * 订单号
     */
    private String parentOrderCode;
    /**
     * 商品结算价格
     */
    private BigDecimal settlementPrice;
    /**
     * 商品采购价格
     */
    private BigDecimal purchasePrice;
    /**
     * 第三方商品sku
     */
    private String tpGoodsSku;

    public String getParentOrderCode() {
        return parentOrderCode;
    }

    public void setParentOrderCode(String parentOrderCode) {
        this.parentOrderCode = parentOrderCode;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getTpGoodsSku() {
        return tpGoodsSku;
    }

    public void setTpGoodsSku(String tpGoodsSku) {
        this.tpGoodsSku = tpGoodsSku;
    }
}
