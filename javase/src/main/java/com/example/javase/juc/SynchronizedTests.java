package com.example.javase.juc;

import lombok.SneakyThrows;

/**
 * 1. 两个普通同步方法，两个线程，标准打印？// one，two
 * 2. 新增Thread.sleep(),打印，//one ，two
 * 3. 新增普通方法getThree(),打印？// three ，one， two
 * 4. 两个普通同步方法，两个Number 对象打印？ //two，one
 * 5. 修改getOne()为静态同步方法，打印？ // two ，one
 * 6. 修改两个方法均为静态同步方法， 一个Number 对象，打印？ // one， two
 * 7. 一个静态同步方法，一个非静态同步方法，两个Number 对象？ // two，one
 * 8. 两个静态同步方法，两个Number对象？ //one ，two
 * <p>
 * <p>
 * 总结说明：
 * 线程八锁的关键
 * 1. 非静态方法的锁默认为this，静态方法的锁为：对应的Class 实例
 * 2. 某一时刻内，只能又一个线程持有锁，无论几个方法。
 */
public class SynchronizedTests {

    public static void main(String[] args) {

        Number number = new Number();
        Number number2 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number2.getTwo();
//                number.getTwo();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                number.getThree();
//            }
//        }).start();
    }
}

class Number {


    @SneakyThrows
    //锁为：Number.class
    public static synchronized void getOne() {

        Thread.sleep(3000);
        System.out.println("one");
    }

    //锁为：this
    public synchronized void getTwo() {
        System.out.println("two ");
    }

    public void getThree() {
        System.out.println("three ");
    }
}
