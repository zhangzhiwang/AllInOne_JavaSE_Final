package com.kuaishou.functionInterface;

import java.util.function.Function;

/**
 * jdk1.8内置函数式接口——Function
 */
public class FunctionInterface_Function {
    public static void main(String[] args) {
        met1(i -> {
            return "hello:" + i;
        }, 10);
    }

    private static void met1(Function<Integer, String> function, int i) {
        String result = function.apply(i);
        System.out.println(result);
    }

    private static void met2(Function<Integer, String> function1, Function<Integer, String> function2, int i) {
//        function1.compose(function2).apply(i);
    }
}
