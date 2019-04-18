package com.jzc.spring.boot.order.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单行
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
public class OrderItem extends OrderBaseEntity implements Serializable {
    public enum ProductType {
        normal, //正品
        gift,   //赠品
        deposit, //押金
        GameCard,//游戏卡
        Drink,//饮料
        LeisureProject,//休闲项目
        SmallCommodi, //小商品
        MeasuredCard, //次卡
        ElectronicCurrency,//电子币
        GateBrake,//闸机消费
        MemberCard,//会员卡
        Deposit,//押金
        Gift,//礼品
        Revenue,//营业项
        WaterGoods//水吧
        ;
    }

    public enum PackageFlag {
        NO, //不是套餐
        YES; //是套餐
    }

    /** 主键 */
    private Long id;

    /** 订单号 */
    @Field("order_item_order_code")
    private String order_code;

    /** 行号 */
    private String order_item_code;

    /** 套装ID */
    private String package_id;

    /** 商品SKU */
    private String product_sku;

    /** 商品名称 */
    private String item_name;

    /** 商品类型 */
    private ProductType product_type;

    /** 缩略图 */
    private String thumbnail;

    /** 单价 */
    private BigDecimal price;

    /** 单价 */
    private BigDecimal total_price;

    /** 分摊价格 */
    private BigDecimal share_price;

    /** 单价积分 */
    private BigDecimal point;

    /** 购买数量 */
    private BigDecimal item_qty;

    /** 订单行总价 */
    private BigDecimal total_amount;

    /** 订单行总积分 */
    private BigDecimal total_point;

    /** 已发货数量 */
    private BigDecimal shipped_qty;

    /** 已退货数量 */
    private BigDecimal return_qty;

    /** 套餐名称 */
    private String package_name;

    private String activity_id;

    private Object productData;

    /** 商户ID */
    private String merchant_id;

    /** 使用的币数 */
    private Integer item_coin;

    /** 使用的票数 */
    private Integer item_ticket;

    /** 订单行总的使用的币数 */
    private Integer total_coin;

    /** 订单行总的使用的票数 */
    private Integer total_ticket;

    /** 是否套餐明细（0否 1是） */
    private Integer package_item_flag;

    /** 分摊的票数 */
    private Integer apportioned_ticket;

    /** 分摊的游戏币数 */
    private Integer apportioned_coin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getOrder_code() {
        return order_code;
    }

    @Override
    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getOrder_item_code() {
        return order_item_code;
    }

    public void setOrder_item_code(String order_item_code) {
        this.order_item_code = order_item_code;
    }

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public String getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(String product_sku) {
        this.product_sku = product_sku;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public ProductType getProduct_type() {
        return product_type;
    }

    public void setProduct_type(ProductType product_type) {
        this.product_type = product_type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public BigDecimal getShare_price() {
        return share_price;
    }

    public void setShare_price(BigDecimal share_price) {
        this.share_price = share_price;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public BigDecimal getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(BigDecimal item_qty) {
        this.item_qty = item_qty;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public BigDecimal getTotal_point() {
        return total_point;
    }

    public void setTotal_point(BigDecimal total_point) {
        this.total_point = total_point;
    }

    public BigDecimal getShipped_qty() {
        return shipped_qty;
    }

    public void setShipped_qty(BigDecimal shipped_qty) {
        this.shipped_qty = shipped_qty;
    }

    public BigDecimal getReturn_qty() {
        return return_qty;
    }

    public void setReturn_qty(BigDecimal return_qty) {
        this.return_qty = return_qty;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public Object getProductData() {
        return productData;
    }

    public void setProductData(Object productData) {
        this.productData = productData;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Integer getItem_coin() {
        return item_coin;
    }

    public void setItem_coin(Integer item_coin) {
        this.item_coin = item_coin;
    }

    public Integer getItem_ticket() {
        return item_ticket;
    }

    public void setItem_ticket(Integer item_ticket) {
        this.item_ticket = item_ticket;
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

    public Integer getPackage_item_flag() {
        return package_item_flag;
    }

    public void setPackage_item_flag(Integer package_item_flag) {
        this.package_item_flag = package_item_flag;
    }

    public Integer getApportioned_ticket() {
        return apportioned_ticket;
    }

    public void setApportioned_ticket(Integer apportioned_ticket) {
        this.apportioned_ticket = apportioned_ticket;
    }

    public Integer getApportioned_coin() {
        return apportioned_coin;
    }

    public void setApportioned_coin(Integer apportioned_coin) {
        this.apportioned_coin = apportioned_coin;
    }
}
