package com.example.javase.juc.atomic;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. i++ 的原子性问题，i++ 的操作实际分为三个步骤
 * 读-改-写
 * <p>
 * 2. JDK 5 后  java.util.concurrent.atomic 包下提供了常用的原子变量
 * <p>
 * 1. Volatile 保证内存可见性
 * 2. CAS（Compare-And-Swap）算法保证数据的原子性
 * CAS 算法是硬件对于并发操作共享数据的支持
 * JVM 也对CAS 算法支持
 * 内存位置V（它的值是我们想要去更新的）
 * 预期原值A（上一次从内存中读取的值）
 * 新值B（应该写入的新值）
 * 当且仅当V==A时，V=B，否则，不做任何操作
 * <p>
 * CAS缺点：
 * 1.ABA问题:
 * 如果一个值原来是A，变成了B，又变成了A
 * 从Java1.5开始JDK的atomic包里提供了一个类AtomicStampedReference来解决ABA问题。这个类的compareAndSet方法
 * 原理：检查当前引用是否等于预期引用，并且当前标志是否等于预期标志，如果全部相等，则赋值
 * <p>
 * 2.循环时间长开销大
 * 3.只能保证一个共享变量的原子操作
 */
public class AtomicDemoTests {

    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for (int i = 0; i < 10; i++) {

            new Thread(ad).start();

        }

    }


}

class AtomicDemo implements Runnable {

    //线程问题
//    private  volatile  int serialNumber=0;

    private AtomicInteger ai = new AtomicInteger();

    @SneakyThrows
    @Override
    public void run() {

        Thread.sleep(200);
        System.err.println(getSerialNumber());
    }

    public int getSerialNumber() {
//        return serialNumber++;
        return ai.getAndIncrement();
    }
}