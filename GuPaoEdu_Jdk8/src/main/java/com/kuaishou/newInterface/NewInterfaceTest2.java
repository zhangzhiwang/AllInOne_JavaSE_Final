package com.kuaishou.newInterface;

/**
 * jdk1.8接口增强之——静态方法
 */
public class NewInterfaceTest2 {
    public static void main(String[] args) {
        NewInterfaceTest2Interface.met1();
        NewInterfaceTest2InterfaceImpl.met1();
        // NewInterfaceTest2InterfaceImpl2.met1();// 实现类不能直接调用接口的静态方法
    }

    static interface NewInterfaceTest2Interface {
        static void met1() {
            System.out.println("接口中的静态方法");
        }
    }

    static class NewInterfaceTest2InterfaceImpl implements NewInterfaceTest2Interface {
        // @Override 接口中的静态方法是不能被重写的，即使实现类表面上重写的接口的静态方法实际上是实现类自己定义了一个新的静态方法，标注@Override报错
        public static void met1() {
            System.out.println("实现类中的方法");
        }
    }

    static class NewInterfaceTest2InterfaceImpl2 implements NewInterfaceTest2Interface {}
}
