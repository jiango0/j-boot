package com.jzc.spring.statistics.model;

import com.jzc.spring.boot.common.entity.GenericEntity;

import java.util.Date;

public class IntegralStatistics extends GenericEntity {

    private String shop_id;

    private String shop_name;

    private String address;

    private Integer num;

    private Integer v1_num;

    private Integer v2_num;

    private Integer v3_num;

    private Date create_time;

    private Long create_time_long;

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getV1_num() {
        return v1_num;
    }

    public void setV1_num(Integer v1_num) {
        this.v1_num = v1_num;
    }

    public Integer getV2_num() {
        return v2_num;
    }

    public void setV2_num(Integer v2_num) {
        this.v2_num = v2_num;
    }

    public Integer getV3_num() {
        return v3_num;
    }

    public void setV3_num(Integer v3_num) {
        this.v3_num = v3_num;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getCreate_time_long() {
        return create_time_long;
    }

    public void setCreate_time_long(Long create_time_long) {
        this.create_time_long = create_time_long;
    }
}
