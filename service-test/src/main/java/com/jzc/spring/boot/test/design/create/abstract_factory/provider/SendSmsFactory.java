package com.jzc.spring.boot.test.design.create.abstract_factory.provider;

import com.jzc.spring.boot.test.design.create.abstract_factory.sender.Sender;
import com.jzc.spring.boot.test.design.create.abstract_factory.sender.SmsSender;

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
