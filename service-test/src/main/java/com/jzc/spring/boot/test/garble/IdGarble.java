package com.jzc.spring.boot.test.garble;

public class IdGarble {

    public void generate(int randomDigit, int seqDigit, Long batchSizeOfSeq) {
        if(randomDigit == 0 || batchSizeOfSeq == null) {
            return;
        }
        int randomNum = this.generateRandom(randomDigit);
        String batchSizeOfSeqStr = String.valueOf(batchSizeOfSeq);
        if(seqDigit > batchSizeOfSeqStr.length() ) {
            int size = seqDigit - batchSizeOfSeqStr.length();
            batchSizeOfSeqStr = String.format("%-"+size+"d", batchSizeOfSeqStr);
        }

    }

    public String alternately(Integer randomNum, String batchSizeOfSeqStr) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] randomArr = randomNum.toString().toCharArray();
        char[] batchArr = batchSizeOfSeqStr.toCharArray();
        int count = randomArr.length + batchArr.length;
        int randomCount = 0;
        int batchCount = 0;

        for(int i=0; i<count; i++) {

            if(!this.whetherOdd(i)) {
                if(randomArr.length > randomCount) {
                    stringBuffer.append(randomArr[randomCount]);
                    randomCount++;
                } else {
                    stringBuffer.append(batchArr[batchCount]);
                    batchCount++;
                }
            } else {
                if(batchArr.length > batchCount ) {
                    stringBuffer.append(batchArr[batchCount]);
                    batchCount++;
                } else {
                    stringBuffer.append(randomArr[randomCount]);
                    randomCount++;
                }
            }

        }

        return stringBuffer.toString();
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
