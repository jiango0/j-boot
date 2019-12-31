package com.jzc.spring.boot.transfer.dao.basicpay;

import com.jzc.spring.boot.transfer.domain.PaymentRefund;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * PaymentRefund数据访问对象接口
 *
 * @author
 */
@Mapper
public interface PaymentRefundDAO {

    /**
     * 新增实体信息
     *
     * @param paymentRefund 实体对象
     */
    void insert(PaymentRefund paymentRefund);

    /**
     * 批量新增实体信息
     *
     * @param list 实体对象列表
     */
    void insertByBatch(List<PaymentRefund> list);

    /**
     * 更新实体信息
     *
     * @param paymentRefund 实体对象
     */
    int update(PaymentRefund paymentRefund);

    /**
     * 删除实体信息
     *
     * @param condition 查询条件
     * @return 被删除的记录条数
     */
    int delete(Map condition);

    /**
     * 查询符合条件的实体个数
     *
     * @param condition 查询条件
     * @return 符合条件的实体个数
     */
    int count(Map condition);

    /**
     * 查询符合条件的实体
     *
     * @param condition 查询条件
     * @return 符合条件的实体
     */
    List<PaymentRefund> query(Map condition);

    /**
     * 更新状态状态
     *
     * @param paymentRefund
     */
    int updatePaymentRefund(PaymentRefund paymentRefund);

    /**
     * 批量更新检测状态
     * @param condition
     * @return
     */
    int batchUpdateCheckStatus(Map condition);

    /**
     * 批量填充
     * @param condition
     * @return
     */
    int batchUpdate(Map condition);

    int deleteTransfer(Map condition);

}
