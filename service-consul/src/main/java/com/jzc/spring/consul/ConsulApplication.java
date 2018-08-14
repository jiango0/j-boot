package com.jzc.spring.consul;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(scanBasePackages={"com.jzc.spring.consul"})
@EnableFeignClients
@EnableDiscoveryClient
public class ConsulApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(ConsulApplication.class).bannerMode(Banner.Mode.CONSOLE).registerShutdownHook(true).web(true);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication.class, args);
    }

}
