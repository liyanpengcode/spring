package com.example.javase.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HeapOOMTests {

    public static void main(String[] args) {
        List<HeapOOMTests> oomTestsList = new ArrayList<>();
        while (true) {
            oomTestsList.add(new HeapOOMTests());
        }
    }
}
