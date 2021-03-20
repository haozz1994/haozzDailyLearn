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
     * 饿汉式 :  在类加载的时候就进行实例化，
     * 可以看到，类中static的示例instance，指向了一个new Singletion2，由于是类的静态示例，所以在类加载的时候，也就是jvm启动的时候就会实例化，后面所有调用getInstance的时候都会拿这个示例
     */
}
