package com.jzc.spring.es.configuration;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EsInitialization {

    Logger log = LoggerFactory.getLogger(EsInitialization.class);

    RestClient restClient = null;

    @PostConstruct
    public void init() {
        log.info("es init");

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("elastic", "Jukey@123"));

        restClient = RestClient
                .builder(new HttpHost("es-cn-0pp128px3000fvfbi.public.elasticsearch.aliyuncs.com", 9200))
                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpAsyncClientBuilder) {
                return httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            }
        }).build();

        log.info("es build");
    }

    public RestClient getRestClient() {
        return restClient;
    }
}
