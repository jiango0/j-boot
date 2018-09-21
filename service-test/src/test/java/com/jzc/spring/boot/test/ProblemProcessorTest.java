package com.jzc.spring.boot.test;

import com.jzc.spring.boot.test.algorithm.Problem01;
import com.jzc.spring.boot.test.algorithm.Problem02;
import org.junit.Test;

public class ProblemProcessorTest {

    @Test
    public void problem01() {
        Problem01 p = new Problem01();
        p.problem();
    }

    /**
     * 这个有点扯淡 , 哈哈哈
     * */
    @Test
    public void problem02() {
        Problem02 p = new Problem02();
        p.problem();
    }

}
