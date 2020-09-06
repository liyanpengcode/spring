package com.example.javase.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList:
 * 写入并复制
 * 注意：添加操作多少，效率低，每次添加都会复制，开销大，
 * 并发迭代操作多时可以选择
 */
class CopyOnWriteArrayListTests {
    public static void main(String[] args) {

        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable {

//    private static List<String> list= Collections.synchronizedList(new ArrayList<String>());

    /*TODO 解决多线程同时写入，读取的问题*/
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

    static {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }

    @Override
    public void run() {

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            list.add("AA");
        }
    }
}