package com.jzc.spring.boot.common.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {

    private static final ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
            8,
            40,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10000),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void execute(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

}
