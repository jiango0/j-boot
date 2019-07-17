package com.jzc.spring.es.high.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jzc.spring.boot.common.entity.PageList;
import com.jzc.spring.es.high.configuration.ClientInitialize;
import com.jzc.spring.es.high.entity.ESHighEntity;
import com.jzc.spring.es.high.service.ESHighService;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ESHighServiceImpl implements ESHighService {

    @Override
    public int batch(List<ESHighEntity> list) {
        BulkRequest request = new BulkRequest();

        list.forEach(esHighEntity -> {

            request.add(new IndexRequest("index-test", "test", esHighEntity.getId()).source(JSONObject.toJSONString(esHighEntity), XContentType.JSON).opType(DocWriteRequest.OpType.INDEX));
        });

        try {
            BulkResponse bulkResponse = ClientInitialize.getClient().bulk(request);
            System.out.println(JSONObject.toJSONString(bulkResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public PageList<ESHighEntity> query(ESHighEntity esHighEntity) {
        SearchRequest searchRequest = new SearchRequest("index-test");
        searchRequest.types("test");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (esHighEntity.getNum() != null) {
            boolQueryBuilder.must(QueryBuilders.termQuery("num", esHighEntity.getNum()));
        }
        if (!StringUtils.isEmpty(esHighEntity.getName())) {
            boolQueryBuilder.must(QueryBuilders.matchPhrasePrefixQuery("name", esHighEntity.getName()));
        }

        searchSourceBuilder.query(
                boolQueryBuilder
        );

        searchSourceBuilder.size(0);

        searchRequest.source(searchSourceBuilder);


        try {
            SearchResponse searchResponse = ClientInitialize.getClient().search(searchRequest);

            SearchHits hits = searchResponse.getHits();
            long totalHits = hits.getTotalHits();
            List<ESHighEntity> list = new ArrayList<>();
            PageList<ESHighEntity> result = new PageList<>(1, 10, list, totalHits);

            SearchHit[] array = hits.getHits();
            for (SearchHit hit : array) {
                list.add(JSON.parseObject(hit.getSourceAsString(), ESHighEntity.class));
            }

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String multiQuery (ESHighEntity esHighEntity) {
        MultiSearchRequest request = new MultiSearchRequest();
        request.add(new SearchRequest("index-test").types("test")
                .source(new SearchSourceBuilder().query(QueryBuilders.termQuery("num", esHighEntity.getNum()))));

        try {
            MultiSearchResponse items = ClientInitialize.getClient().multiSearch(request);
            return JSONObject.toJSONString(items);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
