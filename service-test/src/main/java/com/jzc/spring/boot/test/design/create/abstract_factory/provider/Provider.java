package com.jzc.spring.boot.test.design.create.abstract_factory.provider;

import com.jzc.spring.boot.test.design.create.abstract_factory.sender.Sender;

public interface Provider {

    Sender produce();

}
