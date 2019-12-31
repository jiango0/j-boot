package com.jzc.spring.boot.test;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.commons.collections4.list.TreeList;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class MathTest {

    @Test
    public void main() {

        Map<Integer, Integer> randomMap = new HashMap<>();

        Random random = new Random();
        for (int i=0; i<1000; i++) {
            int i1 = random.nextInt(4) + 1;

            if (randomMap.containsKey(i1)) {
                randomMap.put(i1, randomMap.get(i1) + 1);
            } else {
                randomMap.put(i1, 1);
            }
        }

        System.out.println(randomMap);
    }

    @Test
    public void main3() {

        BigDecimal am = new BigDecimal(182);

        BigDecimal[] bigDecimals = am.divideAndRemainder(BigDecimal.valueOf(16));

        for (BigDecimal bc : bigDecimals) {
            System.out.println(bc);
        }

    }

    @Test
    public void main4() {

        BigDecimal bm = new BigDecimal("225435.69");

        System.out.println(bm.divide(BigDecimal.valueOf(85), 0, BigDecimal.ROUND_UP));
        System.out.println(bm.divide(BigDecimal.valueOf(85), 0, BigDecimal.ROUND_HALF_UP));

    }

    @Test
    public void main2() {

        List<Integer> coupons = new ArrayList<Integer>(){{
            add(3);
            add(5);
            add(10);
        }};

        Integer totalCoins = 3100;
        Integer totalCardNum = 1000;

        //1530  2100  700

        Map<Integer, Integer> integerIntegerMap = couponDeal(coupons, totalCoins, totalCardNum);

        System.out.println(integerIntegerMap);

        for (Map.Entry<Integer, Integer> entry : integerIntegerMap.entrySet()) {
            System.out.println("key :" + entry.getKey() + " value : " + entry.getKey() * entry.getValue());
        }

    }

    public static Map<Integer, Integer>  couponDeal(List<Integer> coupons, Integer totalCoins, Integer totalCardNum) {
        Map<Integer,Integer> couponsWithNums = new HashMap<>();
        TreeList<Integer> list = new TreeList<>(coupons);
        IntSummaryStatistics intSummaryStatistics = coupons.stream().mapToInt(Integer::intValue).summaryStatistics();
        Integer sum = Long.valueOf(intSummaryStatistics.getSum()).intValue();
        List<Double> doubleList = new TreeList<>();
        for (Integer coupon : list) {
            BigDecimal result = (new BigDecimal(coupon)).divide(new BigDecimal(sum),2, RoundingMode.HALF_UP);
            doubleList.add(result.doubleValue());
        }
        int restCardNum = totalCardNum;
        int restCoinNum = totalCoins;
        int sumCardNum = 0;
        int sumCoinNum = 0;
        int size = list.size();
        for(int i=0;i<=size-1;i++) {
            int bound =  new BigDecimal(totalCardNum).multiply(new BigDecimal(doubleList.get(i))).intValue();
            int coupon = list.get(i);
            int cardNum = bound * (size)/(i+1);
            int coinNum = new BigDecimal(coupon).multiply(new BigDecimal(cardNum)).intValue();
            couponsWithNums.put(coupon, cardNum);
            restCardNum -= cardNum;
            restCoinNum -= coinNum;
            System.out.printf("coinType:%s cardNum:%s coinNum:%s restCardNum:%s restCoinNum:%s\n",coupon,cardNum,coinNum,restCardNum,restCoinNum);
            if(i==list.size()-1) {
                //剩余币数量不足,需要补齐
                restCardNum = totalCardNum-sumCardNum;
                restCoinNum = totalCoins-sumCoinNum;
                int restno = restCoinNum/coupon;
                //如果剩余的卡数多于
                if(restCardNum>restno) {
                    couponsWithNums.put(coupon, restCardNum);
                }else{
                    couponsWithNums.put(coupon, restno);

                }
            }
            sumCardNum += cardNum;
            sumCoinNum += coinNum;
        }

//        System.out.printf("%s",new Random().nextInt(150));
        return couponsWithNums;
    }

}
