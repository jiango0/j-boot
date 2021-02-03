package com.jzc.spring.boot.event.controller;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.fluent.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@RestController
public class WeChatController {

    @RequestMapping(value = "pay/micropay")
    public void micropay(HttpServletRequest request) {

        try {
            String xml = IOUtils.toString(request.getInputStream(), "UTF-8");

            System.out.println(xml);

            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "pay/orderquery")
    public Object orderquery(HttpServletRequest request) throws IOException {
        return null;
    }

    @RequestMapping(value = "/")
    public void cc(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getAttributeNames();
        Enumeration<String> parameterNames = request.getParameterNames();

        for (;attributeNames.hasMoreElements();) {
            System.out.println("attributeNames key -> " + attributeNames.nextElement());
        }

        for (;parameterNames.hasMoreElements();) {
            System.out.println("parameterNames key -> " + parameterNames.nextElement());
        }

        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "gateway.do")
    public void alipay(HttpServletRequest request) {
        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
