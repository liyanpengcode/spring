package com.example.javase.domain;

/**
 * 比较运算符：
 * ==,!=,>,<,>=,<=,instanceof
 * <p>
 * 结论：
 * 1.比较运算结果是boolean类型 true/false
 * 2.区分：== 和=
 */
public class CompareTests {
    public static void main(String[] args) {


        int a = 10;
        int b = 20;
        /*比较运算*/
        System.out.println(a == b);
        /*赋值操作*/
        System.out.println(a = b);

        boolean b1 = true;
        boolean b2 = false;

        /*比较运算*/
        System.out.println(b1 == b2);
        /*赋值操作*/
        System.out.println(b1 = b2);
    }
}
