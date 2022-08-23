package com.kuaishou.newInterface;

/**
 * jdk1.8接口增强之——默认方法
 */
public class NewInterfaceTest1 {

    public static void main(String[] args) {
        NewInterfaceTest1Inteface1Impl1 impl1 = new NewInterfaceTest1Inteface1Impl1();
        impl1.met3();

        System.out.println("-----------");
        NewInterfaceTest1Inteface1Impl2 impl2 = new NewInterfaceTest1Inteface1Impl2();
        impl2.met3();
    }

    static interface NewInterfaceTest1Inteface1 {
        void met1();
        // jdk1.8以前如果接口新增方法的话，那么所有实现类都必须跟着实现新的方法，否则编译不通过，即使某些实现类实现了新方法也没有什么用，只能做空实现
        void met2();

        /*
         jdk1.8在新增接口时可以是提供默认实现，这样实现类可以选择性地实现新接口，即使不实现也没有关系。
         实现类在调用的时候可以调动接口中的默认方法，如果自己重写了该方法那么就调用自己的，否则调用接口默认的实现
         */
        default void met3() {
            System.out.println("接口默认实现");
        }
    }

    static class NewInterfaceTest1Inteface1Impl1 implements NewInterfaceTest1Inteface1 {

        @Override
        public void met1() {

        }

        @Override
        public void met2() {

        }

        @Override
        public void met3() {
            System.out.println("实现类1重写了接口的默认方法");
        }
    }

    static class NewInterfaceTest1Inteface1Impl2 implements NewInterfaceTest1Inteface1 {

        @Override
        public void met1() {

        }

        @Override
        public void met2() {

        }

        // 如果不需要可以不重写接口的默认方法
    }
}
