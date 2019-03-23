package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.boot.test.garble.IdGarble;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainProcessorTest {

    @Test
    public void createGuid() {
        System.out.println(UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void hashTest() {
        System.out.println( "123".hashCode() );
        System.out.println( Integer.valueOf(123).hashCode() );
        System.out.println( Long.valueOf(123).hashCode() );
        System.out.println( Boolean.valueOf(true).hashCode() );
        System.out.println( BigDecimal.valueOf(123).hashCode() );
    }

    @Test
    public void randomNum() {
        int randomDigit = 4;
        int length = 1;
        for(int i=1; i<randomDigit; i++) {
            length = length * 10;
        }
        System.out.println((int)((Math.random() * 9 + 1) * length));
    }

    @Test
    public void mathRandom() {
        System.out.println(Math.ceil ( (double) 1/2 ));
        System.out.println(Integer.valueOf(1) );
        System.out.println((int) ((Math.random() * 9 + 1) * 1)  );
    }

    @Test
    public void run() {
        IdGarble id = new IdGarble();
//        System.out.println(id.alternately(id.generateRandom(4), "103003" ) );
//        id.modelCheck("R32R1R564R");
//        System.out.println(id.modelRandom("RRRR126345", id.generateRandom(4), "123456"));
        System.out.println("R32R1R564R".indexOf("1"));
    }

    @Test
    public void max() {
        int max = 1;
        for(int i=0; i<3; i++) {
            max = max * 10;
        }
        System.out.println(max-1);
    }

    @Test
    public void randomMaxNum() {
        int length = 1;
        for(int i=0; i<4; i++) {
            length = length * 10;
        }

        System.out.println(new Random().nextInt(length - 1));
    }

    @Test
    public void randomDiy() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        List<Integer> list6 = new ArrayList<>();
        List<Integer> list7 = new ArrayList<>();
        List<Integer> list8 = new ArrayList<>();
        List<Integer> list9 = new ArrayList<>();
        for(int i=0; i<10000; i++) {
            int i1 = arr[random.nextInt(9)];
            if(i1 == 1) {
                list1.add(i1);
            } else if(i1 == 2) {
                list2.add(i1);
            } else if(i1 == 3) {
                list3.add(i1);
            } else if(i1 == 4) {
                list4.add(i1);
            } else if(i1 == 5) {
                list5.add(i1);
            } else if(i1 == 6) {
                list6.add(i1);
            } else if(i1 == 7) {
                list7.add(i1);
            } else if(i1 == 8) {
                list8.add(i1);
            } else if(i1 == 9) {
                list9.add(i1);
            }
        }

        System.out.println("1 size: " + list1.size());
        System.out.println("2 size: " + list2.size());
        System.out.println("3 size: " + list3.size());
        System.out.println("4 size: " + list4.size());
        System.out.println("5 size: " + list5.size());
        System.out.println("6 size: " + list6.size());
        System.out.println("7 size: " + list7.size());
        System.out.println("8 size: " + list8.size());
        System.out.println("9 size: " + list9.size());
    }

    @Test
    public void randomDiy2() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        List<Integer> list6 = new ArrayList<>();
        List<Integer> list7 = new ArrayList<>();
        List<Integer> list8 = new ArrayList<>();
        List<Integer> list9 = new ArrayList<>();
        for(int i=0; i<10000; i++) {
            int i1 = (int) ((Math.random() * 9 + 1) * 1);
            if(i1 == 1) {
                list1.add(i1);
            } else if(i1 == 2) {
                list2.add(i1);
            } else if(i1 == 3) {
                list3.add(i1);
            } else if(i1 == 4) {
                list4.add(i1);
            } else if(i1 == 5) {
                list5.add(i1);
            } else if(i1 == 6) {
                list6.add(i1);
            } else if(i1 == 7) {
                list7.add(i1);
            } else if(i1 == 8) {
                list8.add(i1);
            } else if(i1 == 9) {
                list9.add(i1);
            }
        }

        System.out.println("1 size: " + list1.size());
        System.out.println("2 size: " + list2.size());
        System.out.println("3 size: " + list3.size());
        System.out.println("4 size: " + list4.size());
        System.out.println("5 size: " + list5.size());
        System.out.println("6 size: " + list6.size());
        System.out.println("7 size: " + list7.size());
        System.out.println("8 size: " + list8.size());
        System.out.println("9 size: " + list9.size());

    }

    @Test
    public void whetherOddTest() {
        System.out.println(new IdGarble().whetherOdd(2));
    }

    Map<String, String> letter = new HashMap<String, String>(){{
        put("A", "10");put("B", "11");put("C", "12");put("D", "13");put("E", "14");put("F", "15");put("G", "16");put("H", "17");put("I", "18");
    }};

    @Test
    public void sort() {


    }

    @Test
    public void bigDecmailNull() {
        System.out.println( BigDecimal.ZERO.equals(null) );
    }

    @Test
    public void integralTest() {
        System.out.println( new BigDecimal("255").setScale(0, BigDecimal.ROUND_HALF_UP) );
        System.out.println( new BigDecimal("255").setScale(0, BigDecimal.ROUND_HALF_UP).intValue() );
    }

    @Test
    public void integerNull() {
        System.out.println( Integer.valueOf(0) == null );
    }

    @Test
    public void integerEwq() {
        System.out.println( 130 == Integer.valueOf(130) );
    }

    @Test
    public void listsub() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(JSON.toJSONString(list.subList(1, 4)));
    }

    @Test
    public void getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        System.out.println( sdf.format(calendar.getTime()) );

        calendar.add(Calendar.YEAR, -1);
        System.out.println( sdf.format(calendar.getTime()) );
    }

    @Test
    public void mathFloor() {
        System.out.println(501/500);
        System.out.println(Math.floor(23/500));
    }

    @Test
    public void bigdecimalTest() {
        BigDecimal price = new BigDecimal("1.3");
        BigDecimal amount = new BigDecimal(100);

        BigDecimal down = amount.divide(price, 0, BigDecimal.ROUND_DOWN);
        System.out.println(down);

        BigDecimal multiply = down.multiply(price).setScale(0, BigDecimal.ROUND_DOWN);
        System.out.println(multiply);

    }

    @Test
    public void steamMap() {

        List<Map<String, Integer>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        list.add(map);

        OptionalInt first = list.stream().mapToInt(m -> m.get("1")).findFirst();

        System.out.println(first.orElse(0));

    }

    @Test
    public void discountTest() {

        BigDecimal discount = new BigDecimal(7.8);

        Integer ticket = 1333;

        BigDecimal bigDecimal = discount.multiply(BigDecimal.valueOf(1333)).setScale(0, BigDecimal.ROUND_UP);

        System.out.println( bigDecimal );

    }

    @Test
    public void foreach() {
        List<String> list = new ArrayList<String>(){{
            add("1");
            add("1");
            add("2");
        }};

        List<String> collect = list.stream().map(s -> {

            return s;
        }).distinct().collect(Collectors.toList());

        System.out.println(JSON.toJSON(collect));

    }

    @Test
    public void bigDecimalCompare () {
        BigDecimal amount = new BigDecimal(-1);
        System.out.println( BigDecimal.ZERO.compareTo(amount));
        System.out.println(BigDecimal.ZERO.compareTo(amount) > -1);

    }

    @Test
    public void bigDeciamlQUMO () {
        BigDecimal price = new BigDecimal("0.01");
        BigDecimal amount = new BigDecimal(100);


        System.out.println(amount.divide(price, 0, BigDecimal.ROUND_DOWN));

        System.out.println(100/0.01);

        BigDecimal[] bigDecimals = amount.divideAndRemainder(price);

        System.out.println(bigDecimals.length);
        System.out.println(bigDecimals[0]);
        System.out.println(bigDecimals[1]);

    }

    @Test
    public void bigdecimalXS () {
        BigDecimal bd = new BigDecimal("1.1");

        System.out.print(BigDecimal.valueOf(bd.intValue()).compareTo(bd) == 0);

    }


}
