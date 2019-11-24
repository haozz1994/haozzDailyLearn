package com.haozz.dailylearn.dailylearn_20191124;


import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * lambda复习
 *
 * @author
 * @date 2019/11/24 9:46
 **/
public class DailyLearn1124 {

    public static void main(String[] args) {
        //Predicate
        Predicate<String> predicate1 = new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        };

        Predicate<String> predicate2 = (String name) -> {
            return "admin".equals(name);
        };

        Predicate<String> predicate3 = s -> {
            return "admin".equals(s);
        };
        System.out.println(predicate3.test("manager"));


        //Consumer
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("要发送的消息" + s);
                System.out.println("消息发送完成");
            }
        };

        Consumer<String> consumer2 = (String s) -> {
            System.out.println("要发送的消息" + s);
            System.out.println("消息发送完成");
        };
        Consumer<String> consumer3 = s -> {
            System.out.println("要发送的消息" + s);
            System.out.println("消息发送完成");
        };
        consumer3.accept("不要回答！不要回答！不要回答！");


        //Function
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Objects.equals(s, "super") ? 1 : -1;
            }
        };

        Function<String, Integer> function2 = (String s) -> {
            return Objects.equals(s, "super") ? 1 : -1;
        };

        Function<String, Integer> function3 = s ->
                Objects.equals(s, "super") ? 1 : -1;
        System.out.println(function3.apply("super"));

        //Supplier
        Supplier<String> sup = () -> UUID.randomUUID().toString();
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());

    }

    /**
     * java.util.function包下提供了大量的函数式接口
     * Predicate 接收参数T，返回boolean
     * Consumer 接收参数T，没有返回值
     * Function 接收参数T，返回R
     * Supplier 不接受参数，get()获取指定类型的对象
     *
     */

    /**
     *
     * lambda基本语法
     * [接口声明] = (参数) -> {执行代码块};
     *
     */



}
