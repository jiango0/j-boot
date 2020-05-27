package com.jzc.spring.boot.test;


import com.jzc.spring.boot.test.pool.SchedulePool;
import com.jzc.spring.boot.test.pool.SinglePool;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadPoolProcessorTest {

    @Test
    public void schedulePool() throws InterruptedException {
        SchedulePool pool = new SchedulePool();

        pool.schedule(() -> {
            System.out.println("println 10 seconds");
        }, 10, TimeUnit.SECONDS);

        Thread.sleep(10000);
    }

    @Test
    public void singlePool() throws InterruptedException {
        SinglePool pool = new SinglePool();

        for(int i=0; i<10; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("println singlePool");
            });
        }

        Thread.sleep(11000);
    }

    private static boolean b = false;
    private static int i = 0;

    public static void  main(String[] args) throws Exception {

        System.out.println("1");

        new Thread(() -> {
            try {
                Thread.sleep(100);
                b = true;
                System.out.println("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Integer c = 0;
        while (!b) {
            c++;
        }

        System.out.println("end");

    }

}
