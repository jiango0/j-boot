package com.jzc.spring.boot.test.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantProcessor {

    private Lock lock = new ReentrantLock();

    private Integer i = new Integer(0);

    private AtomicInteger ai = new AtomicInteger(0);

    public Integer getI() {
        return i;
    }

    public AtomicInteger getAi() {
        return ai;
    }

    public void testMethod() {

        System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (this.i++)) );

    }

    public void testMethodLock() {
        lock.lock();
        System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (this.i++)) );
        lock.unlock();
    }

    public void testMethodAtomic() {
        this.ai.addAndGet(1);
    }

    public void testMethodTry() {
        try {
            if(lock.tryLock(300, TimeUnit.MILLISECONDS)) {
                i++;
                Thread.sleep(100);
                lock.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testMethodRead() {
        try {

        } finally {

        }
    }

    public void testMethodWrite() {

    }

}
