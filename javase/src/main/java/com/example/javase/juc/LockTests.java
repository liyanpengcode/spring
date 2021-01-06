package com.example.javase.juc;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一，用于解决多线程安全问题的方式
 * synchronized：隐式锁
 * 1。同步代码块
 * 2。同步方法
 * <p>
 * JDK 1.5后
 * <p>
 * 3。同步锁 ：lock
 * <p>
 * 注意：是一个显示锁，需要lock()方法上锁，必须通过unlock()方法进行释放锁
 */
public class LockTests {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}


class Ticket implements Runnable {
    private int tick = 100;

    private Lock lock = new ReentrantLock();


    @SneakyThrows
    @Override
    public void run() {
        while (true) {

            //上锁
            lock.lock();

            try {
                if (tick > 0) {
                    Thread.sleep(0b11001000);
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + --tick);
                }
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}