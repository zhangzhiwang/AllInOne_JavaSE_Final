package com.kuaishou.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 使用javac变异LambdaTest5和LambdaTest6，可以发现匿名内部类是在编译时生成class文件，而lambda表达式是在运行时生成的
 */
public class LambdaTest6 {
    public static void main(String[] args) {
        // javac编译后只生成LambdaTest6.class文件
        List<Integer> list = new ArrayList<>();
        list.sort((o1, o2) -> {
            return 0;
        });
    }
}
