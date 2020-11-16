package com.jzc.spring.boot.test.event;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzc.spring.boot.test.Application;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.fluent.Request;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductEventTest {

    @Value(value = "classpath:json/img_data")
    private Resource resource;

    public static String PRODUCT_INDEX = "ty-product-";
    public static String PRODUCT_TYPE = "products";


//    private String clusterName = "toonyoo-rc2";
//    private String clusterNodes = "10.200.50.142:9300";
//    private String urlSource = "toonyoo-test.oss-cn-beijing.aliyuncs.com";
//    private String urlTarget = "oss.kiscloud.net";



    private String clusterName = "shopping-mall";
    private String clusterNodes = "10.100.12.51:9300";
    private String urlSource = "toonyoo-static.oss-cn-beijing.aliyuncs.com";
    private String urlTarget = "oss.kiscloud.net";



    @Test
    public void getData() throws IOException {

        String dataStr = jsonRead(resource.getFile());

        log.info("dataStr {} ", dataStr);

    }

    @Test
    public void checkUrl() throws IOException {
        String dataStr = jsonRead(resource.getFile());
        List<Map<String, String>> list = toObject(dataStr, new TypeReference<List<Map<String, String>>>() {
        });

        int fail = 0;
        for (Map<String, String> map : list) {
            String image_url = map.get("image_url");
            String link_url = map.get("link_url");

            image_url = image_url.replace(urlSource, urlTarget);
            link_url = link_url.replace(urlSource, urlTarget);

            int image_i = downloadHttpCode(image_url);
            int image_l = downloadHttpCode(link_url);

            if (image_i != 200) {
                fail++;
            }
            if (image_l != 200) {
                fail++;
            }
        }

        log.info("fail result {} ", fail);
    }

    @Test
    public void getESInfo() throws IOException {
        String dataStr = jsonRead(resource.getFile());
        List<Map<String, String>> list = toObject(dataStr, new TypeReference<List<Map<String, String>>>() {
        });
        List<Map<String, Object>> existList = new ArrayList<>();
        List<UpdateRequestBuilder> eslist = new ArrayList<>();
        TransportClient transportClient = getTransportClient();

        for (Map<String, String> param : list) {
            String partner_sign = param.get("partner_sign");
            String product_sku = param.get("product_sku");

            SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(PRODUCT_INDEX + partner_sign.toLowerCase());
            searchRequestBuilder.setTypes(PRODUCT_TYPE);

            BoolQueryBuilder qb = QueryBuilders.boolQuery();
            qb.must(QueryBuilders.matchQuery("product_sku", product_sku));
            searchRequestBuilder.setQuery(qb);

            searchRequestBuilder.setFrom(0);
            searchRequestBuilder.setSize(500);

            SearchResponse searchResponse = searchRequestBuilder.get();
            List<Map<String, Object>> result = new ArrayList<>();
            SearchHit[] hits = searchResponse.getHits().hits();
            for (SearchHit searchHit : hits) {
                result.add(searchHit.getSource());
            }

            log.info("result {} ", toStr(result));

            if (!CollectionUtils.isEmpty(result)) {
                existList.addAll(result);
            }
            Map<String,Object> map2 = new HashMap<>();
            if (!CollectionUtils.isEmpty(result)) {
                for (Map<String, Object> map : result) {
                    String id = map.get("id").toString();
                    Object images = map.get("images");
                    if (images != null) {
                        List list1 = (List) images;
                        boolean re = false;
                        for (Object image : list1) {
                            Map<String, String> image1 = (Map<String, String>) image;
                            String image_url1 = image1.get("image_url");
                            String link_url1 = image1.get("link_url");
                            if (!StringUtils.isBlank(image_url1)) {
                                if (image_url1.contains(urlTarget)) {
                                    re = true;
                                    break;
                                }
                                image1.put("image_url", image_url1.replace(urlSource, urlTarget));
                            }
                            if (!StringUtils.isBlank(link_url1)) {
                                image1.put("link_url", link_url1.replace(urlSource, urlTarget));
                            }
                        }
                        if (re) {
                            continue;
                        }

                        log.info("result images {} ", toStr(map));
                        UpdateRequestBuilder images1 = transportClient.prepareUpdate(PRODUCT_INDEX + partner_sign.toLowerCase(), PRODUCT_TYPE, id)
                                .setDoc("images", images);
                        eslist.add(images1);
                    }
                }
            }

        }

        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();
        for (UpdateRequestBuilder updateRequestBuilder : eslist) {
            bulkRequestBuilder.add(updateRequestBuilder);
        }
        bulkRequestBuilder.execute().actionGet();

        log.info("existList size {} ", existList.size());
        log.info("eslist size {} ", eslist.size());

    }

    private int downloadHttpCode(String url) throws IOException {
        log.info(url);
        HttpResponse httpResponse = Request.Get(url).execute().returnResponse();
        StatusLine statusLine = httpResponse.getStatusLine();

        return statusLine.getStatusCode();
    }

    public static <T> T toObject(String content, TypeReference<T> valueType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String toStr(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String jsonRead(File file){
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer.toString();
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
