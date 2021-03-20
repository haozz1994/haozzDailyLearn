package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210316;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author haozhezhe@yunquna.com
 * @date 10:39 PM 3/16/21
 */
public class TestStream {

    public static List<Apple> list = new ArrayList<>();

    static {
        list.add(new Apple(1L, "green", 200));
        list.add(new Apple(2L, "green", 300));
        list.add(new Apple(3L, "blue", 600));
        list.add(new Apple(4L, "red", 570));
        list.add(new Apple(5L, "red", 430));
    }

    public void test(Predicate<? super Apple> predicate) {
        List<Apple> red = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new TestStream().test(i -> i.getColor().equals("red") && i.getWeight() > 200);

        // 根据颜色分组成list
        Map<String, List<Apple>> mapList = list.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(mapList);

        // 根据颜色分组（单个）
//        Map<String, Apple> collect = list.stream().collect(Collectors.toMap(Apple::getColor, x -> x));

        // 根据颜色分组，如果冲突的话怎么解决
        Map<String, Apple> collect1 = list.stream().collect(Collectors.toMap(Apple::getColor, x -> x, (x1, x2) -> x2));
        System.out.println(collect1);


        // 统计各个颜色的平均重量
        // collect里面 groupBY， 第一个参数是分组的key也即是颜色，第二个参数是分组之后做的事，计算平均重量
        Map<String, Double> map = list.stream()
                .collect(Collectors.groupingBy(i -> i.getColor(), Collectors.averagingInt(i -> i.getWeight())));

        System.out.println(map);


        list.stream().sorted(Comparator.comparingInt(t -> t.getColor().length()));


        Random random = new Random();
        random.ints().limit(10).forEach(i -> i = i + 10);


        list.parallelStream().sorted();

        // stream 自带的统计效果
        IntSummaryStatistics summaryStatistics = list.stream().mapToInt(Apple::getWeight).summaryStatistics();
        System.out.println("列表中最大的数 : " + summaryStatistics.getMax());
        System.out.println("列表中最小的数 : " + summaryStatistics.getMin());
        System.out.println("所有数之和 : " + summaryStatistics.getSum());
        System.out.println("平均数 : " + summaryStatistics.getAverage());



        Optional.ofNullable(list).ifPresent( i-> System.out.println(i.size()));

    }
}
