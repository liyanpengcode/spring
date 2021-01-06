package com.example.javase.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: 闭锁，
 * 在完成某些运算时，只有当其他所有线程执行全部完成，当前线程才能继续执行
 */

public class CountDownLatchTests {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);


        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(latchDemo).start();
        }

        //TODO 控制线程执行顺序
        try {
            latch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("多线程执行耗时时间为：" + (start - end));
    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * 取模打印偶数
     */
    @Override
    public void run() {

        //避免出现线程安全问题
        synchronized (this) {

            try {
                for (int i = 0; i < 10000; i++) {
                    if (i % 2 == 0) {
                        System.err.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }

        }
    }
}