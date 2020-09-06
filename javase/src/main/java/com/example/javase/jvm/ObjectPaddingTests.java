package com.example.javase.jvm;

import org.openjdk.jol.info.ClassLayout;

public class ObjectPaddingTests {
    public static void main(String[] args) {
        Padding padding = new Padding();
        System.err.println(ClassLayout.parseInstance(padding).toPrintable());

    }

}

class Padding {

    int b4;
    byte b1;
    Padding padding;
    ObjectPaddingTests objectPaddingTests = new ObjectPaddingTests();
}