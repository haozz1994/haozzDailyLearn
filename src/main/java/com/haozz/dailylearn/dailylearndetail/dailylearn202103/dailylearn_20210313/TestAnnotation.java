package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210313;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haozhezhe@yunquna.com
 * @date 5:23 PM 3/13/21
 */
public class TestAnnotation {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void main(String[] args) {

    }

    @SuppressWarnings("all")
    public void test() {

        // 初始化一个元素但不使用，会产生never used警告，可以用@SuppressWarnings镇压警告
        List list = new ArrayList();


        //   注解  的定义形式是  @interface
        /**
         * 所有的注解，都会有 @Target 这个注解，表明当前注解可以使用的地方，比如 类，方法，字段，构造函数，包，甚至注解本身
         * 比如override就只能用在方法上
         *
         * 注解中的字段，就是在使用这个注解是需要定义的参数
         *
         *
         *
         */
    }
}
