package com.jzc.spring.es.high.service;

import com.jzc.spring.es.high.entity.ESHighEntity;

import java.io.IOException;

public interface ESOperationalService {

    void insert(ESHighEntity esHighEntity) throws IOException;

    void update(ESHighEntity esHighEntity) throws IOException;

    void updateByQuery(ESHighEntity esHighEntity) throws IOException;

    void delete(ESHighEntity esHighEntity) throws IOException;

}
