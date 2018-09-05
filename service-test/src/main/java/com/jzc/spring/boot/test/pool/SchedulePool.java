package com.jzc.spring.boot.test.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulePool {

    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    public void schedule(Runnable runnable, int time, TimeUnit timeUnit) {
        scheduledThreadPool.schedule(runnable, time, timeUnit.SECONDS);
    }

}
