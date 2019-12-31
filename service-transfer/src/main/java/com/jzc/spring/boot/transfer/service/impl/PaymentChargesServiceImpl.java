package com.jzc.spring.boot.transfer.service.impl;

import com.jzc.spring.boot.transfer.dao.basicpay.PaymentChargesDAO;
import com.jzc.spring.boot.transfer.domain.PaymentAccountEntity;
import com.jzc.spring.boot.transfer.domain.PaymentCharges;
import com.jzc.spring.boot.transfer.service.PaymentChargesService;
import com.jzc.spring.boot.transfer.util.GenerateId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service
public class PaymentChargesServiceImpl implements PaymentChargesService {

    @Autowired
    PaymentChargesDAO paymentChargesDAO;

    String[] shopIds = new String [] {"7b5e3973-c0c1-46c3-83b2-2ae399704a60",
            "1ebbe15f-f7a3-4ed5-bcb6-9b038100e14f",
            "3c701204-d194-4adf-b6ec-f6e557dd7f3f",
            "e112f925-9e67-4974-ba76-440470b1638c",
            "6b0dee62-e977-4235-91ee-91caf183c8d9",
            "692d6343-d2ef-442c-b362-aade41ab9ad5",
            "c9bc0e20-1ba0-4a1e-9ca3-24d693a1f56a",
            "8136ba8b-ce2a-4f8e-9c8f-ddf7c7518b9b",
            "eaaf2422-712e-4932-83d8-aa963ff70b31",
            "c958e05c-e8ec-4818-9302-4dfa00439e1f"
    };

    @Override
    public void insertS() {
        List<PaymentCharges> list = new ArrayList<>();
        for (int i=0; i<5; i++) {
            list.add(this.toPaymentCharges());
        }
        paymentChargesDAO.insertS(list);
    }

    @Override
    public void insertT() {
        List<PaymentCharges> list = new ArrayList<>();
        for (int i=0; i<5; i++) {
            list.add(this.toPaymentCharges());
        }
        paymentChargesDAO.insertT(list);
    }

    private PaymentCharges toPaymentCharges() {
        Date now = new Date();
        PaymentCharges paymentCharges = new PaymentCharges();

        Random random = new Random();
        String shopId = shopIds[random.nextInt(9)];

        paymentCharges.setPaymentChagesId(UUID.randomUUID().toString());
        paymentCharges.setTxId(GenerateId.nextId(shopId));
        paymentCharges.setMerchantId("dwj");
        paymentCharges.setShopId(shopId);
        paymentCharges.setOrderChannel(0);
        paymentCharges.setOutTradeNo(GenerateId.nextId(shopId));
        paymentCharges.setOrderCode(GenerateId.nextId(shopId));
        paymentCharges.setUserId(UUID.randomUUID().toString());
        paymentCharges.setPayProvider(1);
        paymentCharges.setPayChannel(1);
        paymentCharges.setPayType(1);
        paymentCharges.setSubject("索引性能测试");
        paymentCharges.setPayStatus(1);
        paymentCharges.setAmount(BigDecimal.valueOf(0.01));
        paymentCharges.setDiscount(BigDecimal.ZERO);
        paymentCharges.setOddChange(BigDecimal.ZERO);
        paymentCharges.setCancelType(null);
        paymentCharges.setCreatedAt(now);
        paymentCharges.setUpdatedAt(now);
        paymentCharges.setBillTime(now);
        paymentCharges.setRemark("索引性能测试");

        return paymentCharges;
    }

}
