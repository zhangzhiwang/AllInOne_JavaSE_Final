package com.kuaishou.lambda;

/**
 * lambda表达式初体验
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        /*
        需求：往Thread构造方法里面传入Runnable对象并启动线程
         */
        /*
         传统的方式给Thread构造方法传入一个Runnable对象有两种方式：
         1、单独定义一个Runnable接口的实现类，然后给Thread()传入该类的对象
         2、直接传入匿名内部类
         单数定义一个实现类，如果该实现类有其他地方会用到则可以采用这种方式；如果只是作为Thread构造方法的入参而其他地方不会复用那么使用匿名内部类即可，
         毕竟匿名内部类的作用就是在某一特定场景下会使用到某一个类而除此场景之外不会在用到，这样可以减少定义类的数量。
         */
        //方式1：在外面定义一个Runnable接口的实现类
        new Thread(new MyRunnable()).start();

        /*
        方式2：传入匿名内部类
        匿名内部类在形式上看起来比较复杂，比较乱，其实分析一下整个匿名内部类的实现最关键最核心的部分就是这一行代码：System.out.println("方式2");
        其它代码都是不得已写出来的，所以为了凸显重点只保留这一行核心代码即可：System.out.println("方式2");
         */
        new Thread(new Runnable() {
            public void run() {
                System.out.println("方式2");
            }
        }).start();

        /*
        方式3：lambda简化版
        lambda表达式只关注最核心的部分，其它部分可以省略。
        语法：
        1、方法头：就是参数列表，包括参数类型和名称
        2、->：连接方法头和方法体
        3、方法体
         */
        new Thread(() -> {System.out.println("方式3");}).start();
    }

    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("方式1");
        }
    }
}
