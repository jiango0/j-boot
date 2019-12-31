package com.jzc.spring.boot.transfer.dao.pay;

import com.jzc.spring.boot.transfer.domain.PaymentRefundEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    /**
     * 按id查询支付退款
     * @param id
     * @return
     */
    PaymentRefundEntity selectPaymentRefundById(BigDecimal id);

    /**
     * 按条件查询退款台帐集合
     * @param paramsMap
     * @return
     */
    List<PaymentRefundEntity> selectPaymentRefundList(Map<String, Object> paramsMap);

    /**
     * 新增支付退款台帐
     * @param paymentRefundEntity
     * @return
     */
    int insertPaymentRefund(PaymentRefundEntity paymentRefundEntity);
    /**
     * 更新支付退款台帐信息
     * @param paymentRefundEntity
     * @return
     */
    int updatePaymentRefund(PaymentRefundEntity paymentRefundEntity);

    /**
     * 查询订单已退款金额
     * @param orderCode
     * @return
     * @throws Exception
     */
    BigDecimal findOrderRefundAmount(@Param("orderCode") String orderCode) throws Exception;

    /**
     * ==========作为历史数据迁移用============
     * 删除一条记录
     * @param id
     * @return
     */
    int delete(Long id);

    List<PaymentRefundEntity> selectDateList(Map<String, Object> parma);

}
