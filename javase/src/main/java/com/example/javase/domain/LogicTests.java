package com.example.javase.domain;

/**
 * 逻辑运算符：
 * &，&&，|,||,!,^
 * 说明：逻辑运算符操作都是boolean
 */
public class LogicTests {

    public static void main(String[] args) {

        /**
         * 区分& 和&&
         * 相同点是：
         * 1.运算逻辑结果相同
         * 2.当符号左边是true是，二者都会执行符号右边的运算
         * 不同点是：
         *  当符号左边等于false时，&会继续执行符号右边的运算，&&则不执行符号右边的运算
         *  开发中建议使用：&&
         *
         */


        boolean b1 = true;
        b1 = false;
        int num1 = 10;
        if (b1 & (num1++ > 0)) {
            System.out.println("我在公司");
        } else {
            System.out.println("我在家");
        }
        System.out.println("num1=" + num1);

        boolean b2 = true;
        b2 = false;
        int num2 = 10;
        if (b2 && (num2++ > 0)) {
            System.out.println("我在公司");
        } else {
            System.out.println("我在家");
        }
        System.out.println("num2=" + num2);

        /**
         * 区分| 和||
         * 相同点是：
         * 1.运算逻辑结果相同
         * 2.当符号左边是false是，二者都会执行符号右边的运算
         * 不同点是：
         *  当符号左边等于true时，|会继续执行符号右边的运算，||则不执行符号右边的运算
         *  开发中建议使用：||
         *
         */
        boolean b3 = false;
        b3 = true;
        int num3 = 10;
        if (b3 | (num3++ > 0)) {

            System.out.println("单身");
        } else {
            System.out.println("学习");
        }

        System.out.println("num3=" + num3);

        boolean b4 = false;
        b4 = true;
        int num4 = 10;
        if (b4 || (num4++ > 0)) {

            System.out.println("单身");
        } else {
            System.out.println("学习");
        }

        System.out.println("num4=" + num4);

    }

}
