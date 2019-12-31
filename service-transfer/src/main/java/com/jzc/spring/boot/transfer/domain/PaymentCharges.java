
package com.jzc.spring.boot.transfer.domain;

import lombok.Data;

/**
 * PaymentCharges实体类
 * @author
 */
@Data
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
	 * 主扫
             被扫
             公众号
             h5
             小程序
             闪付
             转账
             现金
             POS
             ----------------
             直连-微信主扫
             直连-微信被扫
             直连-微信公众号
             直连-支付宝主扫
             直连-支付宝被扫
             聚合-微信主扫
             聚合-微信被扫
             聚合-微信公众号
             聚合-支付宝主扫
             聚合-支付宝被扫
             聚合-银联POS
	 */
	private Integer payChannel;
	
	/**
	 * 支付宝:alipay 
             微信:wxpay 
             现金:
             银联post:
             对公转账:
	 */
	private Integer payType;
	
	/**
	 * 标题
	 */
	private String subject;
	
	/**
	 * 付款中
             付款成功
             付款失败
             已取消
             已退款
             异常
             
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
	 * 取消类型 1:关闭 2:退款 3:其它
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
	
}