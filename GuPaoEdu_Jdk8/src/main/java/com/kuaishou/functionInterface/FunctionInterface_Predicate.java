package com.kuaishou.functionInterface;

import java.util.function.Predicate;

/**
 * jdk1.8内置函数式接口——Predicate
 */
public class FunctionInterface_Predicate {
    public static void main(String[] args) {
        met1(i -> {
            return i == 10;
        }, 10);
    }

    private static void met1(Predicate<Integer> predicate, int i) {
        boolean result = predicate.test(i);
        System.out.println(result);
    }
}
