package com.jzc.spring.coupon.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PaymentRefundEntity
 * 支付网关退款实体
 *
 * @author pottos
 * @version [版本号, 2017/6/13]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PaymentRefundEntity implements java.io.Serializable{
    //id主键
    private Long id;
    //交易原订单号
    private String order_id;
    //退款原因
    private String refund_reason;
    //支付交易流水号
    private String payment_serial_no;
    //退款单号
    private String refund_order_code;
    //第三方平台交易流水号
    private String third_serial_no;
    //退款金额
    private BigDecimal refund_amount;
    //创建日期
    private Date createtime;
    //账单日期
    private Date tradetime;
    //退款状态
    private BigDecimal refund_status;
    //店铺编码
    private String shop_code;
    //支付编号
    private String pay_code;
    //支付类型
    private String pay_method;
    //支付平台
    private String plat_form;
    //支付手续费
    private BigDecimal amount_fee;
    //支付手续费率
    private BigDecimal rate_fee;
    //退款备注
    private String refund_remark;
    //商户ID
    private String merchant_id;

    private String partner_sign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public String getPayment_serial_no() {
        return payment_serial_no;
    }

    public void setPayment_serial_no(String payment_serial_no) {
        this.payment_serial_no = payment_serial_no;
    }

    public String getRefund_order_code() {
        return refund_order_code;
    }

    public void setRefund_order_code(String refund_order_code) {
        this.refund_order_code = refund_order_code;
    }

    public String getThird_serial_no() {
        return third_serial_no;
    }

    public void setThird_serial_no(String third_serial_no) {
        this.third_serial_no = third_serial_no;
    }

    public BigDecimal getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(BigDecimal refund_amount) {
        this.refund_amount = refund_amount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getTradetime() {
        return tradetime;
    }

    public void setTradetime(Date tradetime) {
        this.tradetime = tradetime;
    }

    public BigDecimal getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(BigDecimal refund_status) {
        this.refund_status = refund_status;
    }

    public String getShop_code() {
        return shop_code;
    }

    public void setShop_code(String shop_code) {
        this.shop_code = shop_code;
    }

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getPlat_form() {
        return plat_form;
    }

    public void setPlat_form(String plat_form) {
        this.plat_form = plat_form;
    }

    public BigDecimal getAmount_fee() {
        return amount_fee;
    }

    public void setAmount_fee(BigDecimal amount_fee) {
        this.amount_fee = amount_fee;
    }

    public BigDecimal getRate_fee() {
        return rate_fee;
    }

    public void setRate_fee(BigDecimal rate_fee) {
        this.rate_fee = rate_fee;
    }

    public String getRefund_remark() {
        return refund_remark;
    }

    public void setRefund_remark(String refund_remark) {
        this.refund_remark = refund_remark;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getPartner_sign() {
        return partner_sign;
    }

    public void setPartner_sign(String partner_sign) {
        this.partner_sign = partner_sign;
    }
}
