package com.jzc.spring.boot.test.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SinglePool {

    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public void execute(Runnable runnable) {
        singleThreadExecutor.execute(runnable);
    }

}
