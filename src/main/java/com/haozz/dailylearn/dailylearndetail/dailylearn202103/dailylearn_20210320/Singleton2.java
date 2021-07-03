package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210320;

/**
 * 单例模式 - 饿汉式
 *
 * @author haozhezhe@yunquna.com
 * @date 11:51 AM 3/20/21
 */
public class Singleton2 {

    private Singleton2() {

    }

    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance() {
        return instance;
    }

    /**
     * Java 类的加载过程包括：加载、验证、准备、解析、初始化.
     * 初始化阶段即执行类的 clinit 方法（clinit = class + initialize），包括为类的静态变量赋初始值和执行静态代码块中的内容。
     */

    /**
     * 饿汉式 :  在类加载的时候就进行实例化，
     * 可以看到，类中static的示例instance，指向了一个new Singletion2，由于是类的静态示例，所以在类加载的时候，也就是jvm启动的时候就会实例化，后面所有调用getInstance的时候都会拿这个示例
     */

    /**
     * 饿汉式有一个弊端，那就是即使这个单例不需要使用，它也会在类加载之后立即创建出来，占用一块内存，并增加类初始化时间。
     * 就好比一个电工在修理灯泡时，先把所有工具拿出来，不管是不是所有的工具都用得上。就像一个饥不择食的饿汉，所以称之为饿汉式。
     */


}
