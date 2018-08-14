package com.jzc.spring.boot.test.threads;

public class WaitThreads {

    private Integer count = new Integer(1);

    public void out(String name) {

        synchronized (this) {

            try {
                for(int i=0; i<50; i++) {
                    this.notify();
                    System.out.println(name + count++);
                    this.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.notify();
            }

        }

    }

}
