package com.jzc.spring.boot.test.garble;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class IdGarble {

    public String alternately(Integer randomNum, String batchSizeOfSeqStr) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] randomArr = randomNum.toString().toCharArray();
        char[] batchArr = batchSizeOfSeqStr.toCharArray();
        int count = randomArr.length + batchArr.length;
        int randomCount = 0;
        int batchCount = 0;
        int rightCount = batchArr.length;

        for(int i=0; i<count; i++) {
            boolean isRandom;

            if(this.whetherOdd(i)) {
                isRandom = !(rightCount > 0);
            } else {
                isRandom = randomArr.length > randomCount;
            }

            if(isRandom) {
                stringBuffer.append(randomArr[randomCount]);
                randomCount++;
            } else {
                rightCount--;
                stringBuffer.append(batchArr[rightCount]);
            }

        }

        return stringBuffer.toString();
    }

    public String modelRandom(String model, Integer randomNum, String batchSizeOfSeqStr) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] randomArr = randomNum.toString().toCharArray();
        char[] batchArr = batchSizeOfSeqStr.toCharArray();
        char[] chars = model.toUpperCase().toCharArray();
        if((randomArr.length + batchArr.length) != chars.length) {
            System.out.println("报错");
        }
        int randomCount = 0;
        for(int i=0; i<chars.length; i++) {
            if("R".equalsIgnoreCase(String.valueOf(chars[i]))) {
                stringBuffer.append(randomArr[randomCount]);
                randomCount++;
            } else {
                Integer index = Integer.valueOf(String.valueOf(chars[i]));
                if(index <=  batchArr.length) {
                    stringBuffer.append(batchArr[index-1]);
                }

            }
        }

        return stringBuffer.toString();
    }

    public void modelCheck(String model) {
        int r = 0;
        char[] chars = model.toUpperCase().toCharArray();
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<chars.length; i++) {
            if("R".equalsIgnoreCase(String.valueOf(chars[i]))) {
                r++;
            } else {
                if(Pattern.matches("[0-9]{1}", String.valueOf(chars[i]))) {
                    nums.add(Integer.valueOf(String.valueOf(chars[i])));
                }
            }
        }

        System.out.println(r);
        System.out.println(nums.size());

        Integer temp;
        for(int i=0; i<nums.size(); i++) {
            for(int k=i+1; k<nums.size(); k++) {
                if(nums.get(i) > nums.get(k) ) {
                    temp = nums.get(i);
                    nums.set(i, nums.get(k));
                    nums.set(k, temp);
                }
            }
        }
        System.out.println(nums.toString());

        boolean isPass = true;
        for(int i=0; i<nums.size() -1; i++) {
            if(i==0 && nums.get(i) != 1) {
                isPass = false;
                break;
            }
            if((nums.get(i) + 1) != nums.get(i+1) ) {
                isPass = false;
                break;
            }
        }
        System.out.println(isPass);

    }

    public int generateRandom(int randomDigit) {
        int length = 1;
        for(int i=1; i<randomDigit; i++) {
            length = length * 10;
        }
        return (int)((Math.random() * 9 + 1) * length);
    }

    /**
     * 判断是否奇数
     * @param   count
     * @return
     * */
    public boolean whetherOdd(int count) {
        return (count & 1) == 1 ? true : false;
    }

}
