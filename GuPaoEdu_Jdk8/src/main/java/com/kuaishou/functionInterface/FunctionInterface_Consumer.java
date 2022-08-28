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

        met2AndThen(i -> {
            System.out.println("第一个处理：" + (i + 1));
        }, i -> {
            System.out.println("第二个处理：" + (i - 1));
        }, 10);
    }

    private static void met1(Consumer<Integer> consumer, int i) {
        consumer.accept(i);
    }

    private static void met2AndThen(Consumer<Integer> consumer1, Consumer<Integer> consumer2, int i) {
        // andThen方法的意思是先走consumer1的accept方法，再走consumer2的accept方法
        consumer1.andThen(consumer2).accept(i);// TODO 为什么andThen方法后面还要调一下accept方法呢？andThen方法内部不是调用accept方法了吗？
    }
}
