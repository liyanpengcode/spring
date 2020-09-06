package com.example.javase.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 一，创建线程方式三：实现Callable接口，相对于实现Runnable 接口的方式，方法可以有返回值，并且可以抛出异常
 * <p>
 * 二，执行Callable 方式，需要FutureTask 实现类的这次，用于接收运算结果，FutureTask是Future接口的实现类
 */
public class CallableTests {

    public static void main(String[] args) {

        ThreadCallableDemo td = new ThreadCallableDemo();


        //1.执行Calllable 方式，需要FutureTask 实现类的支持，用于接收运算结果

        FutureTask<Integer> futureTask = new FutureTask<>(td);
        new Thread(futureTask).start();


        System.out.println("============");

        // 2. 接收程序运算后的结果
        try {
            // FutureTask 可用于，闭锁
            Integer sum = futureTask.get();
            System.err.println("sum=:" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class ThreadCallableDemo implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
            System.out.println("--------------");
        }
        return sum;
    }
}