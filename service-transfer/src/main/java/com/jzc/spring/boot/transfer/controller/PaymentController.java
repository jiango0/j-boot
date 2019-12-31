package com.jzc.spring.boot.transfer.controller;

import com.jzc.spring.boot.transfer.service.PaymentChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pay")
public class PaymentController {

    @Autowired
    private PaymentChargesService paymentChargesService;

    @RequestMapping(value = "save")
    public String pay() {

        paymentChargesService.insertS();
        paymentChargesService.insertT();

        return "success";
    }

}
