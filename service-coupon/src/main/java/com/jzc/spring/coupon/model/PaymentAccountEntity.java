package com.jzc.spring.coupon.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * PaymentAccountEntity
 * 支付台帐实体表
 *
 * @author pottos
 * @version [版本号, 2017/6/13]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class PaymentAccountEntity implements java.io.Serializable {
    public static enum PayType {
        AUTH_CODE_PAY,
        QR_CODE_PAY,
        WAP_PAY,
        CASH_PAY,
    }

    public static enum CancelAction {
        CLOSE, //关闭
        REFUND, //退款
        UNKNOWN //未知, 需要JOB确认
    }

    //主键自增
    private Long id;
    //open_id
    private String open_id;
    //订单编号
    private String order_id;
    //网关生成的支付流水号
    private String payment_serial_no;
    //商户编号
    private String partner_code;
    //店铺编号
    private String shop_id;
    //第三方平台交易流水号
    private String third_serial_no;
    //支付方式
    private String pay_code;
    //支付类型
    private String pay_method;
    //支付渠道(平台)
    private String pay_platform;
    //创建日期
    private Date createtime;
    //更新日期
    private Date updatetime;
    //账单日期
    private Date tradetime;
    //交易金额
    private BigDecimal pay_price;
    //优惠金额
    private BigDecimal free_amount;
    //手续费
    private BigDecimal amount_fee;
    //费率
    private BigDecimal rate_fee;
    //支付状态
    private BigDecimal pay_status;
    //交易备注
    private String pay_remark;
    //回调通知地址
    private String notify_url;
    //支付类型
    private PayType pay_type;
    //撤销动作
    private CancelAction cancel_action;
    //找零
    private BigDecimal odd_change;
    //商户ID
    private String merchant_id;
    //交易完成时间
    private Date finished_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPayment_serial_no() {
        return payment_serial_no;
    }

    public void setPayment_serial_no(String payment_serial_no) {
        this.payment_serial_no = payment_serial_no;
    }

    public String getPartner_code() {
        return partner_code;
    }

    public void setPartner_code(String partner_code) {
        this.partner_code = partner_code;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getThird_serial_no() {
        return third_serial_no;
    }

    public void setThird_serial_no(String third_serial_no) {
        this.third_serial_no = third_serial_no;
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

    public String getPay_platform() {
        return pay_platform;
    }

    public void setPay_platform(String pay_platform) {
        this.pay_platform = pay_platform;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getTradetime() {
        return tradetime;
    }

    public void setTradetime(Date tradetime) {
        this.tradetime = tradetime;
    }

    public BigDecimal getPay_price() {
        return pay_price;
    }

    public void setPay_price(BigDecimal pay_price) {
        this.pay_price = pay_price;
    }

    public BigDecimal getFree_amount() {
        return free_amount;
    }

    public void setFree_amount(BigDecimal free_amount) {
        this.free_amount = free_amount;
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

    public BigDecimal getPay_status() {
        return pay_status;
    }

    public void setPay_status(BigDecimal pay_status) {
        this.pay_status = pay_status;
    }

    public String getPay_remark() {
        return pay_remark;
    }

    public void setPay_remark(String pay_remark) {
        this.pay_remark = pay_remark;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public PayType getPay_type() {
        return pay_type;
    }

    public void setPay_type(PayType pay_type) {
        this.pay_type = pay_type;
    }

    public CancelAction getCancel_action() {
        return cancel_action;
    }

    public void setCancel_action(CancelAction cancel_action) {
        this.cancel_action = cancel_action;
    }

    public BigDecimal getOdd_change() {
        return odd_change;
    }

    public void setOdd_change(BigDecimal odd_change) {
        this.odd_change = odd_change;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Date getFinished_time() {
        return finished_time;
    }

    public void setFinished_time(Date finished_time) {
        this.finished_time = finished_time;
    }
}