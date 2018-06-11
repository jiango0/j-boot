package com.jzc.spring.boot.test;

import com.jzc.spring.boot.common.pool.ThreadPoolUtils;
import com.jzc.spring.boot.test.reentrant.ReentrantProcessor;
import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ReentrantProcessorTest {

    private void runSleep() {
        try {
            Thread.sleep(1000);
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
    public void runThread() {
        ReentrantProcessor processor2 = new ReentrantProcessor();
        createThread(processor2::testMethod);
        System.out.println(processor2.getI());
    }

    @Test
    public void runThreadLock() {
        ReentrantProcessor processor2 = new ReentrantProcessor();
        createThread(processor2::testMethodLock);
        System.out.println(processor2.getI());
    }

    @Test
    public void runThreadAtomic() {
        ReentrantProcessor processor2 = new ReentrantProcessor();
        createThread(processor2::testMethodAtomic);
        System.out.println(processor2.getAi());
    }

    @Test
    public void runThreadTry() {
        ReentrantProcessor processor2 = new ReentrantProcessor();
        createThread(processor2::testMethodTry);
        System.out.println(processor2.getI());
    }

}
