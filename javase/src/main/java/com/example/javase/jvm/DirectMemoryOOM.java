package com.example.javase.jvm;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 直接内存:
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * <p>
 * 使用unsafe分配本机内存,
 * JDK 10 开放部分功能：Unsafe
 * 真正申请分配内存的方法是Unsafe::allocateMemory()，直接系统用的os::malloc一个包装，并未关心VM内存限制
 * <p>
 * ByteBuffer.allocateDirect()
 * 在会在调用这个方法之前，调用Bits.reserveMemory()，这个方法将检查进程的内存占用情况并抛出异常。
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        List<ByteBuffer> list = new ArrayList<>();
        while (true) {
//            unsafe.allocateMemory(_1MB);
            list.add(ByteBuffer.allocateDirect(_1MB));
        }

    }
}
