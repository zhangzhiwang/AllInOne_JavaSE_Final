package com.kuaishou.functionInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.Function;

/**
 * jdk1.8内置函数式接口——Function
 */
public class FunctionInterface_Function {
    public static void main(String[] args) {
        met1(i -> {
            return "hello:" + i;
        }, 10);

        System.out.println("--------------");
        met2AndThen(i -> {
            if(i % 10 == 0) {
                return "2000-01-01 00:00:00";
            } else {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:dd");
                return df.format(new Date(System.currentTimeMillis()));
            }
        }, s -> {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:dd");
            try {
                Date date = df.parse(s);
                return date;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }, 11);
        System.out.println("-----------");

        met3Compose(d -> {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:dd");
            return df.format(d);
        }, l -> {
            Date date = new Date(l);
            return date;
        }, System.currentTimeMillis());

        System.out.println("-----------");
        met4Identity("hello");
    }

    private static void met1(Function<Integer, String> function, int i) {
        String result = function.apply(i);
        System.out.println("result = " + result);
    }

    private static void met2AndThen(Function<Integer, String> function1, Function<String, Date> function2, int i) {
        Date date = function1.andThen(function2).apply(i);// function1的出餐类型是function2的入参类型
        System.out.println(date);
    }

    private static void met3Compose(Function<Date, String> function1, Function<Long, Date> function2, long l) {
        String s = function1.compose(function2).apply(l);
        System.out.println("s = " + s);
    }
    private static void met4Identity(String s) {
        // identity直接返回入参，不知道有什么用
        Function<String, String> identity = Function.<String>identity();
        String result = identity.apply(s);
        System.out.println("result = " + result);
    }
}
