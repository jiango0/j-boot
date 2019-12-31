package com.jzc.spring.coupon.dao.pay;

import com.jzc.spring.coupon.model.PaymentAccountEntity;

import java.util.List;


public interface PaymentAccountMapper {

    List<PaymentAccountEntity> selectList(List<String> ids);

}
