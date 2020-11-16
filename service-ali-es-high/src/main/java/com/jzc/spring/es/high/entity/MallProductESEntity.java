package com.jzc.spring.es.high.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author zhouqi
 * @date ${date} ${time}
 * @params ${params}
 * @return ${return}
 */
public class MallProductESEntity {
    public static final String ES_INDEX_PRE = "ty_app_product_dhsc";

    //sku编码
    private String skuId;
    //sku名称
    private String skuName;
    //品牌名称
    private String brandName;
    //京东价格
    private BigDecimal standardPrice;
    //条码
    private String barcode;
    //主图
    private String thumbnail;
    //商品单位
    private Integer goodsUnit;
    private String goodsUnitName;
    private Integer goodsType;
    private Integer goodsStatus;
    private String goodsHtml;
    //第三方sku
    private String tpSku;
    //第三方分类id
    private String tpCategory;
    //第三方partnerSign
    private String partnerSign;
    //sys_goods
    private String sysGoodsId;
    private Integer sysGoodsStatus;

    //本地分类id(末级分类)
    private String sysCategoryId;
    //本地分类名称
    private String sysCategoryName;

    //channel_goods
    private String channelGoodsId;
    private String merchantId;
    //门店id
//    private String shopId;
    //门店名称
//    private String shopName;
    //系统id
    private String sysId;
    //渠道id(4 小程序)
    private String channelId;
    private String title;
    //上下架状态(0 待上架 1已上架 2已下架)
    private Integer channelGoodsStatus;
    //上架时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date listingAt;
    //下架时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date delistingAt;
    //操作时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operatedAt;
    private Integer isShow;
    //排序
    private Integer sortNo;
    //销量
//    private Integer dealCount;
    //产地
    private String productArea;
    //包装清单
    private String wareQD;
    //规格参数
    private String param;

    //价格详情列表
    private List<GoodsPriceResultDTO> goodsPrices;
    private BigDecimal goodsPrices0;
    //积分价格
    private BigDecimal goodsPrices1;
    //飞豆价格
    private BigDecimal goodsPrices2;
    //媒体信息列表
    private List<MultimediaVO> multimediaList;

    public static String getEsIndexPre() {
        return ES_INDEX_PRE;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BigDecimal getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(BigDecimal standardPrice) {
        this.standardPrice = standardPrice;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(Integer goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsUnitName() {
        return goodsUnitName;
    }

    public void setGoodsUnitName(String goodsUnitName) {
        this.goodsUnitName = goodsUnitName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsHtml() {
        return goodsHtml;
    }

    public void setGoodsHtml(String goodsHtml) {
        this.goodsHtml = goodsHtml;
    }

    public String getTpSku() {
        return tpSku;
    }

    public void setTpSku(String tpSku) {
        this.tpSku = tpSku;
    }

    public String getTpCategory() {
        return tpCategory;
    }

    public void setTpCategory(String tpCategory) {
        this.tpCategory = tpCategory;
    }

    public String getPartnerSign() {
        return partnerSign;
    }

    public void setPartnerSign(String partnerSign) {
        this.partnerSign = partnerSign;
    }

    public String getSysGoodsId() {
        return sysGoodsId;
    }

    public void setSysGoodsId(String sysGoodsId) {
        this.sysGoodsId = sysGoodsId;
    }

    public Integer getSysGoodsStatus() {
        return sysGoodsStatus;
    }

    public void setSysGoodsStatus(Integer sysGoodsStatus) {
        this.sysGoodsStatus = sysGoodsStatus;
    }

    public String getSysCategoryId() {
        return sysCategoryId;
    }

    public void setSysCategoryId(String sysCategoryId) {
        this.sysCategoryId = sysCategoryId;
    }

    public String getSysCategoryName() {
        return sysCategoryName;
    }

    public void setSysCategoryName(String sysCategoryName) {
        this.sysCategoryName = sysCategoryName;
    }

    public String getChannelGoodsId() {
        return channelGoodsId;
    }

    public void setChannelGoodsId(String channelGoodsId) {
        this.channelGoodsId = channelGoodsId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getChannelGoodsStatus() {
        return channelGoodsStatus;
    }

    public void setChannelGoodsStatus(Integer channelGoodsStatus) {
        this.channelGoodsStatus = channelGoodsStatus;
    }

    public Date getListingAt() {
        return listingAt;
    }

    public void setListingAt(Date listingAt) {
        this.listingAt = listingAt;
    }

    public Date getDelistingAt() {
        return delistingAt;
    }

    public void setDelistingAt(Date delistingAt) {
        this.delistingAt = delistingAt;
    }

    public Date getOperatedAt() {
        return operatedAt;
    }

    public void setOperatedAt(Date operatedAt) {
        this.operatedAt = operatedAt;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public String getWareQD() {
        return wareQD;
    }

    public void setWareQD(String wareQD) {
        this.wareQD = wareQD;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public List<GoodsPriceResultDTO> getGoodsPrices() {
        return goodsPrices;
    }

    public void setGoodsPrices(List<GoodsPriceResultDTO> goodsPrices) {
        this.goodsPrices = goodsPrices;
    }

    public BigDecimal getGoodsPrices0() {
        return goodsPrices0;
    }

    public void setGoodsPrices0(BigDecimal goodsPrices0) {
        this.goodsPrices0 = goodsPrices0;
    }

    public BigDecimal getGoodsPrices1() {
        return goodsPrices1;
    }

    public void setGoodsPrices1(BigDecimal goodsPrices1) {
        this.goodsPrices1 = goodsPrices1;
    }

    public BigDecimal getGoodsPrices2() {
        return goodsPrices2;
    }

    public void setGoodsPrices2(BigDecimal goodsPrices2) {
        this.goodsPrices2 = goodsPrices2;
    }

    public List<MultimediaVO> getMultimediaList() {
        return multimediaList;
    }

    public void setMultimediaList(List<MultimediaVO> multimediaList) {
        this.multimediaList = multimediaList;
    }
}
