package com.example.javase.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * JDK 6 run
 * VM Args: XX:Permsize=6m -XX:Maxpermsize=6M
 * <p>
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class RuntimeConstantpoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short s = 0;
        while (true) {
            set.add(String.valueOf(s++).intern());
        }
    }
}
