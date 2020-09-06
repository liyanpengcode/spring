package com.example.javase.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized ：生产，消费；唤醒机制
 * <p>
 * Condition :线程通信& Lock :
 */

public class ProductAndConsumerTests {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor pro = new Productor(clerk);

        Consumer csu = new Consumer(clerk);

        new Thread(pro, "生产者A").start();
        new Thread(csu, "消费者B").start();

        new Thread(pro, "生产者C").start();
        new Thread(csu, "消费者D").start();

    }
}

class Clerk {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    private int product = 0;

    public void get() {
        lock.lock();
        try {
            //    public synchronized void get() {
            //为了避免虚假唤醒机制，总是使用while
            while (product >= 1) {
                System.out.println("产品已满");
                try {
                    condition.await();
//                this.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + ++product);
//            this.notifyAll();
            condition.signalAll();

        } finally {
            lock.unlock();
        }
    }


    public void sale() {
//    public synchronized void sale() {
        lock.lock();

        try {
            while (product <= 0) {
                System.out.println("缺货！");
                try {
//                this.wait();
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + --product);
//            this.notifyAll();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {

        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }

    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}