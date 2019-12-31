package com.jzc.spring.boot.transfer.domain;

import lombok.Data;

/**
 * PaymentRefund实体类
 *
 * @author
 */
@Data
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

}