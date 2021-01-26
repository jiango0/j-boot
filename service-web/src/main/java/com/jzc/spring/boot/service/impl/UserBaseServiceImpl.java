package com.jzc.spring.boot.service.impl;

import org.springframework.stereotype.Service;

@Service("userBaseService")
public class UserBaseServiceImpl extends AbstractBaseService {

    public void outPrintln() {
        System.out.println("user out print");
    }

}
