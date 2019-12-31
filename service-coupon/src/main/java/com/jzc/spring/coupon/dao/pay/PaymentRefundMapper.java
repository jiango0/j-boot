package com.jzc.spring.coupon.dao.pay;

import com.jzc.spring.coupon.model.PaymentRefundEntity;

import java.util.List;

/**
 * PaymentRefundMapper
 * 支付退款mapper
 *
 * @author pottos
 * @version [版本号, 2017/6/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]n
 */
public interface PaymentRefundMapper {

    List<PaymentRefundEntity> selectList(List<String> ids);

}
