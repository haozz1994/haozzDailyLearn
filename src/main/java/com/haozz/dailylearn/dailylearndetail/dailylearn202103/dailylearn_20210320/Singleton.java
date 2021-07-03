package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210320;

/**
 * 设计模式 之 单例模式
 * https://www.bilibili.com/video/BV1af4y1y7sS
 *
 * @author haozhezhe@yunquna.com
 * @date 10:47 AM 3/20/21
 */
public class Singleton {

    /**
     * 什么是单例？
     * <p>
     * 确保一个类只有一个实例，并且自行实例化并向整个系统提供这个实例。
     * 比如：序号生成器、web页面计数器、创建一个对象需要消耗过多资源的场景（访问IO、访问数据库）
     * <p>
     * <p>
     * 1.首先，只有一个实例，就要求不能随意被外界实例化，也就是不能被其他类创建对象，也就要求构造方法必须是private的
     * <p>
     * 2.既然只有一个实例，那这个实例就需要属于当前类，也就是当前类的静态变量
     * <p>
     * 3.这个类要被使用的话，就需要向整个系统提供这个实例，所以还需要提供一个静态方法，向外界提供当前类的实例
     */

    // 1.私有的构造方法
    private Singleton() {
    }

    // 2.实例，也是当前类的静态变量
    private static Singleton instance;

    // 3.提供给外界使用的方法
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 懒汉式、饿汉式
     */

    // 当前这种写法实际上是懒汉式，Singleton的实例化是在第一次使用的时候，也即是第一次调用getInstance方法的时候。
    // 通俗的理解就是，在第一次要用的时候再实例化，所以称为懒汉式。 饿汉式参考Singleton2


}
