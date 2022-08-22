package com.kuaishou.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * 使用javac变异LambdaTest5和LambdaTest6，可以发现匿名内部类是在编译时生成class文件，而lambda表达式是在运行时生成的
 */
public class LambdaTest5 {
    public static void main(String[] args) {
        // javac编译后生成LambdaTest5.class文件和LambdaTest5$1.class文件
        List<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
