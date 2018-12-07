package com.jzc.spring.coupon.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单行
 * @author ShionWong
 * @version V1.0, 2017/11/6
 * @see
 * @since V1.0
 */
public class OrderItem implements Serializable {
    public enum ProductType {
        normal, //正品
        gift,   //赠品
        deposit //押金
    }

    /** 主键 */
    private Long id;

    /** 订单号 */
    private String order_code;

    /** 行号 */
    private String order_item_code;

    /** 套装ID */
    private String package_id;

    /** 商品SKU */
    private String product_sku;

    /** 商品名称 */
    private String item_name;

    /** 缩略图 */
    private String thumbnail;

    /** 单价 */
    private BigDecimal price;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_code() {
        return order_code;
    }

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
}
