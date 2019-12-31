package com.jzc.spring.coupon.dao.basicpay;

import com.jzc.spring.coupon.model.PaymentCharges;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * PaymentCharges数据访问对象接口
 *
 * @author
 */
@Mapper
public interface PaymentChargesDAO {

    List<PaymentCharges> selectList(List<String> ids);

}
