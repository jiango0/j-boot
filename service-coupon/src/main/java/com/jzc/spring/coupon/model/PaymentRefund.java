package com.jzc.spring.coupon.model;


import java.math.BigDecimal;
import java.util.Date;

/**
 * PaymentRefund实体类
 *
 * @author
 */
public class PaymentRefund {

    /**
     * 主键
     */
    private String paymentRefundId;

    /**
     * 退款流水号
     */
    private String refundTxId;

    /**
     * 交易流水号
     */
    private String txId;

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 门店id
     */
    private String shopId;

    /**
     * 订单渠道
     * */
    private Integer orderChannel;

    /**
     * 收款账号id
     */
    private String accountId;

    /**
     * 第三方支付流水号
     */
    private String outTradeNo;

    /**
     * 退款成功
     * 退款失败
     */
    private Integer refundStatus;

    /**
     * 直连
     * 聚合
     */
    private Integer payProvider;

    /**
     * 主扫
     * 被扫
     * 公众号
     * h5
     * 小程序
     * 闪付
     * 转账
     * 现金
     * POS
     * ----------------
     * 直连-微信主扫
     * 直连-微信被扫
     * 直连-微信公众号
     * 直连-支付宝主扫
     * 直连-支付宝被扫
     * 聚合-微信主扫
     * 聚合-微信被扫
     * 聚合-微信公众号
     * 聚合-支付宝主扫
     * 聚合-支付宝被扫
     * 聚合-银联POS
     */
    private Integer payChannel;

    /**
     * 支付宝:alipay
     * 微信:wxpay
     * 现金:
     * 银联post:
     * 对公转账:
     */
    private Integer payType;

    /**
     * 退款金额
     */
    private java.math.BigDecimal refundAmount;

    /**
     * 手续费
     */
    private java.math.BigDecimal fee;

    /**
     * 创建时间
     */
    private java.util.Date createdAt;

    /**
     * 更新时间
     */
    private java.util.Date updatedAt;

    /**
     * 完成时间
     */
    private java.util.Date billTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 对账状态
     */
    private Integer checkStatus;

    public String getPaymentRefundId() {
        return paymentRefundId;
    }

    public void setPaymentRefundId(String paymentRefundId) {
        this.paymentRefundId = paymentRefundId;
    }

    public String getRefundTxId() {
        return refundTxId;
    }

    public void setRefundTxId(String refundTxId) {
        this.refundTxId = refundTxId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getPayProvider() {
        return payProvider;
    }

    public void setPayProvider(Integer payProvider) {
        this.payProvider = payProvider;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
}