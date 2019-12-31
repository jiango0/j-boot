
package com.jzc.spring.coupon.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PaymentCharges实体类
 * @author
 */
public class PaymentCharges {
	
	/**
	 * 主键
	 */
	private String paymentChagesId;
	
	/**
	 * 交易流水号
	 */
	private String txId;
	
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
	 * 订单号
	 */
	private String orderCode;
	
	/**
	 * 第三方用户
	 */
	private String userId;
	
	/**
	 * 直连
             聚合
	 */
	private Integer payProvider;

	/**
	 * 通道类型   取值  ChannelTypeEnum   type
	 */
	private Integer payChannel;

	/**
	 * 支付类型 取值 ChannelCodeEnum  code
	 */
	private Integer payType;
	
	/**
	 * 标题
	 */
	private String subject;
	
	/**
	 * 支付状态   取值  PayStatusEnum  type
	 */
	private Integer payStatus;
	
	/**
	 * 支付金额
	 */
	private java.math.BigDecimal amount;
	
	/**
	 * 优惠金额
	 */
	private java.math.BigDecimal discount;
	
	/**
	 * 手续费
	 */
	private java.math.BigDecimal fee;
	
	/**
	 * 现金支付使用
	 */
	private java.math.BigDecimal oddChange;
	
	/**
	 * 取消类型 取值   PayActionEnum   code
	 */
	private Integer cancelType;
	
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

	public String getPaymentChagesId() {
		return paymentChagesId;
	}

	public void setPaymentChagesId(String paymentChagesId) {
		this.paymentChagesId = paymentChagesId;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
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

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getOddChange() {
		return oddChange;
	}

	public void setOddChange(BigDecimal oddChange) {
		this.oddChange = oddChange;
	}

	public Integer getCancelType() {
		return cancelType;
	}

	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
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