package com.kuaishou.methodRef;

import lombok.Data;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用方式4——类名::构造器
 */
public class MethodRefTest3 {
    public static void main(String[] args) {
        Supplier<User> supplier1 = () -> {return new User();};
        // 简写
        Supplier<User> supplier2 = () -> new User();
        /*
        使用方法引用——类名::构造器
        由于构造器的名称和类名是一样的，所以可以将构造方法的名字略去
        Supplier的get方法是一个无参且返回值类型是User的方法，即：
        public User get() {}
        那么除了方法名以外这不就是User的无参构造方法吗：public User user() {}，所以可以直接用User的无参构造方法来替代get方法
         */
        Supplier<User> supplier3 = User::new;
        User user = supplier3.get();
        System.out.println(user);
    }

    @Data
    static class User {
        private int age;
        private String name;
    }
}
