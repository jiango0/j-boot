package com.jzc.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class UploadApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class, args);
    }

}
