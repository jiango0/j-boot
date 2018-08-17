package com.jzc.spring.boot.test.design.create.singleton;

public class MailSingleton {

    private static class MailFactory {

        private static MailSingleton instance = new MailSingleton();

    }

    public static MailSingleton getInstance() {
        return MailFactory.instance;
    }

    public void outPrint() {
        System.out.println(" out print instance ");
    }

}
