package com.jzc.spring.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
//@MapperScan(value = "com.jzc.spring.coupon.dao.*")
public class CouponApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class, args);
    }

}
