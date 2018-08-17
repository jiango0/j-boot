package com.jzc.spring.boot.test.design.create.abstract_factory.provider;

import com.jzc.spring.boot.test.design.create.abstract_factory.sender.MailSender;
import com.jzc.spring.boot.test.design.create.abstract_factory.sender.Sender;

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
