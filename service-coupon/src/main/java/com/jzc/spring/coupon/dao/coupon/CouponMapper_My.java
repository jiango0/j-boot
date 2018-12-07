package com.jzc.spring.coupon.dao.coupon;

import com.jzc.spring.coupon.model.Coupon;
import com.jzc.spring.coupon.model.CouponConsume;
import com.jzc.spring.coupon.model.CustomersCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CouponMapper_My {

    List<CustomersCoupon> selectCustomersCoupon(@Param("start") Date start, @Param("end") Date end, @Param("partner_id") String partner_id);

    List<Coupon> selectCouponByIds(@Param("ids") List<String> ids);

    List<CouponConsume> selectCouponConsumeByIds(@Param("ids") List<String> ids);

}
