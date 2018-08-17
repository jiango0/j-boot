package com.jzc.spring.boot.test.design.create.abstract_factory.sender;

public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is SmsSender");
    }
}
