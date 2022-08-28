package com.kuaishou.newInterface;

/**
 * jdk1.8接口增强之——静态方法
 */
public class NewInterfaceTest3 {
    public static void main(String[] args) {
//        NewInterfaceTest3Interface.<Integer, String>met1();
        NewInterfaceTest3Interface.<Integer>met2();// TODO 为什么调用的时候必须传一个泛型？NewInterfaceTest3Interface的类定义不是两个泛型吗？难道是met2方法定的时候制定一个了一个泛型T？
    }

    static interface NewInterfaceTest3Interface<T, R> {
        static void met1() {}
        static <T> NewInterfaceTest3Interface<T, T> met2() {
            return null;
        }
    }
}
