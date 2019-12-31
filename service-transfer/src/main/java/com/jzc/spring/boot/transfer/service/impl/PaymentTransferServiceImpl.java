package com.jzc.spring.boot.transfer.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jzc.spring.boot.transfer.dao.basicpay.PaymentChargesDAO;
import com.jzc.spring.boot.transfer.dao.basicpay.PaymentRefundDAO;
import com.jzc.spring.boot.transfer.dao.pay.PaymentAccountMapper;
import com.jzc.spring.boot.transfer.dao.pay.PaymentRefundMapper;
import com.jzc.spring.boot.transfer.domain.PaymentAccountEntity;
import com.jzc.spring.boot.transfer.domain.PaymentCharges;
import com.jzc.spring.boot.transfer.domain.PaymentRefund;
import com.jzc.spring.boot.transfer.domain.PaymentRefundEntity;
import com.jzc.spring.boot.transfer.service.PaymentTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PaymentTransferServiceImpl implements PaymentTransferService {

    @Autowired
    PaymentChargesDAO paymentChargesDAO;
    @Autowired
    PaymentRefundDAO paymentRefundDAO;
    @Autowired
    PaymentAccountMapper paymentAccountMapper;
    @Autowired
    PaymentRefundMapper paymentRefundMapper;

    private String merchantId = "40ed3fb4-6b8a-4606-9cb3-a1e8bba5584b";

    /**
     * 正向订单转换
     *
     * @param startDate
     * @param endDate
     * @param shopId
     */
    public void chargesTransfer(Date startDate, Date endDate, String shopId) {
        Long id = null;
        List<Long> failList = new ArrayList<>();
        Map<String, Object> parma = new HashMap<>();
        parma.put("startDate", startDate);
        parma.put("endDate", endDate);
        parma.put("shopId", shopId);

        int deleteCount = paymentChargesDAO.deleteTransfer(parma);
        log.info("delete count {} ", deleteCount);
        do {
            parma.put("id", id);
            parma.put("count", 500);

            List<PaymentAccountEntity> list = paymentAccountMapper.selectDateList(parma);
            if (!CollectionUtils.isEmpty(list)) {
                list = list.stream()
                        .filter(paymentAccountEntity -> paymentAccountEntity.getId() != null)
                        .collect(Collectors.toList());
            }
            if (CollectionUtils.isEmpty(list)) {
                log.info("payment list is empty");
                break;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                PaymentAccountEntity paymentAccountEntity = list.get(i);
                try {
                    if (paymentAccountEntity != null) {
                        id = paymentAccountEntity.getId();
                        PaymentCharges paymentCharges = this.toPaymentCharges(paymentAccountEntity);
                        paymentChargesDAO.insert(paymentCharges);
                    }
                } catch (Exception e) {
                    log.error("支付迁移失败", e);
                    failList.add(paymentAccountEntity.getId());
                }
            }
        } while (id != null);

        log.info("chargesTransfer fail size {} fail list {} ", failList.size(), JSON.toJSONString(failList));
    }

    /**
     * 逆向订单转换
     *
     * @param startDate
     * @param endDate
     * @param shopId
     */
    public void refundTransfer(Date startDate, Date endDate, String shopId) {
        Long id = null;
        List<Long> failList = new ArrayList<>();
        Map<String, Object> parma = new HashMap<>();
        parma.put("startDate", startDate);
        parma.put("endDate", endDate);
        parma.put("shopId", shopId);

        int deleteCount = paymentRefundDAO.deleteTransfer(parma);
        log.info("delete count {} ", deleteCount);
        do {

            parma.put("id", id);
            parma.put("count", 500);

            List<PaymentRefundEntity> list = paymentRefundMapper.selectDateList(parma);
            if (!CollectionUtils.isEmpty(list)) {
                list = list.stream()
                        .filter(paymentRefundEntity -> paymentRefundEntity.getId() != null)
                        .collect(Collectors.toList());
            }
            if (CollectionUtils.isEmpty(list)) {
                log.info("refund list is empty");
                break;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                PaymentRefundEntity paymentRefundEntity = list.get(i);
                try {
                    if (paymentRefundEntity != null) {
                        id = paymentRefundEntity.getId();
                        PaymentRefund paymentRefund = this.toPaymentRefund(paymentRefundEntity);
                        paymentRefundDAO.insert(paymentRefund);
                    }
                } catch (Exception e) {
                    log.error("支付迁移失败", e);
                    failList.add(paymentRefundEntity.getId());
                }
            }
        } while (id != null);

        log.info("refundTransfer fail size {} fail list {} ", failList.size(), JSON.toJSONString(failList));
    }

    private PaymentCharges toPaymentCharges(PaymentAccountEntity paymentAccountEntity) {
        PaymentCharges paymentCharges = new PaymentCharges();

        paymentCharges.setPaymentChagesId(UUID.randomUUID().toString());
        paymentCharges.setTxId(paymentAccountEntity.getPayment_serial_no());
        paymentCharges.setMerchantId(paymentAccountEntity.getMerchant_id() == null ? merchantId : paymentAccountEntity.getMerchant_id());
        paymentCharges.setShopId(paymentAccountEntity.getShop_id() != null ? paymentAccountEntity.getShop_id().toLowerCase() : paymentAccountEntity.getShop_id());
        paymentCharges.setOrderChannel(toOrderChannel(paymentAccountEntity.getPay_platform()));
        paymentCharges.setOutTradeNo(paymentAccountEntity.getThird_serial_no());
        paymentCharges.setOrderCode(paymentAccountEntity.getOrder_id());
        paymentCharges.setUserId(paymentAccountEntity.getOpen_id());
        paymentCharges.setPayProvider(1);
        paymentCharges.setPayChannel(toPayTypePay(paymentAccountEntity.getPay_type()));
        paymentCharges.setPayType(toPayType(paymentAccountEntity.getPay_code()));
        paymentCharges.setSubject("老数据迁移" + ("UNION".equalsIgnoreCase(paymentAccountEntity.getPay_code()) ? "(银联支付)" : ""));
        paymentCharges.setPayStatus(paymentAccountEntity.getPay_status() != null ? toPayStatus(paymentAccountEntity.getPay_status().intValue()) : null);
        paymentCharges.setAmount(paymentAccountEntity.getPay_price());
        paymentCharges.setDiscount(paymentAccountEntity.getFree_amount());
        paymentCharges.setOddChange(paymentAccountEntity.getOdd_change());
        paymentCharges.setCancelType(paymentAccountEntity.getCancel_action() != null ? toCancelType(paymentAccountEntity.getCancel_action().ordinal()) : null);
        paymentCharges.setCreatedAt(paymentAccountEntity.getCreatetime());
        paymentCharges.setUpdatedAt(paymentAccountEntity.getUpdatetime());
        paymentCharges.setBillTime(paymentAccountEntity.getFinished_time());
        paymentCharges.setRemark(paymentAccountEntity.getPay_remark());

        return paymentCharges;
    }

    private PaymentRefund toPaymentRefund(PaymentRefundEntity paymentRefundEntity) {
        PaymentRefund paymentRefund = new PaymentRefund();

        paymentRefund.setPaymentRefundId(UUID.randomUUID().toString());
        paymentRefund.setRefundTxId(null);
        paymentRefund.setTxId(paymentRefundEntity.getPayment_serial_no());
        paymentRefund.setOrderCode(paymentRefundEntity.getOrder_id());
        paymentRefund.setMerchantId(paymentRefundEntity.getMerchant_id() == null ? merchantId : paymentRefundEntity.getMerchant_id());
        paymentRefund.setShopId(paymentRefundEntity.getShop_code());
        Map<String, Object> condition = new HashMap<>();
        condition.put("orderCode", paymentRefundEntity.getOrder_id());
        List<PaymentCharges> query = paymentChargesDAO.query(condition);
        paymentRefund.setOrderChannel(CollectionUtils.isEmpty(query) ? null : query.get(0).getOrderChannel());
        paymentRefund.setOutTradeNo(paymentRefundEntity.getThird_serial_no());
        paymentRefund.setRefundStatus(paymentRefundEntity.getRefund_status() != null ? toRefundStatus(paymentRefundEntity.getRefund_status().intValue()) : null);
        paymentRefund.setPayProvider(1);
        paymentRefund.setPayChannel(CollectionUtils.isEmpty(query) ? null : query.get(0).getPayChannel());
        paymentRefund.setPayType(toPayType(paymentRefundEntity.getPay_code()));
        paymentRefund.setRefundAmount(paymentRefundEntity.getRefund_amount());
        paymentRefund.setFee(paymentRefundEntity.getAmount_fee());
        paymentRefund.setCreatedAt(paymentRefundEntity.getCreatetime());
        paymentRefund.setUpdatedAt(paymentRefundEntity.getCreatetime());
        paymentRefund.setBillTime(paymentRefundEntity.getCreatetime());
        paymentRefund.setRemark(paymentRefundEntity.getRefund_remark() + "(老数据迁移)");

        return paymentRefund;
    }

    private Integer toPayType(String payCode) {
        Integer payType = null;
        if ("ALIPAY".equalsIgnoreCase(payCode)) {
            payType = 2;
        } else if ("WEIXIN".equalsIgnoreCase(payCode)) {
            payType = 1;
        } else if ("CASH".equalsIgnoreCase(payCode)) {
            payType = 4;
        } else if ("UNION".equalsIgnoreCase(payCode)) {
            //老数据为银联支付的现在都标识为现金
            payType = 4;
        } else if ("TRANSFER_TO_PUBLIC_ACCOUNT".equalsIgnoreCase(payCode)) {
            payType = 5;
        }

        return payType;
    }

    private Integer toOrderChannel(String payPlatform) {
        Integer orderChannel = null;
        if ("WECHAT_MALL".equalsIgnoreCase(payPlatform)) {
            orderChannel = 0;
        } else if ("ALL_IN_ONE_MACHINE".equalsIgnoreCase(payPlatform)) {
            orderChannel = 1;
        } else if ("SWIPE_MACHINE".equalsIgnoreCase(payPlatform)) {
            orderChannel = 2;
        } else if ("BOSS_ORDER".equalsIgnoreCase(payPlatform)) {
            orderChannel = 3;
        } else if ("TEAM_BUY_KOUBEI".equalsIgnoreCase(payPlatform)) {
            orderChannel = 4;
        } else if ("MEI_TUAN".equalsIgnoreCase(payPlatform)) {
            orderChannel = 5;
        }

        return orderChannel;
    }

    private Integer toPayChannel(String payMethod) {
        Integer payChannel = null;
        if ("AUTH_CODE_PAY".equalsIgnoreCase(payMethod)) {
            payChannel = 2;
        } else if ("QR_CODE_PAY".equalsIgnoreCase(payMethod)) {
            payChannel = 1;
        } else if ("WAP_PAY".equalsIgnoreCase(payMethod)) {
            payChannel = 3;
        } else if ("UNION_PAY".equalsIgnoreCase(payMethod)) {
            //老数据为银联支付的现在都标识为现金
            payChannel = 8;
        } else if ("APPLET_PAY".equalsIgnoreCase(payMethod)) {
            payChannel = 5;
        } else if ("CASH_PAY".equalsIgnoreCase(payMethod)) {
            payChannel = 8;
        } else if ("APP_PAY".equalsIgnoreCase(payMethod)) {
            //线上没有这个类型，没有对应的转换码值
        } else if ("TRANSFER_TO_PUBLIC_ACCOUNT_PAY".equalsIgnoreCase(payMethod)) {
            payChannel = 7;
        }

        return payChannel;
    }

    private Integer toPayStatus(Integer oldPayStatus) {
        Integer payStatus = null;
        if (Integer.valueOf(2).equals(oldPayStatus)) {
            payStatus = 0;
        } else if (Integer.valueOf(1).equals(oldPayStatus)) {
            payStatus = 1;
        } else if (Integer.valueOf(0).equals(oldPayStatus)) {
            payStatus = 2;
        } else if (Integer.valueOf(3).equals(oldPayStatus)) {
            payStatus = 3;
        } else if (Integer.valueOf(7).equals(oldPayStatus)) {
            payStatus = 7;
        } else if (Integer.valueOf(8).equals(oldPayStatus)) {
            payStatus = 8;
        } else if (Integer.valueOf(9).equals(oldPayStatus)) {
            payStatus = 9;
        } else if (Integer.valueOf(6).equals(oldPayStatus)) {
            payStatus = 9;
        }

        return payStatus;
    }

    private Integer toRefundStatus(Integer oldRefundStatus) {
        Integer refundStatus = null;
        if (Integer.valueOf(0).equals(oldRefundStatus)) {
            refundStatus = 2;
        } else if (Integer.valueOf(1).equals(oldRefundStatus)) {
            refundStatus = 1;
        } else if (Integer.valueOf(2).equals(oldRefundStatus)) {
            refundStatus = 0;
        }

        return refundStatus;
    }

    private Integer toCancelType(Integer cancelAction) {
        Integer cancelType = null;
        if (Integer.valueOf(0).equals(cancelAction)) {
            cancelType = 1;
        } else if (Integer.valueOf(1).equals(cancelAction)) {
            cancelType = 2;
        } else if (Integer.valueOf(2).equals(cancelAction)) {
            cancelType = 3;
        }

        return cancelType;
    }

    /**
     * 0    被扫
     * 1    主扫
     * 2    公众号
     * 3    现金
     */
    private Integer toPayTypePay(PaymentAccountEntity.PayType payType) {
        Integer payChannel = null;
        if (payType.ordinal() == 0) {
            payChannel = 2;
        } else if (payType.ordinal() == 1) {
            payChannel = 1;
        } else if (payType.ordinal() == 2) {
            payChannel = 3;
        } else if (payType.ordinal() == 3) {
            payChannel = 8;
        }

        return payChannel;
    }

}
