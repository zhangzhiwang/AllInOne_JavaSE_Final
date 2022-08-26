package com.kuaishou.functionInterface;

import java.util.function.Consumer;

/**
 * jdk1.8内置函数式接口——Consumer
 */
public class FunctionInterface_Consumer {
    public static void main(String[] args) {
        met1(i -> {
            System.out.println(i + 1);
        }, 10);

        met2(i -> {
            System.out.println("第一个处理：" + (i + 1));
        }, i -> {
            System.out.println("第二个处理：" + (i - 1));
        }, 10);
    }

    private static void met1(Consumer<Integer> consumer, int i) {
        consumer.accept(i);
    }

    private static void met2(Consumer<Integer> consumer1, Consumer<Integer> consumer2, int i) {
        consumer1.andThen(consumer2).accept(i);// TODO 为什么andThen方法后面还要调一下accept方法呢？不调用为什么不行呢？要结合Consumer类的andThen方法的源码分析下
    }
}
