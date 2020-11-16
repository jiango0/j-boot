package com.jzc.spring.es.high.service.impl;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.es.high.configuration.ClientInitialize;
import com.jzc.spring.es.high.entity.ESHighEntity;
import com.jzc.spring.es.high.service.ESOperationalService;
import org.apache.http.client.utils.DateUtils;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ESOperationalServiceImpl implements ESOperationalService {

    private String index = "message";

    @Override
    public void insert(ESHighEntity esHighEntity) throws IOException {
        BulkRequest request = new BulkRequest();
        String json = JSON.toJSONString(esHighEntity);

        IndexRequest indexRequest = new IndexRequest(index).id(esHighEntity.getId()).source(json, XContentType.JSON);
        request.add(new UpdateRequest(index, esHighEntity.getId()).doc(json, XContentType.JSON).upsert(indexRequest));

        BulkResponse bulk = ClientInitialize.getClient().bulk(request, RequestOptions.DEFAULT);
        System.out.println(bulk.hasFailures());
        for (BulkItemResponse bulkItemResponse : bulk) {

            DocWriteResponse itemResponse = bulkItemResponse.getResponse();
            System.out.println("isFailed: " + bulkItemResponse.isFailed());
            System.out.println("failureMessage: " + bulkItemResponse.getFailureMessage());
            BulkItemResponse.Failure failure = bulkItemResponse.getFailure();
            System.out.println("failure: " + JSON.toJSONString(failure));
        }

        System.out.println("insert: " + JSON.toJSON(bulk));
    }

    @Override
    public void update(ESHighEntity esHighEntity) throws IOException {
        BulkRequest request = new BulkRequest();
        String json = JSON.toJSONString(esHighEntity);

        request.add(new UpdateRequest(index, esHighEntity.getId()).doc(json, XContentType.JSON));

        BulkResponse bulk = ClientInitialize.getClient().bulk(request, RequestOptions.DEFAULT);

        System.out.println("update: " + JSON.toJSON(bulk));
    }

    @Override
    public void updateByQuery(ESHighEntity esHighEntity) throws IOException {
        UpdateByQueryRequest request = new UpdateByQueryRequest(index);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        boolQueryBuilder.must(QueryBuilders.termQuery("name", esHighEntity.getName()));
//        boolQueryBuilder.must(QueryBuilders.termQuery("num", esHighEntity.getNum()));
        boolQueryBuilder.must(QueryBuilders.termQuery("message_id.keyword", "dab2fbdf-8a08-4b95-8086-cece2f1e4119"));

        request.setQuery(boolQueryBuilder);

        Map<String, Object> params = new HashMap<>();
        params.put("change_at", DateUtils.parseDate(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"), new String[]{"yyyy-MM-dd HH:mm:ss"}));
        Script script = new Script(ScriptType.INLINE, "painless", "ctx._source.change_at = params.change_at;", params);
        request.setScript(script);


        BulkByScrollResponse bulkByScrollResponse = ClientInitialize.getClient().updateByQuery(request, RequestOptions.DEFAULT);

        System.out.println("updateByQuery: " + JSON.toJSONString(bulkByScrollResponse));
    }

    @Override
    public void delete(ESHighEntity esHighEntity) throws IOException {
        DeleteByQueryRequest request = new DeleteByQueryRequest(index);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("name", esHighEntity.getName()));
        boolQueryBuilder.must(QueryBuilders.termQuery("num", esHighEntity.getNum()));

        request.setQuery(boolQueryBuilder);

        BulkByScrollResponse bulkByScrollResponse = ClientInitialize.getClient().deleteByQuery(request, RequestOptions.DEFAULT);

        System.out.println("deleteByQuery: " + JSON.toJSONString(bulkByScrollResponse));
    }

}
