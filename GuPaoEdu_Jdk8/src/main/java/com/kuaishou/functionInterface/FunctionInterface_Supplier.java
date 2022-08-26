package com.kuaishou.functionInterface;

import java.util.function.Supplier;

/**
 * jdk1.8内置函数式接口——Supplier
 */
public class FunctionInterface_Supplier {
    public static void main(String[] args) {
        met1(() -> {
            int[] is = new int[]{1,2,3};
            int result = 0;
            for (int i : is) {
                result += i;
            }
            return result;
        });
    }

    private static void met1(Supplier<Integer> supplier) {
        Integer result = supplier.get();
        System.out.println(result);
    }
}
