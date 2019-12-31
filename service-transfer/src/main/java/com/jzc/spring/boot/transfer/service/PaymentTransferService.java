package com.jzc.spring.boot.transfer.service;

import java.util.Date;

public interface PaymentTransferService {

    /**
     * 正向订单转换
     *
     * @param startDate
     * @param endDate
     * @param shopId
     */
    void chargesTransfer(Date startDate, Date endDate, String shopId);

    /**
     * 逆向订单转换
     *
     * @param startDate
     * @param endDate
     * @param shopId
     */
    void refundTransfer(Date startDate, Date endDate, String shopId);

}
