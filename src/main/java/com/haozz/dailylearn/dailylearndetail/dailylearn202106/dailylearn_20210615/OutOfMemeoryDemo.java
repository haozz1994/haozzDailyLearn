package com.haozz.dailylearn.dailylearndetail.dailylearn202106.dailylearn_20210615;

import com.haozz.dailylearn.mp.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author haozhezhe@yunquna.com
 * @date 12:01 AM 6/16/21
 */
public class OutOfMemeoryDemo {


    public static List<Object> list = new ArrayList<>();

    // JVM设置
    // -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\jvm.dump
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        // 这个地方为什么会内存溢出？
        while (true) {
            list.add(new User((long) i++, UUID.randomUUID().toString()));
            new User((long) j--, UUID.randomUUID().toString());
        }
    }

}
