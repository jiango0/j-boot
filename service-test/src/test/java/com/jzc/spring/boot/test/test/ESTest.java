package com.jzc.spring.boot.test.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

@Slf4j
public class ESTest {

    @Value("classpath:json/img_data.json")
    private Resource resource;

    public static String PRODUCT_INDEX = "ty-product-";
    public static String PRODUCT_TYPE = "products";

    private String clusterName = "shopping-mall";

    private String clusterNodes = "node59.es01.srv.prod.idc01.toonyoo-inc.net:9300,node60.es01.srv.prod.idc01.toonyoo-inc.net:9300,node64.es01.srv.prod.idc01.toonyoo-inc.net:9300";

    @Test
    public void esQuery() throws IOException {

        List<Map<String, Object>> data = ESData.getData("json/img_data");

        log.info("map {}", JSON.toJSONString(data));

//        String partnerSign = "5A018984-B053-4C59-AE83-A5277A7349EB".toLowerCase();

//        TransportClient transportClient = getTransportClient();
//        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(PRODUCT_INDEX + partnerSign);
//        searchRequestBuilder.setTypes(PRODUCT_TYPE);
//
//        BoolQueryBuilder qb = QueryBuilders.boolQuery();
//        qb.must(QueryBuilders.matchQuery("id", 9971));
//        qb.must(QueryBuilders.matchQuery("curpage", 1));
//        qb.must(QueryBuilders.matchQuery("pagesize", 50));
//        searchRequestBuilder.setQuery(qb);
//
//        SearchResponse searchResponse = searchRequestBuilder.get();
//
//        log.info("searchResponse {} ", JSONObject.toJSONString(searchResponse));

    }

    private TransportClient getTransportClient() {
        TransportClient client = null;

        try {
            Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName)
//			        .put("TransportClient.transport.sniff", true)
                    .put("client.transport.sniff", false)
                    .build();

            client = TransportClient.builder().settings(settings).build();

            String[] esClusterNode = clusterNodes.split(",");

            for (String node : esClusterNode) {
                String[] hostPort = node.split(":");

                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostPort[0]), Integer.parseInt(hostPort[1])));
            }

        } catch (Exception e) {
            log.error("异常处理", e);
        }

        return client;
    }


}
