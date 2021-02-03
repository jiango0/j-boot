package com.jzc.spring.boot.test;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;

public class SchedulerTest {

    public static void main(String[] args) {
        System.out.println("1");
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);
        scheduler.initialize();
        scheduler.schedule(() -> {
            System.out.println("2");
        }, new Date(System.currentTimeMillis() + 3000));
    }

}
