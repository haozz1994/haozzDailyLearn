package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200324;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 通过反射获取类中所有方法
 *
 * @author: haozz
 * @date: 2020/3/24 23:28
 */
public class ReflectDemo {

    public void methodA() {

    }

    private void methodB() {

    }

    public static void main(String[] args) {

        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;

        //方案一：获取当前类及其父类所有的公有方法
        Method[] methods = reflectDemoClass.getMethods();
        Arrays.asList(methods).forEach(method -> System.out.println(method.getName()));

        System.out.println("==============================");

        //方案二：获取当前类中所有的方法
        Method[] declaredMethods = reflectDemoClass.getDeclaredMethods();
        Arrays.asList(declaredMethods).forEach(declaredMethod -> System.out.println(declaredMethod.getName()));

    }

}
