package com.example.javase.juc;

import lombok.SneakyThrows;

/**
 * volatile: 关键字
 * 当多个线程共享数据时，可以保证内存中的数据可见
 * 相比synchronized 是一种较为轻量级的同步策略
 * <p>
 * 说明：
 * 1. volatile 不具备"互斥性"
 * 2. volatile 不能保证变量的"原子性"
 */
public class VolatileTests {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();


        while (true) {
            if (td.isFlag()) {
                System.out.println("-------------------");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(200);
        flag = true;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
