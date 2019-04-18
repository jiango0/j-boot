package com.jzc.spring.es.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jzc.spring.es.configuration.EsInitialization;
import com.jzc.spring.es.entity.AliESEntity;
import com.jzc.spring.es.entity.CustomizeInfo;
import com.jzc.spring.es.service.AliESService;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class AliESServiceImpl implements AliESService {

    @Autowired
    EsInitialization esService;

    public String createIndex (String index) {
        RestClient restClient = esService.getRestClient();

        try {
            Response response = restClient.performRequest("PUT", index);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public void insert(AliESEntity aliESEntity) {
        RestClient restClient = esService.getRestClient();

        try {
            aliESEntity.setDate(new Date());
            aliESEntity.setDateLong(aliESEntity.getDate().getTime());
            HttpEntity entity = new NStringEntity(JSONObject.toJSONString(aliESEntity), ContentType.APPLICATION_JSON);

            Response response = restClient.performRequest("PUT", "/index-test/test/"+aliESEntity.getId(), Collections.<String, String>emptyMap(), entity);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String list(AliESEntity aliESEntity) {
        RestClient restClient = esService.getRestClient();

        try {
            Response response = restClient.performRequest("GET", "/index-test/test/_search", Collections.<String, String>emptyMap());
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String query(AliESEntity aliESEntity) {
        RestClient restClient = esService.getRestClient();

        try {
            Response response = restClient.performRequest("GET", "/index-test/test/"+aliESEntity.getId(), Collections.<String, String>emptyMap());
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int update(AliESEntity aliESEntity) {
        RestClient restClient = esService.getRestClient();

        try {
            HttpEntity entity = new NStringEntity(JSONObject.toJSONString(aliESEntity), ContentType.APPLICATION_JSON);

            Response response = restClient.performRequest("PUT", "/index-test/test/"+aliESEntity.getId(), Collections.<String, String>emptyMap(), entity);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int delete(String id) {
        RestClient restClient = esService.getRestClient();

        try {
            Response response = restClient.performRequest("DELETE", "/index-test/test/" + id, Collections.<String, String>emptyMap());
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void batchInsert(List<AliESEntity> list) {

    }

    @Override
    public String customize(CustomizeInfo customizeInfo) {
        RestClient restClient = esService.getRestClient();

        try {
            HttpEntity entity = new NStringEntity(JSONObject.toJSONString(customizeInfo.getObj()), ContentType.APPLICATION_JSON);
            Response response = restClient.performRequest(customizeInfo.getMethod(), customizeInfo.getEndpoint(), Collections.<String, String>emptyMap(), entity);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
