package com.jzc.spring.boot.test;

import com.jzc.spring.boot.test.design.create.abstract_factory.provider.Provider;
import com.jzc.spring.boot.test.design.create.abstract_factory.provider.ProviderProxy;
import com.jzc.spring.boot.test.design.create.singleton.MailSingleton;
import org.junit.Test;

public class DesignProcessorTest {

    /**
     * 抽象工厂模式
     * */
    @Test
    public void abstractFactory() {
        Provider provider = ProviderProxy.getProvider("mail");
        provider.produce().Send();

        Provider provider1 = ProviderProxy.getProvider("sms");
        provider1.produce().Send();
    }

    @Test
    public void singleton() {
        MailSingleton mailSingleton = MailSingleton.getInstance();
        mailSingleton.outPrint();
    }

}
