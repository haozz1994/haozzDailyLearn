package com.haozz.dailylearn.dailylearndetail.dailylearn202006.dailylearn_20200613;

/**
 * 执行结果：
 * ****** load TestDynamicLoad ******
 * ****** load A ******
 * ****** initial A ******
 * ****** load test ******
 */
public class TestDynamicLoad {

    static {
        System.out.println("****** load TestDynamicLoad ******");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("****** load test ******");
        // B不会被加载，除非这里执行new B()
        B b = null;
    }
}

class A {
    static {
        System.out.println("****** load A ******");
    }

    public A() {
        System.out.println("****** initial A ******");
    }
}

class B {
    static {
        System.out.println("****** load B ******");
    }

    public B() {
        System.out.println("****** initial B ******");
    }
}
