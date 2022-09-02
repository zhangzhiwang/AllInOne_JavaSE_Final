package com.kuaishou.functionInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * jdk1.8内置函数式接口——BiFunction
 * BiFunction的apply方法比Function的apply方法多一个入参，即两个入参一个返回值
 */
public class FunctionInterface_BiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, String, String[]> biFunction = (i, s) -> {
            return new String[]{"" + i, s};
        };
        String[] ss = biFunction.apply(1, "hello");
        for (String s : ss) {
            System.out.println(s);
        }

        System.out.println("-----------");
        Function<String[], Integer> function = sArr -> sArr.length;
        BiFunction<Integer, String, Integer> integerStringIntegerBiFunction = biFunction.andThen(function);
        Integer result = integerStringIntegerBiFunction.apply(10, "world");
        System.out.println(result);
    }
}
