package com.kuaishou.optional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Optional的常见方法
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        /*
        常见方法1：get方法
        get方法的作用就是如果Optional对象的value属性包含值就将其返回，否则抛出NoSuchElementException
        为了防止get方法抛出NoSuchElementException异常，往往会结合isPresent方法使用
         */
        /*
        常见方法2：isPresent方法——判断是否存在值，如果存在值则返回true，否则返回false
         */
        Optional<String> op1 = Optional.of("aaa");
        if(op1.isPresent()) {
            System.out.println(op1.get());
        } else {
            System.out.println("op1没有值");
        }

        Optional<Integer> op2 = Optional.ofNullable(null);
        if (op2.isPresent()) {
            System.out.println(op2.get());
        } else {
            System.out.println("op2没有值");
        }

        /*
        常见方法3：orElse方法——如果有值则返回值，否则返回默认值，默认值就是该方法的入参
         */
        Optional<String> op3 = Optional.of("bbb");
        String s1 = op3.orElse("default");// orElse是一个实例方法，所以必须要有一个Optional对象来进行调用
        System.out.println(s1);

        String s2 = Optional.<String>ofNullable(null).orElse("default value");
        System.out.println(s2);

        /*
        常见方法4：orElseGet方法——如果有值就返回值，否则返回lambda表达式的值
        它和orElse方法不一样的地方是：orElse方法的默认值是写死的，而orElseGet方法的默认是是lambda表达式返回的，相当于是活的
         */
        String s3 = Optional.of("ccc").orElseGet(() -> "666");
        System.out.println(s3);

        Object s4 = Optional.ofNullable(null).orElseGet(() -> "666");
        System.out.println(s4);

        /*
        常见方法5：ifPresent方法——如果有值就对值做一些处理，如果没值什么都不做
        ifPresent也是一个实例方法，所以必须用Optional实例来调用。
         */
        Optional.<String>of("ddd").ifPresent((s) -> {
            System.out.println(s.toUpperCase());
        });
        System.out.println("---------------------");

        /*
        常见方法6：map方法——接受一个Function类型的参数
        map方法是一个实例方法，如果调用该方法的Optional对象有值，那么会调用入参的Function对象的apply方法对该值进行处理，然后apply方法会返回一个值，这个返回值会作为Optional.ofNullable的入参，最终将新创建的Optional对象返回
         */
        Optional<String> op4 = Optional.<String>of("eee");
        System.out.println("op4 = " + op4);
        System.out.println("op4.hash = " + op4.hashCode());

        Optional<Date> op5 = op4.map((s) -> {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = df.parse(s);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } finally {
                return date;
            }
        });
        System.out.println("op5 = " + op5);
        System.out.println("op5.hash = " + op5.hashCode());

        if (op5.isPresent()) {
            System.out.println("op5的值：" + op5.get());
        } else {
            System.out.println("op5为空");
        }
        System.out.println("---------------------");

        // map方法的入参是Functional对象，传参时可以使用方法引用
        Optional<Date> op6 = Optional.of("fff").map(OptionalTest2::met1);
        if (op6.isPresent()) {
            System.out.println("op6的值：" + op6.get());
        } else {
            System.out.println("op6为空");
        }

        // map方法和orElse方法合用
        Date d1 = Optional.of("2000-01-01").map(OptionalTest2::met1).orElse(new Date());
        System.out.println("d1 = " + d1);
    }

    private static Date met1(String str) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            return date;
        }
    }
}
