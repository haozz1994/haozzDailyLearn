package com.haozz.dailylearn.dailylearn_20191124;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author
 * @date 2019/11/24 14:44
 **/
public class App3 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("luffy");
        list.add("zoro");
        list.add("nami");
        list.add("sanji");
        list.add("robin");
        list.add("chopper");

        //map遍历时，不要使用keySet，要使用entrySet

        //peek时中间操作， 迭代数据完成数据的依次处理过程，应用还要再查查
        list.stream()
                .peek(x -> System.out.println("peek 1:" + x))
                .peek(x -> System.out.println("aaa peek 2:" + x))
                .forEach(System.out::println);


        //stream中各个方法的使用
        //reduce() 合并处理数据 这里list如果是int型 就是求和操作
        Optional optional = list.stream().reduce((sum, x) -> sum + " " + x);
        System.out.println(optional.get());
    }

}
