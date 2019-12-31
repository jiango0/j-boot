package com.jzc.spring.boot.transfer.dao.basicpay;

import com.jzc.spring.boot.transfer.domain.PaymentCharges;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * PaymentCharges数据访问对象接口
 *
 * @author
 */
@Mapper
public interface PaymentChargesDAO {

    /**
     * 新增实体信息
     *
     * @param paymentCharges 实体对象
     */
    void insert(PaymentCharges paymentCharges);

    /**
     * 批量新增实体信息
     *
     * @param list 实体对象列表
     */
    void insertByBatch(List<PaymentCharges> list);

    /**
     * 更新实体信息
     *
     * @param paymentCharges 实体对象
     */
    int update(PaymentCharges paymentCharges);

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
    List<PaymentCharges> query(Map condition);

    /**
     * 更新实体信息
     *
     * @param paymentCharges 实体对象
     */
    int updatePaymentCharges(PaymentCharges paymentCharges);

    /**
     * 批量更新对账状态
     *
     * @param condition
     * @return
     */
    int batchUpdateCheckStatus(Map condition);

    /**
     * 批量填充
     *
     * @param condition
     * @return
     */
    int batchUpdate(Map condition);

    /**
     * 查询取消状态为未知的记录
     *
     * @param condition
     * @return result
     */
    List<PaymentCharges> queryCancelTypeList(Map condition);

    int deleteTransfer(Map condition);


    void insertS(List<PaymentCharges> list);

    void insertT(List<PaymentCharges> list);

}
