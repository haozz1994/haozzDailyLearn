package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200419;

import sun.misc.Unsafe;

/**
 * Unsafe类实践
 * 《Java并发编程之美》2.9 Unsafe类
 *
 * @author: haozz
 * @date: 2020/4/19 20:39
 */
public class TestUnsafe {

    //获取Unsafe实例
    static final Unsafe unsafe = Unsafe.getUnsafe();

    //记录变量state在类TestUnsafe中的偏移量
    static final long stateOffset;

    //变量
    private volatile long state = 0;

    static {
        try {
            //获取state变量在类TestUnsafe中的偏移量
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        //创建实例，并设置state值为1
        TestUnsafe test = new TestUnsafe();

        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);

        System.out.println(success);
    }

    /**
     * main方法运行报错：
     * java.lang.ExceptionInInitializerError
     * Caused by: java.lang.SecurityException: Unsafe
     * 	at sun.misc.Unsafe.getUnsafe(Unsafe.java:90)
     * 	at com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200419.TestUnsafe.<clinit>(TestUnsafe.java:18)
     * Exception in thread "main"
     */

    /**
     * Unsafe是rt.jar包提供的，其中的类是使用Bootstrap类加载器加载的，而启动main方法所在的类是使用AppClassLoader加载的
     * 而getUnsafe方法的源码中显示，会判断是不是Bootstrap加载器加载的TestUnsafe.class
     *
     * 因为Unsafe类可以直接操作内存，是不安全的，所以JDK开发组特意做了这个限制，不让开发人员在正规渠道使用Unsafe类，而是在rt.jar包里面的核心类中使用Unsafe功能
     *
     * 如果真的想要实例化Unsafe类，可以用反射来获取Unsafe实例方法
     *
     *
     */


}
