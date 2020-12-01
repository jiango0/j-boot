package com.jzc.spring.boot.order.entity;

import java.math.BigDecimal;

public class OrderDetail {

    /**
     * ID
     */
    private String orderDetailId;
    /**
     * PKGID
     */
    private String pkgId;
    /**
     * 商品SKU
     */
    private String goodsSku;
    /**
     * 商品类型
     */
    private Integer goodsType;
    /**
     * 商品分类
     */
    private String goodsCategory;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品数量
     */
    private BigDecimal goodsQty;
    /**
     * 计量单位
     */
    private String goodsUnit;
    /**
     * 图片
     */
    private String goodsPic;
    /**
     * 顺序
     */
    private Integer goodsOrder;
    /**
     * 关联ID
     */
    private String refId;
    /**
     * 第三方商品sku
     */
    private String tpGoodsSku;
    /**
     * 换货数量
     */
    private Integer exchangeQty;
    /**
     * 商品结算价格
     */
    private BigDecimal settlementPrice;
    /**
     * 商品采购价格
     */
    private BigDecimal purchasePrice;

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }

    public String getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(String goodsSku) {
        this.goodsSku = goodsSku;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsQty() {
        return goodsQty;
    }

    public void setGoodsQty(BigDecimal goodsQty) {
        this.goodsQty = goodsQty;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public Integer getGoodsOrder() {
        return goodsOrder;
    }

    public void setGoodsOrder(Integer goodsOrder) {
        this.goodsOrder = goodsOrder;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTpGoodsSku() {
        return tpGoodsSku;
    }

    public void setTpGoodsSku(String tpGoodsSku) {
        this.tpGoodsSku = tpGoodsSku;
    }

    public Integer getExchangeQty() {
        return exchangeQty;
    }

    public void setExchangeQty(Integer exchangeQty) {
        this.exchangeQty = exchangeQty;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
