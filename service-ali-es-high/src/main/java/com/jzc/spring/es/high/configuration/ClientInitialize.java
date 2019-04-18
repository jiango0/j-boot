package com.jzc.spring.es.high.configuration;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClientInitialize {

    Logger log = LoggerFactory.getLogger(ClientInitialize.class);

    public static RestHighLevelClient client = null;

    @PostConstruct
    public void init() {
        log.info("es begin");
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "Jukey@123"));

        HttpHost[] httpHosts = new HttpHost[1];
        httpHosts[0] = new HttpHost("es-cn-0pp128px3000fvfbi.public.elasticsearch.aliyuncs.com", 9200);

        RestClientBuilder restClientBuilder = RestClient
                .builder(httpHosts)
                .setHttpClientConfigCallback(httpAsyncClientBuilder -> httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider));

        client = new RestHighLevelClient(restClientBuilder);
        log.info("es end");
    }

    public static RestHighLevelClient getClient() {
        return client;
    }

}
