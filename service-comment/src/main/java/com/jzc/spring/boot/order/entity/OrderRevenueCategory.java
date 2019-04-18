package com.jzc.spring.boot.order.entity;

/**
 * 营业项信息
 * @author 鲁洋
 * @version V1.0, 2019/01/29
 * @see
 * @since V1.0
 */
public class OrderRevenueCategory {
    /** 主键 */
    private Long id;

    private String order_code;

    private String revenue_code;

    private String revenue_name;

    private String merchant_id;

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

    public String getRevenue_code() {
        return revenue_code;
    }

    public void setRevenue_code(String revenue_code) {
        this.revenue_code = revenue_code;
    }

    public String getRevenue_name() {
        return revenue_name;
    }

    public void setRevenue_name(String revenue_name) {
        this.revenue_name = revenue_name;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }
}
