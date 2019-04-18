package com.jzc.spring.es.service;

import com.jzc.spring.es.entity.AliESEntity;
import com.jzc.spring.es.entity.CustomizeInfo;

import java.util.List;

public interface AliESService {

    String createIndex (String index);

    void insert(AliESEntity aliESEntity);

    int delete(String id);

    int update(AliESEntity aliESEntity);

    String list(AliESEntity aliESEntity);

    String query(AliESEntity aliESEntity);

    void batchInsert(List<AliESEntity> list);

    String customize(CustomizeInfo customizeInfo);

}
