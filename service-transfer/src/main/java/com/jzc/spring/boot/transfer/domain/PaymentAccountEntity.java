package com.jzc.spring.boot.transfer.domain;

import lombok.Data;

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
@Data
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
}