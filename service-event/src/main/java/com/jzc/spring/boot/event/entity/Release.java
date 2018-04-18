package com.jzc.spring.boot.event.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "boot", type = "release")
public class Release {

    @Id
    private Long id;

    private String title;

    private String content;

    private Date createDate;

    private Date lastUpdate;

    private Long createDateLong;

    private Long lastUpdateLong;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getCreateDateLong() {
        return createDateLong;
    }

    public void setCreateDateLong(Long createDateLong) {
        this.createDateLong = createDateLong;
    }

    public Long getLastUpdateLong() {
        return lastUpdateLong;
    }

    public void setLastUpdateLong(Long lastUpdateLong) {
        this.lastUpdateLong = lastUpdateLong;
    }
}
