package com.jzc.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages="com.jzc.spring.boot")
public class CommentApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);
    }

}
