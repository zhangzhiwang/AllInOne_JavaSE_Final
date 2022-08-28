package com.kuaishou.methodRef;

import java.util.function.Function;

/**
 * 方法引用方式3——类名::实例方法名
 */
public class MethodRefTest2 {
    public static void main(String[] args) {
        Function<String, Integer> function1 = (s) -> {return s.length();};
        // 简写
        Function<String, Integer> function2 = (s) -> s.length();
        /*
         方法引用——类名::实例方法名
         为什么可以这么写呢？String类的length方法是实例方法呀？而且lambda表达式需要实现Function接口的apply方法，这个方法的入参类型是String返回值类型是Integer，length虽然返回值是int的但是没有入参呀？这样方法的入参不符合这么能用方法引用替代lambda表达式呢？
         其实，"类名::实例方法名"表达的含义是：冒号前的"类名"是抽象方法入参的类型，整个表达是的含义是：要用抽象方法入参该类型的实例去调用冒号后面的方法，比如String::length的含义是：抽象方法的入参肯定要是String类型的，要用String类型的实例去调用后面的length方法。
         */
        Function<String, Integer> function3 = String::length;
        Integer result = function3.apply("hello");// String::lengt表示用String类型的实例对象"hello"去调用length方法并返回
        System.out.println(result);
    }
}
