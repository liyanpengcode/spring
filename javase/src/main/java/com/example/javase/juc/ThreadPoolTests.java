package com.example.javase.juc;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 一，线程池：
 * 提供了一个线程队列，队列中保存着所有等待状态的线程，避免了创建与消费的开销，提高了响应速度。
 * 二，线程池的体系结构
 * java.util.concurrent
 * Interface Executor
 * All Known Subinterfaces:
 * ExecutorService, ScheduledExecutorService
 * All Known Implementing Classes:
 * AbstractExecutorService, ForkJoinPool, ScheduledThreadPoolExecutor, ThreadPoolExecutor
 */
public class ThreadPoolTests {
    @SneakyThrows
    public static void main(String[] args) {
        ThreadPoolDemo tpd = new ThreadPoolDemo();

        //1.创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

//        for (int i = 0; i < 5; i++) {
//            //2.为线程池中分配任务
//            pool.submit(tpd);
//
//        }

        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                        System.err.println(Thread.currentThread().getName());
                    }
                    return sum;
                }
            });
            System.err.println(" future=: " + future.get());
            futureList.add(future);
        }


        //关闭线程池
        pool.shutdown();

        System.out.println("args = " + "=====");

    }
}

class ThreadPoolDemo implements Runnable {

    private int number = 0;

    @Override
    public void run() {
        while (number <= 100) {
            System.out.println(Thread.currentThread().getName() + ": " + number++);
        }

    }
}