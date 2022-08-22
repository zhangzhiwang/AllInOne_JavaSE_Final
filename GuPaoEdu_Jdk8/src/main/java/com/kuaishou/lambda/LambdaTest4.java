package com.kuaishou.lambda;

/**
 * lambda表达式的使用限制条件
 */
public class LambdaTest4 {
    public static void main(String[] args) {
        // 入参是接口才能使用lambda表达式，抽象类和普通类都不能使用lambda表达式，这个和匿名内部类是有区别的
        m1((name, age) -> {
            return name;
        });

        // 抽象类不能使用lambda表达式，idea会提示：Target type of a lambda conversion must be an interface
//        m2((name, age) -> {
//            return name;
//        });

        // 普通类不能使用lambda表达式，idea会提示：Target type of a lambda conversion must be an interface
//        m3((name, age) -> {
//            return name;
//        })

        // 接口必须有且只有一个抽象方法，idea提示：Multiple non-overriding abstract methods found in interface com.kuaishou.lambda.LambdaTest4.LambdaTest4Interface2
//        m4((name, age) -> {
//            return name;
//        });

        // 接口必须有且只有一个抽象方法，idea提示：No target method found
//        m5(() -> {});
    }

    public static String m1(LambdaTest4Interface lambdaTest4Interface) {
        return "";
    }

    public static String m2(LambdaTest4AbstractClass lambdaTest4AbstractClass) {
        return "";
    }

    public static String m3(LambdaTest4Class lambdaTest4Class) {
        return "";
    }

    public static String m4(LambdaTest4Interface2 lambdaTest4Interface2) {
        return "";
    }

    public static String m5(LambdaTest4Interface3 lambdaTest4Interface3) {
        return "";
    }

    static interface LambdaTest4Interface {
        String met1(String name, int age);
    }

    static interface LambdaTest4Interface2 {
        String met1(String name, int age);
        int met2(String name);
    }

    static interface LambdaTest4Interface3 {

    }


    static abstract class LambdaTest4AbstractClass {
        abstract String met1(String name, int age);
    }

    static class LambdaTest4Class {
        public String met1(String name, int age) {
            return "";
        }
    }
}
