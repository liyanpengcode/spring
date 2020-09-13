package com.example.javase.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

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
public class ScheduleThreadPoolTests {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Future<Integer> schedule = scheduledExecutorService.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = new Random().nextInt(100);
//                for (int i = 0; i <= 100; i++) {
//                    sum += i;
//                }
                    return sum;
                }
            }, 1, TimeUnit.SECONDS);

            Integer integer = schedule.get();
            System.out.println("Integer=: " + integer);

            futureList.add(schedule);
        }


        scheduledExecutorService.shutdown();


    }
}

