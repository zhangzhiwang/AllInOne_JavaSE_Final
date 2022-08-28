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

        System.out.println("-----------------");
        met1And(i -> {
            return i == 10;
        }, i -> {
            return i % 10 == 0;
        }, 100);

        System.out.println("-----------------");
        met1Or(i -> {
            return i == 10;
        }, i -> {
            return i % 10 == 0;
        }, 100);

        System.out.println("-----------------");
        met1Negate(i -> {
            return i == 10;
        }, 100);

        System.out.println("-----------------");
        met1IsEqual(null, 10);
    }

    private static void met1(Predicate<Integer> predicate, int i) {
        boolean result = predicate.test(i);
        System.out.println(result);
    }
    private static void met1And(Predicate<Integer> predicate1, Predicate<Integer> predicate2, int i) {
        boolean result = predicate1.and(predicate2).test(i);
        System.out.println(result);
    }
    private static void met1Or(Predicate<Integer> predicate1, Predicate<Integer> predicate2, int i) {
        boolean result = predicate1.or(predicate2).test(i);
        System.out.println(result);
    }
    private static void met1Negate(Predicate<Integer> predicate1, int i) {
        boolean result = predicate1.negate().test(i);
        System.out.println(result);
    }
    private static void met1IsEqual(Object o, int i) {
        Predicate<Integer> predicate = Predicate.<Integer>isEqual(o);
        boolean result = predicate.test(i);// TODO isEqual源码没看懂
        System.out.println(result);
    }
}
