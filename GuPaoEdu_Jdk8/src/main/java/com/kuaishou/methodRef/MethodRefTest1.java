package com.kuaishou.methodRef;

/**
 * 方法引用方式1：静态方法
 */
public class MethodRefTest1 {
    public static void main(String[] args) {
        long l = Long.parseLong("10");
        System.out.println(l == 10);
    }

    private static void m1(MethodRefTest1Interface m, int[] arr) {
        int result = m.met1(arr);
        System.out.println(result);
    }

    private static int sum(int[] is) {
        int sum = 0;
        for (int i : is) {
            sum += i;
        }

        return sum;
    }

    @FunctionalInterface
    static interface MethodRefTest1Interface {
        int met1(int[] arr);
    }
}
