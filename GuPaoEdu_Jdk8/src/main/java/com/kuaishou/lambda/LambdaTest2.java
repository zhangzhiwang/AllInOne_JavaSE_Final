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
public class LambdaTest2 {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(18));
        list.add(new User(17));
        list.add(new User(22));

        // 原始的方式——使用匿名内部类
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);

        System.out.println("--------------");
        // 使用lambda表达式
        Collections.sort(list, (User o1, User o2) -> {
            return o1.getAge() - o2.getAge();
        });
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private int age;
    }
}
