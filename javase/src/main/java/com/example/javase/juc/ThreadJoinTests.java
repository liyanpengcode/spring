package com.example.javase.juc;

@Deprecated
public class ThreadJoinTests {
    public static void main(String[] args) {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread1.start();
    }
}
