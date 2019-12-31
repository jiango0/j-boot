package com.jzc.spring.boot.transfer.dao.pay;

import com.jzc.spring.boot.transfer.domain.PaymentAccountEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * PaymentAccountMapper
 * 支付台帐mapper
 *
 * @author pottos
 * @version [版本号, 2017/6/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PaymentAccountMapper {
    /**
     * 按id查询支付台帐
     * @param id
     * @return
     */
    PaymentAccountEntity selectPaymentAccountById(BigDecimal id);

    /**
     * 按条件查询台帐
     * @param paramsMap
     * @return
     */
    List<PaymentAccountEntity> selectPaymentAccountList(Map<String, Object> paramsMap);

    /**
     * 新增支付台帐
     * @param paymentAccountEntity
     * @return
     */
    int insertPaymentAccount(PaymentAccountEntity paymentAccountEntity)throws Exception;

    /**
     * 更新台帐信息
     * @param paymentAccountEntity
     * @return
     */
    int updatePaymentAccount(PaymentAccountEntity paymentAccountEntity);

    /**
     * 按订单更新支付状态
     * @param orderid
     * @param pay_status
     * @return
     */
    int updatePaymentAccountByorder(@Param("orderid") String orderid, @Param("pay_status") String pay_status)throws Exception;

    /**
     * 更新第三方支付流水号
     * @param orderId  订单号
     * @param thirdSerialNo  第三方支付流水号
     * @return
     */
    int updatePaymentSerialNoByOrderId(@Param("order_id") String orderId, @Param("third_serial_no") String thirdSerialNo);

    /**
     * 查询最近一个月 流水状态是等待的订单
     * @return
     */
    List<PaymentAccountEntity> findPaymentWithStatusAndTime(@Param("payStatus") int payStatus, @Param("endTime") Date endTime);

    /**
     * ==========作为历史数据迁移用============
     * 删除一条记录
     * @param id
     * @return
     */
    int delete(Long id);

    List<PaymentAccountEntity> selectDateList(Map<String, Object> parma);

    int deleteTransfer(Map condition);

}
