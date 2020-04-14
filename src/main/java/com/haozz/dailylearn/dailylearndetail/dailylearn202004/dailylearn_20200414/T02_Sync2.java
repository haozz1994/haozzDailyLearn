package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200414;

import org.openjdk.jol.info.ClassLayout;

/**
 * https://www.bilibili.com/video/BV1NT4y1G7WE
 * <p>
 * synchronized学习
 * <p>
 * T01_Sync1 加锁
 *
 * @author: haozz
 * @date: 2020/4/14 22:43
 */
public class T02_Sync2 {

    public static class Lock {
    }

    public static void main(String[] args) {
        Lock lock = new Lock();

        synchronized (lock) {

            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }

        /**
         * 打印结果：
         * 加了synchronized锁之后，前两项mark word发生了改变
         *
         * com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200414.T02_Sync2$Lock object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           58 f2 2c 03 (01011000 11110010 00101100 00000011) (53277272)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           43 c5 00 f8 (01000011 11000101 00000000 11111000) (-134167229)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */
    }


    /**
     * 新new出来的对象是无锁态
     * 单个线程给对象加锁后，是偏向锁
     *
     */
}
