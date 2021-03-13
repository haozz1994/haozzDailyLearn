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

    @MyAnnotation(desc = "test`s name", sex = 1)
    private String name;

    @SuppressWarnings("all")
    @MyAnnotation(desc = "test`s method")
    public void test() {

        // 初始化一个元素但不使用，会产生never used警告，可以用@SuppressWarnings镇压警告
        List list = new ArrayList();


        //   注解  的定义形式是  @interface
        /**
         * 所有的注解，都会有 @Target 这个注解，表明当前注解可以使用的地方，比如 类，方法，字段，构造函数，包，甚至注解本身
         * 比如override就只能用在方法上
         *
         * 注解中的字段，就是在使用这个注解是需要定义的参数
         */


        /**
         *
         * 元注解：用于注解其他注解。Java中有4个元注解
         * @Target : 标识当前注解可以用于什么地方
         * @Retention ：表示需要在什么级别保存该注解的注释信息，用于描述注解的生命周期    注解说白了就是注释，如果是SOURce 的话就只在源码上有注释的作用
         *          SOURCE (源代码)   <    CLASS (类)     <    RUNTIME(运行时，默认值)
         *
         * @Document : 把该注解包含在javadoc中
         * @Inherited : 说明子类可以继承父类中的该注解
         *
         *
         *
         */


        /**
         * 自定义注解：
         *
         * public @interface 注解名称 {注解内容}
         * 使用@interface自定义注解时，会自动继承 java.lang.annotation.Annotation接口
         *
         * 注解中的每一个方法实际上是声明了一个配置参数，方法的名称是就是配置参数的名称，方法的返回值就是配置参数的值类型，可以用default给默认值
         *
         * 如果只有一个参数，建议使用value命名
         *
         * java源码中有很多用自定义注解和反射的地方
         *
         * 自定义注解实现分布式事务
         *
         *
         */
    }
}
