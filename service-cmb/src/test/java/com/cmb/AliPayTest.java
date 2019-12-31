package com.cmb;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AliPayTest {

    Logger log = LoggerFactory.getLogger(AliPayTest.class);

    @Test
    public void refund() {

        String txId = "6741700874793582169";
        String amount = "209.00";
        String remark = " 购买错误，手动退款";
        String refundTxId = "67417008747935821691";

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();

        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        //外部订单号
        model.setOutTradeNo(txId);
        //退款金额
        model.setRefundAmount(amount);
        //退还原因
        model.setRefundReason(remark);
        //退款订单id
        model.setOutRequestNo(refundTxId);

        request.setBizModel(model);
        log.info("AlipayTradeRefundRequest {}", JSONObject.toJSONString(request));

        try {
            AlipayTradeRefundResponse response = build().execute(request);
            log.info("AlipayTradeRefundResponse {}", JSONObject.toJSONString(response));
            if (!response.isSuccess()) {
                log.error(response.getSubMsg());
            }
        } catch (AlipayApiException e) {
            log.error("call alipay error", e);
        }

    }





    private static String serverUrl = "https://openapi.alipay.com/gateway.do";

    private static String format = "json";

    private static String charset = "UTF-8";

    public static AlipayClient build() {

        String appId = "2017060707437415";
        String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKeNVlQC6ZI6gaqzBvYsENAyR72ruPIdy+alciRJlX8tPV2sdeB1OkbD5XIF3915ML8UKLoTN1tQ9RtGvxowAqJyHUnx1BF2p8joW2SDzMcD77ACOrVhxDf2Uepbx3Vw9cB5cWySUMp7MzbDJp1dr32Owtfuv98PEb1N5F7s0Q6JAgMBAAECgYEAjjNpEhIKs91N0Vbx0Jnjhx81PedxJqNdOxotPljpNS9rBoZo4J/9XrPBlr0fmvLRCUqNqibG84xJCeZIKGyYvnAQWxKUnEMIe2XuzdYpO2tUVnU80oN5NUvCR9FiGhqmR9t5uojyuVVqmjjSSUGPj1s8Hw0L9tcPhz8imxTXFQECQQDVbbP1JP2Cih+KkrcI72NO6054XCbcFi6uGmW3tLaNvBf1peNMdZD9Ism/NvJ8hOQCnJTSWgjHm6j4fiqS/NChAkEAyPkMCMWP8IEHfeP7MKXdrD7nXXUyFlXl3+bBCGtDycaa88AFQQbsvTweqeqo12CoTxIwYdwehDkItYLNzaus6QJBAMwzBL2kYYS3AEyF6Od8mqhUTCSuDmP+OTVMfkuQdCURdF8ME3gA9/KpiRsQyFpIjxrMkzra95F7JeRyWet+RWECQQDIra7vn18At8bkVV9BD48PbOyYrOrr1LAq6H9+SaWx+QhHN0nHygNhXoP8BZ69Gf5WnoIDZcpvG4hvvwKESdXpAkB8wxUSlc7HHDifF7oQFZWj9XOzBTnCGXrVsyjF49T516lYh26169i+m5WhHJTEgjwgncFu6advGaJU4wMslbAS";
        String alipayPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
        String signType = "RSA";

        return new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
    }

}
