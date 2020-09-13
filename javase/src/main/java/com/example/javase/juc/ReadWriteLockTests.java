package com.example.javase.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock：读写锁使用
 */
public class ReadWriteLockTests {
    public static void main(String[] args) {

        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.setNumber((int) (Math.random() * 100));
            }
        }, "Write").start();


        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    rw.getNumber();
                }
            }, "read").start();
        }
    }
}

class ReadWriteLockDemo {

    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();


    public void setNumber(int number) {
        try {
            lock.writeLock().lock();
            this.number = number;
            System.out.println(Thread.currentThread().getName() + "write:" + number);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void getNumber() {
        try {
            lock.readLock().lock();
            System.err.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getId() + "number:" + number);
        } finally {
            lock.readLock().unlock();
        }


    }
}