package com.kuaishou.lambda;

/**
 * @FunctionalInterface注解
 * 该注解只起到一个标记的作用并没有其他实际用处，即被@FunctionalInterface注解标识的接口有且只能有一个方法，定义0个或多个方法编译不通过，所以一看到该注解就应该知道被标记的接口只会有一个方法。
 * 但是被@FunctionalInterface注解修饰的类可以有默认方法和静态方法
 */
public class FuntionalInterfaceTest {

    @FunctionalInterface
    static interface IService2 {
        void met1();
//        void met2();
        default void met3() {}

        static void met4() {}
    }
}