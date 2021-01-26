package com.jzc.spring.boot.service.impl;

import org.springframework.stereotype.Service;

@Service("orderBaseService")
public class OrderBaseServiceImpl extends AbstractBaseService {

    public void outPrintln() {
        System.out.println("order out print");
    }

}
