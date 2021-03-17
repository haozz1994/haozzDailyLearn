package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210316;

import cn.hutool.core.io.LineHandler;

import java.util.function.Consumer;

/**
 * @author haozhezhe@yunquna.com
 * @date 11:22 PM 3/17/21
 */
public class TestConsumer {

    public void set(String name) {

        System.out.println("this is set method : " + name);

    }

    public static void main(String[] args) {


        TestConsumer testConsumer = new TestConsumer();
        Consumer<String> set = testConsumer::set;

        System.out.println("=====");
        System.out.println("=====");

        set.accept("123");



    }
}
