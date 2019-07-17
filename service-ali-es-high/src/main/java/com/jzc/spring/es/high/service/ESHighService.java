package com.jzc.spring.es.high.service;

import com.jzc.spring.boot.common.entity.PageList;
import com.jzc.spring.es.high.entity.ESHighEntity;

import java.util.List;

public interface ESHighService {

    int batch(List<ESHighEntity> list);

    PageList<ESHighEntity> query(ESHighEntity esHighEntity);

    String multiQuery (ESHighEntity esHighEntity);

}
