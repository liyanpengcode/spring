package com.example.javase.entity;

import lombok.Data;


public class InstanceofTests {

    public static void main(String[] args) {

        SuperParent sp = null;

        Parent parent = null;

        boolean result;

        result = sp instanceof SuperParent;
        /**null 与instanceof 任何类型比较都是false */
        System.err.println("result=" + result);

        parent = new Child();
        result = parent instanceof SuperParent;
        /** parent 是 Parent 类的实例对象 Parent 实现类SuperParent 所以属于一个继承树 */
        System.err.println("result=" + result);


        parent = new Child();
        result = parent instanceof Child;
        /** parent 是 Parent 类的引用指向 Child  所以属于一个继承树 */
        System.err.println("result=" + result);

        sp = new Parent();
        result = sp instanceof Parent;

        /**true sp是接口 SuperParent 的实例对象, 引用指向子类Parent，类Parent实现了接口SuperParent，所以属于同一个继承树分支*/
        System.err.println("result=" + result);

    }

}


interface SuperParent {

}

@Data
class Parent implements SuperParent {

    private String flag;
}

@Data
class Child extends Parent {

    private String username;
    private String password;


}