package com.kuaishou.methodRef;

import lombok.Data;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用方式5——数组::构造器
 * 
 */
public class MethodRefTest4 {
    public static void main(String[] args) {
        // 正常lambda表达式写法
        Function<Integer, String[]> function = (i) -> {return new String[i];};
        String[] ss = function.apply(3);
        System.out.println(ss.length);

        // 简写
        System.out.println("-------------");
        Function<Integer, String[]> function2 = i -> new String[i];
        String[] ss2 = function.apply(5);
        System.out.println(ss2.length);

        /*
         方法引用——数组::构造器
         数组::构造器这个格式的方法引用的用法比较特殊，因为方法引用的前提是只能引用已经存在的方法，但是数组::构造器这种形式并没有一个现成的方法，可以理解为"假象"出来一个方法，长这样：
         public String[] met1(Integer size) {return new String[size];}
         然后用这个met1替换Function的apply方法
         */
        System.out.println("-------------");
        Function<Integer, String[]> function3 = String[]::new;
        String[] ss3 = function3.apply(7);
        System.out.println(ss3.length);
    }
}
