package com.jzc.spring.boot.test.design.create.abstract_factory.sender;

public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is MailSender");
    }
}
