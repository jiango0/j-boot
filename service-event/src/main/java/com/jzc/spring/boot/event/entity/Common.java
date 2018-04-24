package com.jzc.spring.boot.event.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Map;

@Document(indexName = "boot", type = "common")
public class Common {

    private Long id;

    private Map<String, Object> map;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
