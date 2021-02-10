package com.example.javase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * learn FutureTask class
 */
public class FutureTaskTests {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            return doSomethingA();
        });
        Thread thread = new Thread(futureTask, "threadB");
        thread.start();

        String doSomethingB = doSomethingB();

        String future = futureTask.get();

        System.out.println("future = " + future + "\ndoSomethingB=" + doSomethingB);
        System.err.println(System.currentTimeMillis() - start);

    }

    public static String doSomethingA() {

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("execute doSomethingA ");

        return "doSomethingA";
    }

    public static String doSomethingB() {

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("execute doSomethingB ");

        return "doSomethingB";
    }
}
