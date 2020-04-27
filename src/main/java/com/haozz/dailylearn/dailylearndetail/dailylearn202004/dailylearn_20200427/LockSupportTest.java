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
    public static void main(String[] args) {

        System.out.println("begin park!");

        LockSupport.park();

        System.out.println("end park!");
    }
}
