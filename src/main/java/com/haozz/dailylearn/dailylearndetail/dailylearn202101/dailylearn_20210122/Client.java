package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210122;

/**
 * @author haozhezhe@yunquna.com
 * @date 11:37 AM 1/22/21
 */
public class Client {

    public static void main(String[] args) {
        CriminalObservable zhangSan = new CriminalObservable();
        PoliceObserver police1 = new PoliceObserver("罗翔老师");
        PoliceObserver police2 = new PoliceObserver("AAA");
        PoliceObserver police3 = new PoliceObserver("BBB");
        zhangSan.addObserver(police1);
        zhangSan.addObserver(police2);
        zhangSan.addObserver(police3);
        zhangSan.crime("放狗咬人");
    }


    /**
     * Java 源码中的观察者模式
     *
     * java.util.Observer
     * java.util.Observable
     *
     * Observable 类和我们上例中的定义也是类似的，区别在于：
     *
     * 用于保存观察者列表的容器不是 ArrayList，而是 Vector
     * 添加了一个 changed 字段，以及 setChanged 和 clearChanged 方法。分析可知，当 changed 字段为 true 时，才会通知所有观察者，否则不通知观察者。所以当我们使用此类时，想要触发 notifyObservers 方法，必须先调用 setChanged 方法。这个字段相当于在被观察者和观察者之间添加了一个可控制的阀门。
     * 提供了 countObservers 方法，用于计算观察者数量
     * 添加了一些 synchronized 关键字保证线程安全
     * 这些区别仍然是为了让 Observable 的适用范围更广，核心思想与本文介绍的都是一致的。
     *
     */
}
