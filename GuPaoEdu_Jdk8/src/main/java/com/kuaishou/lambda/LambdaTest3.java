package com.kuaishou.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 带参数的lambda表达式
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        // 匿名内部类方式
//        say(new IService() {
//            @Override
//            public String met1(String name) {
//                return "Hello " + name;
//            }
//        });

//        System.out.println("---------------");
        // lambda方式
        say((String name) -> {
            return "Hello " + name;
        });
    }

    public static void say(IService service) {
//        service.met1("Tom");
        String s = service.met1("Tom");
        System.out.println(s);
    }

   static interface IService {
        String met1(String name);
   }
}
