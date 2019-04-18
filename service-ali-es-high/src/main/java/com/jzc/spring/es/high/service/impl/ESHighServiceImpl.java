package com.jzc.spring.es.high.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jzc.spring.es.high.configuration.ClientInitialize;
import com.jzc.spring.es.high.entity.ESHighEntity;
import com.jzc.spring.es.high.service.ESHighService;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ESHighServiceImpl implements ESHighService {

    @Override
    public int batch(List<ESHighEntity> list) {
        BulkRequest request = new BulkRequest();

        list.forEach(esHighEntity -> request.add(new IndexRequest("index-test", "test", "10").source(JSONObject.toJSON(esHighEntity))));

        try {
            BulkResponse bulkResponse = ClientInitialize.getClient().bulk(request);
            System.out.println(bulkResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public String query(ESHighEntity esHighEntity) {
        return null;
    }

}
