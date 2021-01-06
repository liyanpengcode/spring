package com.srping.data.structure.entity;


import java.util.Arrays;


public class Demo {

    public static void main(String[] args) {

        String string = "Str";

        int age = 12;

        char c = 'A';
        char c1 = 97;
        char c2 = '5';
        char c3 = 5;
        char c4 = '我';

        System.err.println("char = " + (c));
        System.err.println("c1 = " + (c1));
        System.err.println("c2 = " + (c2));
        System.err.println("c3 = " + (c3));
        System.err.println("c4 = " + (c4));

        Parson parson = new Parson();


        ClassLoader parent = parson.getClass().getClassLoader().getParent().getParent();


        System.out.println("args = " + Arrays.deepToString(args));

        /*二进制*/
        int num1 = 0b110;
        /*十进制*/
        int num2 = 110;
        /*八进制*/
        int num3 = 0127;
        /*十六进制*/
        int num4 = 0x110A;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);

    }


    static
    class Parson {
        private String name;

        private int age;

        private String address;

        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


    }


}
