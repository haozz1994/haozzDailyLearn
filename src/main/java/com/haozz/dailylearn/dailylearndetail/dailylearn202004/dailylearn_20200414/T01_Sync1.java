package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200414;

import org.openjdk.jol.info.ClassLayout;

/**
 * https://www.bilibili.com/video/BV1NT4y1G7WE
 *
 * synchronized学习
 *
 * @author: haozz
 * @date: 2020/4/14 22:43
 */
public class T01_Sync1 {

    public static class Lock{}

    public static void main(String[] args) {
        Lock lock = new Lock();

        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        /**
         * 打印的是lock对象在内存中的布局
         * 前三项是对象头，最后一项是对齐信息，整个对象是Instance size16个字节
         * 前两项是mark Word，占8个字节
         * 第三项是class pointer
         * 那实例数据去哪里了，难道说是因为这个Lock对象是空的所以没有打印出来实例数据？
         * 打印结果：
         *
         * com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200414.T01_Sync1$Lock object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           43 c5 00 f8 (01000011 11000101 00000000 11111000) (-134167229)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */
    }
}
