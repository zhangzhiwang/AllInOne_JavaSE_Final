package com.kuaishou.lambda;

/**
 * lambda表达式简写形式
 *
 */
public class SimpleLambdaTest1 {
    public static void main(String[] args) {
        // 标准语法
        int result = m1((String name, int age) -> {
            name = "hello " + name;
            System.out.println("lambda:" + name);
            age += 10;
            return age;
        }, "zhangsan", 18);

        System.out.println(result);

        // 简写语法1：省略小括号里面的参数类型
        System.out.println("---------------");
        int result2 = m1((name, age) -> {
            name = "你好，" + name;
            System.out.println(name);
            return age += 10;
        }, "lisi", 10);
        System.out.println(result2);

        // 简写语法2：如果只有一个入参，则小括号可以省略
        System.out.println("--------------");
        String result3 = m2(name -> {
            return "这是" + name;
        }, "wangwu");
        System.out.println(result3);

        // 简写语法3：如果大括号内只有一条语句，那么可以同时省略：大括号、return关键字、return关键字最后的分号
        System.out.println("----------------");
        String result4 = m2(name -> "你是不是" + name + "？", "zhaoliu");
        System.out.println(result4);
    }

    public static int m1(SimpleLambdaTest1Interface1 simpleLambdaTest1Interface1, String name, int age) {
        int i = simpleLambdaTest1Interface1.met1(name, age);
        return i;
    }

    public static String m2(SimpleLambdaTest1Interface2 simpleLambdaTest1Interface2, String name) {
        return simpleLambdaTest1Interface2.met2(name);
    }

    static interface SimpleLambdaTest1Interface1 {
        int met1(String name, int age);
    }

    static interface SimpleLambdaTest1Interface2 {
        String met2(String name);
    }
}
