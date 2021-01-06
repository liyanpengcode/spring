package com.example.javase.domain;


/**
 * 位运算符
 * <p>
 * 结论：
 * 1.位运算符操作的都是整数的数据
 * 2.<< : 在一定范围内，每向左移1位，相当于 * 2
 * >> :  在一定范围内，每向右移1位，相当于 / 2
 * 面试题：
 * 最高效方式的计算：2*8？ 2 << 3 或者8 << 1
 */
public class BitTests {

    public static void main(String[] args) {


        int i = 21;

        i = -21;
        System.err.println("i << 2 = " + (i << 2));
        System.err.println("i << 3 = " + (i << 3));
        System.err.println("i << 27 = " + (i << 26));


        int m = 3;
        int n = 5;
        System.err.println("m & n :" + (m & n));
        System.err.println("m | n :" + (m | n));
        System.err.println("m ^ n :" + (m ^ n));

    }
}
