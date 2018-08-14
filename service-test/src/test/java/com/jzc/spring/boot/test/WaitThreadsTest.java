package com.jzc.spring.boot.test;

import com.jzc.spring.boot.test.threads.WaitThreads;
import org.junit.Test;

public class WaitThreadsTest {

    @Test
    public void outRun() throws InterruptedException {

        WaitThreads wait = new WaitThreads();

        Thread a = new Thread(() -> {
            wait.out("a");
        });

        Thread b = new Thread(() -> {
            wait.out("b");
        });

        a.start();
        b.start();

        Thread.sleep(1000);

    }

}
