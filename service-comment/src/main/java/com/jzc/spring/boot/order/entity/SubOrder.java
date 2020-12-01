package com.jzc.spring.boot.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SubOrder {

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 子订单号
     */
    private String orderCode;
    /**
     * 订单号
     */
    private String parentOrderCode;
    /**
     * 第三方子订单号
     */
    private String tpSubOrderCode;
    /**
     * 第三方订单号
     */
    private String tpOrderCode;
    /**
     * 拆分维度 0 物流 1...
     */
    private Integer splitType;
    /**
     * 子订单状态  0 正常  1.删除
     */
    private Integer orderStatus;
    /**
     * 子订单物流状态 1.
     */
    private Integer shippedStatus;
    /**
     * 支付状态
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderAt;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    /**
     * 订单明细信息
     */
    private List<OrderDetail> orderDetailList;
    /**
     * partnerSign
     */
    private String partnerSign;
    /**
     *  0: 普通订单 1:换新订单
     */
    private Integer exchange;
    /**
     * 商品结算价格
     */
    private BigDecimal settlementPrice;
    /**
     * 商品采购价格
     */
    private BigDecimal purchasePrice;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getParentOrderCode() {
        return parentOrderCode;
    }

    public void setParentOrderCode(String parentOrderCode) {
        this.parentOrderCode = parentOrderCode;
    }

    public String getTpSubOrderCode() {
        return tpSubOrderCode;
    }

    public void setTpSubOrderCode(String tpSubOrderCode) {
        this.tpSubOrderCode = tpSubOrderCode;
    }

    public String getTpOrderCode() {
        return tpOrderCode;
    }

    public void setTpOrderCode(String tpOrderCode) {
        this.tpOrderCode = tpOrderCode;
    }

    public Integer getSplitType() {
        return splitType;
    }

    public void setSplitType(Integer splitType) {
        this.splitType = splitType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getShippedStatus() {
        return shippedStatus;
    }

    public void setShippedStatus(Integer shippedStatus) {
        this.shippedStatus = shippedStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(Date orderAt) {
        this.orderAt = orderAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public String getPartnerSign() {
        return partnerSign;
    }

    public void setPartnerSign(String partnerSign) {
        this.partnerSign = partnerSign;
    }

    public Integer getExchange() {
        return exchange;
    }

    public void setExchange(Integer exchange) {
        this.exchange = exchange;
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
}
