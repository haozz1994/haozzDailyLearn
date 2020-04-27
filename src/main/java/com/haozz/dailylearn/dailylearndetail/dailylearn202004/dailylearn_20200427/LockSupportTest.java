package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200427;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: haozz
 * @date: 2020/4/27 23:45
 */
public class LockSupportTest {

    /**
     * 只会输出begin park
     * 在执行LockSupport.park()后，当前线程会被挂起，因为在默认情况下调用线程是不持有LockSupport中的许可证的
     * @param args
     */
    public static void main(String[] args) throws InterruptedException{

        // 只会输出begin park
        // 在执行LockSupport.park()后，当前线程会被挂起，因为在默认情况下调用线程是不持有LockSupport中的许可证的
//        System.out.println("begin park!");
////
////        LockSupport.park();
////
////        System.out.println("end park!");


        // ============================================================================================


        //两个打印都会输出

//        System.out.println("bebin park!");
//
//        //使当前线程获得许可证
//        LockSupport.unpark(Thread.currentThread());
//
//        //再次调用park方法
//        LockSupport.park();
//
//        System.out.println("end park!");




        // ============================================================================================
        Thread threadOne = new Thread(() ->{
            System.out.println("child thread begin park!");

            //调用park方法，挂起自己
            LockSupport.park();

            System.out.println("child thread unpark!");
        });

        //启动子线程
        threadOne.start();

        //主线程休眠1s
        Thread.sleep(1000);

        System.out.println("main thread begin unpark");

        //调用unpark方法讓thread线程持有许可证，然后park方法返回
        LockSupport.unpark(threadOne);
    }
}
