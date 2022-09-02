package com.kuaishou.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Optional对象的创建
 */
public class OptionalTest1 {
    public static void main(String[] args) {
        // jdk1.8之前的情况
        String s = "";
//        System.out.println(s.length());// NPE
        if (s == null) {// jdk1.8之前在使用对象之前要判空，否则肯有可能出现NPE
            System.out.println("s为null");
        } else {
            System.out.println(s.length());
        }

        // 注意Optional对象不能通过构造方法进行构造，因为所有的构造方法都是私有的
//        Optional<String> op = new Optional<>();

        /*
         Optional对象的创建方式1：of方法
         of方法接受一个入参，并通过get方法返回该入参，但是of方法的入参不能为null
         */
        Optional<String> op1 = Optional.of("hello");
        String s1 = op1.get();
        System.out.println(s1);

        Optional<User> op2 = Optional.of(new User(18));
        User user1 = op2.get();
        System.out.println(user1);

//        Optional<Object> op3 = Optional.of(null);// NPE，查看源码可知of方法如果入参是null会有校验，会手动抛一个NPE

        // 如果想让of方法接受null入参可以使用ofNullable方法
        Optional<String> op3 = Optional.ofNullable("world");
        String s2 = op3.get();
        System.out.println(s2);

        Optional<User> op4 = Optional.ofNullable(new User(20));
        User user2 = op4.get();
        System.out.println(user2);

        Optional<Object> op5 = Optional.ofNullable(null);// 虽然ofNullable可以接受null参数，但是通过返回的Optional对象调用get方法时仍然抛异常，只不过不是NPE了，而是NoSuchElementException异常
//        Object o1 = op5.get();
//        System.out.println(o1);

        /*
         Optional对象的创建方式2：empty方法
         通过empty方法创建一个空的Optional对象
         */
        Optional<Object> op6 = Optional.empty();
        Object o2 = op6.get();// NoSuchElementException，不管是通过什么方式创建的Optional对象，只要该对象的value属性为null在调用get方法的时候就会抛这个异常，可以查看源码
        System.out.println(o2);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private int age;
    }
}
