package com.jzc.spring.coupon.dao.basicpay;

import com.jzc.spring.coupon.model.PaymentRefund;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * PaymentRefund数据访问对象接口
 *
 * @author
 */
@Mapper
public interface PaymentRefundDAO {

    List<PaymentRefund> selectList(List<String> ids);

}
