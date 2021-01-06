package com.example.javase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VariableTests {


    @Test
    public void method() {


        byte var = (byte) 128;

        byte var2 = (byte) -129;

        System.out.println("var:" + var);
        System.out.println("var2:" + var2);


        int a = 1;
        int b = 13;

        a = a + b;

        long l = 123213;

        long l1 = 21332423235234123L;

        System.err.println(a);

        System.out.println(l);

        System.out.println(l1);

    }
}
