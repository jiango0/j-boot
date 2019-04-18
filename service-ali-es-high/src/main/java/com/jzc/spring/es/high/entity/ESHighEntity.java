package com.jzc.spring.es.high.entity;

import java.util.Date;

public class ESHighEntity {

    private String id;

    private String name;

    private Integer num;

    private Date date;

    private Long dateLong;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDateLong() {
        return dateLong;
    }

    public void setDateLong(Long dateLong) {
        this.dateLong = dateLong;
    }

}
