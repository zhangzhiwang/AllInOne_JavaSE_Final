package com.kuaishou.methodRef;

import java.util.Date;
import java.util.function.Supplier;

/**
 * 方法引用方式1——引用静态方法：类名::静态方法名
 * 方法引用方式2——对象名::实例方法名
 */
public class MethodRefTest1 {
    public static void main(String[] args) {
        /*
         可以发现lambda表达式的内容和sum方法的内容是一样的，换句话说sum方法可以达到lambda表达式的目的，并且sum的方法定义和接口MethodRefTest1Interface的抽象方法met1是一样的，
         所以就没有必要在lambda里把相同的逻辑再写一遍，可以直接用sum方法替代lambda表达式，这里就可以在lambda表达式的地方引用sum方法，这就是方法引用。
         */
        m1(arr -> {
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            return sum;
        }, new int[]{1,2,3});

        System.out.println("---------------");
        // 使用方法引用来替代lambda表达式，这里引用的是静态方法
        m1(MethodRefTest1::sum, new int[]{1,2,3});

        // 这里引用实例方法
        MethodRefTest1 methodRefTest1 = new MethodRefTest1();
        m1(methodRefTest1::sum2, new int[]{1,2,3});
        m1(new MethodRefTest1()::sum2, new int[]{1,2,3});

        // 引用静态方法的其它例子
        System.out.println("引用静态方法的其它例子：");
        m2(() -> {
            // 实现的功能：获取当前时间的毫秒数
            long now = System.currentTimeMillis();
            return now;
        });

        m2(System::currentTimeMillis);// 达到和上面一样的效果

        // 引用实例方法的其它例子
        System.out.println("引用实例方法的其它例子：");
        Date date = new Date();
        m2(date::getTime);
    }

    private static void m2(Supplier<Long> supplier) {
        Long s = supplier.get();
        System.out.println(s);
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

    private int sum2(int[] is) {
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
