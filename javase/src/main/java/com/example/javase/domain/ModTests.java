package com.example.javase.domain;


/**
 * 取模练习
 */
public class ModTests {

    public static void main(String[] args) {
        int num = 236;

        int bai = num / 100;
        int shi = num % 100 / 10;
        int ge = num % 10;
        System.out.println("bai = " + bai);
        System.out.println("shi = " + shi);
        System.out.println("ge = " + ge);

        int a1 = 10;
        /**
         * 先自增，
         * 后赋值
         */
        int b1 = ++a1;


        int a2 = 10;
        /**
         * 先赋值，
         * 后自增
         * */
        int b2 = a2++;

        System.err.println("a1 = " + a1 + "\n" + "a2=" + a2);
        System.err.println("b1 = " + b1 + "\n" + "b2=" + b2);
    }
}
