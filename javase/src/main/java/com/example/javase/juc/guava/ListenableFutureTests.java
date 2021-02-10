package com.example.javase.juc.guava;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ListenableFutureTests {

    public static void main(String... args) throws Exception{


        ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        Callable<String> asyncTask = () -> {
            Thread.sleep(1000);
            return "called";
        };

        ListenableFuture<String> listenableFuture = executor.submit(asyncTask);

        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            public void onSuccess(String result) {
                System.out.println(result);
            }

            public void onFailure(Throwable thrown) {
                thrown.printStackTrace();
            }
        },executor);

        Thread.sleep(1000);


        try {
            String result = listenableFuture.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread.sleep(1000);
        executor.shutdown();
    }

}
