package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210320;

/**
 * 设计模式 之 单例模式
 * synchronized 实现
 *
 * @author haozhezhe@yunquna.com
 * @date 10:47 AM 3/20/21
 */
public class Singleton3 {


    /**
     * 我们先声明了一个初始值为 null 的 instance 变量，当需要使用时判断此变量是否已被初始化，没有初始化的话才 new 一个实例出来。
     * 就好比电工在修理灯泡时，开始比较偷懒，什么工具都不拿，当发现需要使用螺丝刀时，才把螺丝刀拿出来。当需要用钳子时，再把钳子拿出来。就像一个不到万不得已不会行动的懒汉，所以称之为懒汉式。
     */
    /**
     * 单例模式 懒汉式
     */
    private Singleton3() {
    }

    private volatile static Singleton3 instance;


    /**
     * 考虑这样一种场景：在多线程情况下，首次加载时，instance为空。
     * 此时A、B两个线程同时调用该方法，同时进行instance == null，判断结果都为true。
     * 则A、B两个线程都会执行 instance = new Singleton3(); 也就是被实例化了两次， 这样就会有问题
     * <p>
     * 所以需要对这个方法进行加锁，synchronized同步，保证同一时刻只有一个线程可以执行这个方法，也就不会有上面这个问题。
     * <p>
     * 但是，这样有会有新的问题，想想看，上面的这个多线程问题，实际上只会发生在第一次实例化的时候，后面每次实例化对象的时候if判断都是false，也就不会有这个问题
     * 但是synchronized关键字是加在整个方法上的，也就是后面的获取instance还会进同步块，会非常影响性能，所以需要减小同步的范围[1]。
     *
     * @return
     */
    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }


    /**
     * 双重检查锁
     *
     * 为了解决上面的问题[1]，在这里减小同步的范围，不需要对整个方法进行synchronized
     * 而是只在第一次实例化，也就是 instance == null 判断为true的时候，进行synchronized同步处理。在同步块中需要再次判断instance 是否被实例化过
     * 试想，两个线程同时走到 第一次 instance == null 判断地方，都为true，同时进入抢synchronized锁，A线程抢到了，执行完了实例化操作，释放锁之后B线程继续执行，到了synchronized中判断  instance == null 此时由于已经被实例化过了，所以不需要new了
     * 如果不加第二次判断，那么在第二个线程等待锁之后还会初始化，也会有问题
     * 这样的写法叫做双重检查锁
     * @return
     */
    public static Singleton3 getInstance1() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }


    /**
     * 继续思考，这样的代码还会有问题，需要对instance示例进行volatile修饰
     *
     * instance = new Singleton3();这一句代码可以拆解为3步:
     * 1.开辟出一块内存
     * 2.初始化一个Singleton3的对象
     * 3.将第一步开辟出的内存 指向 第二步初始化出的对象
     *
     * 按照常规理解，初始化对象的时候应该按照123的步骤顺序执行，但是JVM为了优化会进行指令重排序，执行的时候有可能是 1、3、2的步骤执行
     *
     * 假设A线程先抢到了锁，执行了1、3步骤，还没有执行2，这时，B线程进入getInstance方法，进行第一次 instance == null 判断，判断结果会是false，因为A线程执行了13步，开了内存，指向了一个对象，所以B线程会认为instance不是null， 因为有地址了。
     * 但是此时A线程还没有执行第2步，B线程拿到的instance实际是相当于是个null，后面什么也干不了，甚至会保存。
     *
     * volatile关键字的作用之一就是禁止jvm在编译的时候进行指令重排序，可以规避这个问题，所以需要对Singleton3类中的静态实例instance进行volatile修饰
     */


    /**
     * 其他点：
     *
     * 单例应该是无状态的
     * 静态内部类解决重排序问题，classLoader机制   https://zhuanlan.zhihu.com/p/85624457
     * 反射打破单例
     */


    /**
     *
     * 静态内部类方式创建单例
     *
     *
     * public class Singleton {
     *
     *     private static class SingletonHolder {
     *         public static Singleton instance = new Singleton();
     *     }
     *
     *     private Singleton() {
     *     }
     *
     *     public static Singleton getInstance() {
     *         return SingletonHolder.instance;
     *     }
     * }
     */


}
