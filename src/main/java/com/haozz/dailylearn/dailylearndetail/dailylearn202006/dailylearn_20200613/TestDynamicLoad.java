package com.haozz.dailylearn.dailylearndetail.dailylearn202006.dailylearn_20200613;

/**
 * 执行结果：
 * ****** load TestDynamicLoad ******
 * ****** load A ******
 * ****** initial A ******
 * ****** load test ******
 *
 *
 *
 * 主类在运行过程中如果使用到其它类，会逐步加载这些类。 jar包或war包里的类不是一次性全部加载的，是使用到时才加载。
 *
 *
 * 类加载过程有如下几步： 加载 >> 验证 >> 准备 >> 解析 >> 初始化 >> 使用 >> 卸载
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
