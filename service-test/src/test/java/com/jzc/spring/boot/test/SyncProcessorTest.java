package com.jzc.spring.boot.test;

import com.jzc.spring.boot.common.pool.ThreadPoolUtils;
import com.jzc.spring.boot.test.sync.SyncProcessor;
import org.junit.Test;

public class SyncProcessorTest {



    private void runSleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createThread(Runnable runnable) {
        ThreadPoolUtils.execute(runnable);
        ThreadPoolUtils.execute(runnable);
        ThreadPoolUtils.execute(runnable);
        ThreadPoolUtils.execute(runnable);
        ThreadPoolUtils.execute(runnable);

        this.runSleep();
    }

    @Test
    public void syncThread () {
        SyncProcessor sync = new SyncProcessor();
        createThread(sync::testMethod);
    }

}
