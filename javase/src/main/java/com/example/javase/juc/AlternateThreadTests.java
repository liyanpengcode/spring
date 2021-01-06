package com.example.javase.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition:实现线程交替打印
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 */
public class AlternateThreadTests {

    public static void main(String[] args) {

        AlternateDemo ad = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopA(i);
                }
            }
        }, "A").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopB(i);
                }
            }
        }, "B").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopC(i);
                }
            }
        }, "C").start();
    }
}

class AlternateDemo {

    private int number = 1;

    private Lock lock = new ReentrantLock();

    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public void loopA(int totalLoop) {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            // 打印
            for (int i = 0; i < 1; i++) {

                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //唤醒
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB(int totalLoop) {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            // 打印
            for (int i = 0; i < 1; i++) {

                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //唤醒
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int totalLoop) {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            // 打印
            for (int i = 0; i < 1; i++) {

                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
            }

            //唤醒
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}





