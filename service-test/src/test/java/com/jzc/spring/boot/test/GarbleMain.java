package com.jzc.spring.boot.test;

import com.jzc.spring.boot.test.garble.EcodeGarble;
import org.junit.Test;

public class GarbleMain {

    @Test
    public void garbleTest() {

        EcodeGarble ecodeGarble = new EcodeGarble();

        System.out.println(ecodeGarble.generateCode("RRRR123456789abcdef", 123456789012l));

        System.out.println(ecodeGarble.generateCode("RRRR123456789", 123456789l));

        System.out.println(ecodeGarble.generateCode("RRRR12345ab6789", 12345678901l));

        System.out.println(ecodeGarble.generateCode("RRRR12345", 12345l));

        System.out.println(ecodeGarble.generateCode("RRRR123456789abc", 123456789012l));

        System.out.println(ecodeGarble.generateCode("RRRR123456789abc", 123456789012l));

    }

}
