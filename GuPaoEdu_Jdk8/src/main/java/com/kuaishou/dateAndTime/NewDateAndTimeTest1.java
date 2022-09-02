package com.kuaishou.dateAndTime;

/**
 * 新版日期和时间
 */
public class NewDateAndTimeTest1 {
    public static void main(String[] args) {
        /*
         jdk1.8之前的日期类：
         java.util.Date包含日期和时间，java.sql.Date只包含日期
         */
        java.util.Date d1 = new java.util.Date();
        System.out.println("d1 = " + d1);

        java.sql.Date d2 = new java.sql.Date(System.currentTimeMillis());
        System.out.println("d2 = " + d2);
    }
}
