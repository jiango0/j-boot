package com.jzc.spring.boot.transfer.domain;

import lombok.Data;

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
@Data
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
}
