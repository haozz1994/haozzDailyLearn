package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200427;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: haozz
 * @date: 2020/4/27 23:45
 */
public class LockSupportTest {

    public static void main(String[] args) {

        System.out.println("begin park!");

        LockSupport.park();

        System.out.println("end park!");
    }
}
