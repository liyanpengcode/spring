package com.example.javase.juc.atomic;

/**
 * 模拟CAS算法
 */
public class CompareAndSwapTests {

    public static void main(String[] args) {
        CompareAndSwap swap = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {

                @Override
                public void run() {

                    int expectedValue = swap.getValue();

                    boolean flag = swap.compareAndSet(expectedValue, (int) Math.random() * 101);
                    System.err.println(flag);
                }
            }).start();
        }

    }
}

class CompareAndSwap {

    private int value;

    /**
     * 获取内存值
     *
     * @return
     */
    public synchronized int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            this.value = newValue;

        }
        return oldValue;
    }

    /**
     * 检查是否和预估值相等
     *
     * @param expectedValue
     * @param newValue
     * @return
     */
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {

        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
