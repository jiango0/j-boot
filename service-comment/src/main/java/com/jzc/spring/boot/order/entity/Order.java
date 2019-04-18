package com.jzc.spring.boot.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
public class Order extends OrderBaseEntity implements Serializable {

    public enum OrderStatus {
        /** 未确认 */
        unconfirmed,
        /** 已确认 */
        confirmed,
        /** 已完成 */
        completed,
        /** 已取消 */
        cancelled
    }

    public enum PaymentStatus {
        /** 未支付 */
        unpaid,
        /** 已支付 */
        paid,
        /** 部分退款 */
        partialRefunds,
        /** 已退款 */
        refunded,
        /** 支付中... 刷卡支付专享 */
        paying
    }

    public enum ShippingStatus {
        /** 未发货 */
        unshipped,
        /** 部分发货 */
        partialShipment,
        /** 已发货 */
        shipped,
        /** 部分退货 */
        partialReturns,
        /** 已退货 */
        returned
    }

    public enum ShippingType {
        /** 实物 */
        normal_goods,
        /** 虚拟物 */
        virtual_goods
    }

    //支付平台

//    public enum PayPlatform {
//        //wechatmall, 微信商城
//        //wechatcommon, 微信公众号
//        //onmachine, 一体机
//        BASE,
//        GENERAL,           //预定类型订单
//        MICROPAY,          //微信被扫支付订单  (微信刷卡支付)
//        MACHINE,           //一体机扫码支付订单
//        ALIPAY,            //支付宝被扫支付订单（支付宝支付宝）
//        FEE_CARD,               //一体机订单，卡押金
//        CAIJI,              //采集商城订单
//        PAYMENTCODE_PAY,  //顾客扫描固定付款码输入金额支付
//        ALIPAY_BUYER,     //支付宝顾客扫码输支付
//        ACTIVITY,         //活动类型订单(秒杀，砍价等)
//        MICRO,    //小微商户
//        OTHER,    //其他
//        SWIPPING_MACHINE,   //机台，刷卡器订单
//        SUIT,            //套餐订单
//        SCORE,//代表积分订单类型为普通订单
//        SWIPPING_MACHINE_RECHARGE,   //机台  充值
//        ORDER_TYPE_WECHATMALL//商城订单
//    }

    /**
     * 订单平台
     * 枚举首字母不允许重复（用作在订单号中区分订单平台）
     */
	public enum PayPlatform {
        WECHAT_MALL,  //微信商城
        ALL_IN_ONE_MACHINE,  //一体机
        SWIPE_MACHINE, //刷卡器
        BOSS_ORDER,  //BOSS订单
        TEAM_BUY_KOUBEI,//口碑
        MEI_TUAN //新美大(美团点评)
    }


    /**
     * 订单类型
     */
    public enum OrderType {
        RECHARGE, //充值
        DROP_COIN, //投币
        REDEEM_CODE, //兑换码

        /** 新增订单类型 */
        GAME_CURRENCY, //游戏币订单
        DIRECTIONAL_GAME_VOUCHER, //定向游戏券订单
        GAME_CARD, //游戏卡订单
        LEISURE_PROJECT, //休闲项目订单
        GOODS, //商品订单
        GIFT, //礼品订单
        TEAM_BUYING, //团购订单
        REDEMPTION_VOUCHER, //兑换券订单
        CARD_DEPOSIT, //办卡押金订单
        MANNUAL_OR_IMPORT, //手工或导入订单
        OTHER, //其他订单
        SLIVER_TICKET_CARD, //银票卡订单
        SHOP_LEASING, //商铺租赁订单
        WASTE_REVENUE, //废品收入订单
        RENTAL_DEPOSIT, //租赁押金订单
        MACHINE_LEASING, //机台租赁
        MEMBER_REPLACEMENT_CARD, //会员补卡
        SPECIAL_TEAM_BUYING; //特殊团购订单
    }

    /**
     * 支付类型
     */
    public enum PayMethod {
        AUTH_CODE_PAY, //扫码枪
        QR_CODE_PAY, //主动扫码
        WAP_PAY, //公众号
        UNION_PAY, //银联刷卡
        APPLET_PAY, //小程序
        CASH_PAY, //现金
        APP_PAY, //app
        TRANSFER_TO_PUBLIC_ACCOUNT_PAY //对公转账
    }

    /**
     * 支付方式
     */
    public enum PayCode {
        ALIPAY, //支付宝支付
        WEIXIN, //微信支付
        CASH, //现金支付
        UNION, //银联支付
        TRANSFER_TO_PUBLIC_ACCOUNT, //对公转账
        INTEGRAL, //积分
        TICKET, //彩票
        CURRENCY //游戏币
    }

    /** 主键 */
    private String id;

    /** 订单编号 */
    @Field("Order_order_code")
    private String order_code;

    /** 顾客id */
    private String customer_id;

    /** 顾客id */
    private String customer_name;

    /** 订单名称 */
    private String order_name;

    /** 支付平台 */
    private PayPlatform pay_platform;

    /** 订单类型 */
    private OrderType order_type;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date create_time;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date edit_time;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date finished_time;

    /** 付款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date paid_time;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date shipping_time;

    /** 商品总数量 */
    private BigDecimal total_qty;

    /** 订单金额 */
    private BigDecimal total_fee;

    /** 应付金额 */
    private BigDecimal payable_fee;

    /** 运费 */
    private BigDecimal shipping_fee;

    /** 促销优惠金额 */
    private BigDecimal promotion_discount;

    /** 优惠券抵扣金额 */
    private BigDecimal coupon_discount;

    /** 积分抵扣金额 */
    private BigDecimal point_discount;

    /** 所需积分 */
    private BigDecimal cost_point;

    /** 赠送积分 */
    private BigDecimal point;

    /** 订单状态 */
    private OrderStatus order_status;

    /** 支付状态 */
    private PaymentStatus payment_status;

    /** 物流状态 */
    private ShippingStatus shipping_status;

    /** 配送类型 */
    private ShippingType shipping_type;

    /** 店铺id */
    private String shop_id;

    /** 合作方标识 */
    private String partner_sign;

    /** 顾客备注 */
    private String customer_remark;

    /** 客服备注 */
    private String service_remark;

    /** 支付方式 */
    private String pay_code;

    /** 支付类型 */
    private PayMethod pay_method;

    /** 订单行 */
    private List<OrderItem> orderItemList;

    /** 优惠券 */
    private OrderCouponRelation orderCoupon;

    /** 订单促销 */
    private List<OrderPromotion> orderPromotions;

    /** 收货地址 */
    private OrderShipping orderShipping;

    /** 虚拟物收货地址 */
    private OrderShippingVirtual orderShippingVirtual;

    /** 收银信息 */
    private OrderCashierInfo orderCashierInfo;

    private String koubei_shop_code;

    private String recommend_id;

    /** 订单扩展信息 */
    private Map<String, String> extra;

    /** 商户ID */
    private String merchant_id;

    /** 订单使用的总币数 */
    private Integer total_coin;

    /** 订单使用的总票数 */
    private Integer total_ticket;

    /** 会员卡号 */
    private String card_number;

    /** customerId或memberId标识，0代表customerId， 1代表memberId */
    private Integer customer_or_member_flag;

    /** 总的应付票数 */
    private Integer payable_ticket;

    /** 总的应付币数 */
    private Integer payable_coin;

    /** 取消时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private Date cancel_time;

    private OrderRevenueCategory orderRevenueCategory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public PayPlatform getPay_platform() {
        return pay_platform;
    }

    public void setPay_platform(PayPlatform pay_platform) {
        this.pay_platform = pay_platform;
    }

    public OrderType getOrder_type() {
        return order_type;
    }

    public void setOrder_type(OrderType order_type) {
        this.order_type = order_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getEdit_time() {
        return edit_time;
    }

    public void setEdit_time(Date edit_time) {
        this.edit_time = edit_time;
    }

    public Date getFinished_time() {
        return finished_time;
    }

    public void setFinished_time(Date finished_time) {
        this.finished_time = finished_time;
    }

    public Date getPaid_time() {
        return paid_time;
    }

    public void setPaid_time(Date paid_time) {
        this.paid_time = paid_time;
    }

    public Date getShipping_time() {
        return shipping_time;
    }

    public void setShipping_time(Date shipping_time) {
        this.shipping_time = shipping_time;
    }

    public BigDecimal getTotal_qty() {
        return total_qty;
    }

    public void setTotal_qty(BigDecimal total_qty) {
        this.total_qty = total_qty;
    }

    public BigDecimal getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(BigDecimal total_fee) {
        this.total_fee = total_fee;
    }

    public BigDecimal getPayable_fee() {
        return payable_fee;
    }

    public void setPayable_fee(BigDecimal payable_fee) {
        this.payable_fee = payable_fee;
    }

    public BigDecimal getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(BigDecimal shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public BigDecimal getPromotion_discount() {
        return promotion_discount;
    }

    public void setPromotion_discount(BigDecimal promotion_discount) {
        this.promotion_discount = promotion_discount;
    }

    public BigDecimal getCoupon_discount() {
        return coupon_discount;
    }

    public void setCoupon_discount(BigDecimal coupon_discount) {
        this.coupon_discount = coupon_discount;
    }

    public BigDecimal getPoint_discount() {
        return point_discount;
    }

    public void setPoint_discount(BigDecimal point_discount) {
        this.point_discount = point_discount;
    }

    public BigDecimal getCost_point() {
        return cost_point;
    }

    public void setCost_point(BigDecimal cost_point) {
        this.cost_point = cost_point;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }

    public PaymentStatus getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(PaymentStatus payment_status) {
        this.payment_status = payment_status;
    }

    public ShippingStatus getShipping_status() {
        return shipping_status;
    }

    public void setShipping_status(ShippingStatus shipping_status) {
        this.shipping_status = shipping_status;
    }

    public ShippingType getShipping_type() {
        return shipping_type;
    }

    public void setShipping_type(ShippingType shipping_type) {
        this.shipping_type = shipping_type;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getPartner_sign() {
        return partner_sign;
    }

    public void setPartner_sign(String partner_sign) {
        this.partner_sign = partner_sign;
    }

    public String getCustomer_remark() {
        return customer_remark;
    }

    public void setCustomer_remark(String customer_remark) {
        this.customer_remark = customer_remark;
    }

    public String getService_remark() {
        return service_remark;
    }

    public void setService_remark(String service_remark) {
        this.service_remark = service_remark;
    }

    public String getPay_code() {
        return pay_code;
    }

    public void setPay_code(String pay_code) {
        this.pay_code = pay_code;
    }

    public PayMethod getPay_method() {
        return pay_method;
    }

    public void setPay_method(PayMethod pay_method) {
        this.pay_method = pay_method;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public OrderCouponRelation getOrderCoupon() {
        return orderCoupon;
    }

    public void setOrderCoupon(OrderCouponRelation orderCoupon) {
        this.orderCoupon = orderCoupon;
    }

    public List<OrderPromotion> getOrderPromotions() {
        return orderPromotions;
    }

    public void setOrderPromotions(List<OrderPromotion> orderPromotions) {
        this.orderPromotions = orderPromotions;
    }

    public OrderShipping getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(OrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }

    public OrderShippingVirtual getOrderShippingVirtual() {
        return orderShippingVirtual;
    }

    public void setOrderShippingVirtual(OrderShippingVirtual orderShippingVirtual) {
        this.orderShippingVirtual = orderShippingVirtual;
    }

    public OrderCashierInfo getOrderCashierInfo() {
        return orderCashierInfo;
    }

    public void setOrderCashierInfo(OrderCashierInfo orderCashierInfo) {
        this.orderCashierInfo = orderCashierInfo;
    }

    public String getKoubei_shop_code() {
        return koubei_shop_code;
    }

    public void setKoubei_shop_code(String koubei_shop_code) {
        this.koubei_shop_code = koubei_shop_code;
    }

    public String getRecommend_id() {
        return recommend_id;
    }

    public void setRecommend_id(String recommend_id) {
        this.recommend_id = recommend_id;
    }

    public Map<String, String> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Integer getTotal_coin() {
        return total_coin;
    }

    public void setTotal_coin(Integer total_coin) {
        this.total_coin = total_coin;
    }

    public Integer getTotal_ticket() {
        return total_ticket;
    }

    public void setTotal_ticket(Integer total_ticket) {
        this.total_ticket = total_ticket;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Integer getCustomer_or_member_flag() {
        return customer_or_member_flag;
    }

    public void setCustomer_or_member_flag(Integer customer_or_member_flag) {
        this.customer_or_member_flag = customer_or_member_flag;
    }

    public Integer getPayable_ticket() {
        return payable_ticket;
    }

    public void setPayable_ticket(Integer payable_ticket) {
        this.payable_ticket = payable_ticket;
    }

    public Integer getPayable_coin() {
        return payable_coin;
    }

    public void setPayable_coin(Integer payable_coin) {
        this.payable_coin = payable_coin;
    }

    public Date getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(Date cancel_time) {
        this.cancel_time = cancel_time;
    }

    public OrderRevenueCategory getOrderRevenueCategory() {
        return orderRevenueCategory;
    }

    public void setOrderRevenueCategory(OrderRevenueCategory orderRevenueCategory) {
        this.orderRevenueCategory = orderRevenueCategory;
    }
}
