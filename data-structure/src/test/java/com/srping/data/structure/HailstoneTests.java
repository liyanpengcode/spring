package com.srping.data.structure;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.sql.DriverManager.println;

@SpringBootTest
/**
 * 有穷性
 */
public class HailstoneTests {

    @Test
    void contextLoads() {

        hailstone(7);

    }


    private void hailstone(int n) {
        int n2 = n;
        int j = 1;

        while (n != 1) {
            n2 = n;
            if (n %2 ==0) {
                n2 /= 2;
                System.out.println (n + " is even, so I take half: " + n2);
                n = n2;
            } else {
                n2 = (3*n + 1);
                System.out.println(n + " is odd, so I make 3n+1: " + n2);
                n = n2;
            }
            j++;
        }
        System.out.println ("This process took " + j + " steps to reach 1.");

    }
}
