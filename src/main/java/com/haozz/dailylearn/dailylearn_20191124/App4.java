package com.haozz.dailylearn.dailylearn_20191124;

import java.util.*;

/**
 * lambda表达式性能测试
 *
 * @author
 * @date 2019/11/24 15:13
 **/
public class App4 {

    public static void main(String[] args) {

        Random random = new Random();

        //1.基本数据类型：整数
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            integerList.add(random.nextInt(Integer.MAX_VALUE));
        }

        // 1)stream
        testStream(integerList);// 207ms
        // 2)parallelStream
        testParallelStream(integerList); //43ms
        // 3)普通for
        testForLoop(integerList);//30ms
        // 4)增强for
        testStrongForLoop(integerList);//41ms
        // 5)iterator
        testIterator(integerList);//25ms

        //结论：并行流和迭代器的处理速度差不太多了，但是串行流在处理基本数据时还是比较慢的
        System.out.println("=============================================================================================");

        // 2.复杂数据类型：对象
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            productList.add(new Product("pro" + i, i, random.nextInt(Integer.MAX_VALUE)));
        }

        // 1)stream
        testProductStream(productList);// 48ms
        // 2)parallelStream
        testProductParallelStream(productList); //27ms
        // 3)普通for
        testProductForLoop(productList);//34ms
        // 4)增强for
        testProductStrongForLoop(productList);//48ms
        // 5)iterator
        testProductInerator(productList);//47ms

        //结论：并行流的速度已经非常接近甚至超过普通迭代


    }

    public static void testStream(List<Integer> list) {
        long start = System.currentTimeMillis();
        Optional<Integer> max = list.stream().max(Integer::compare);
        System.out.println(max.get());
        long end = System.currentTimeMillis();
        System.out.println("testStream消耗时间：" + (end - start));
    }

    public static void testParallelStream(List<Integer> list) {
        long start = System.currentTimeMillis();
        Optional<Integer> max = list.parallelStream().max(Integer::compare);
        System.out.println(max.get());
        long end = System.currentTimeMillis();
        System.out.println("testParallelStream消耗时间：" + (end - start));
    }

    public static void testForLoop(List<Integer> list) {
        long start = System.currentTimeMillis();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println(max);
        long end = System.currentTimeMillis();
        System.out.println("testForLoop消耗时间：" + (end - start));
    }

    public static void testStrongForLoop(List<Integer> list) {
        long start = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
        }
        System.out.println(max);
        long end = System.currentTimeMillis();
        System.out.println("testStrongForLoop消耗时间：" + (end - start));
    }

    public static void testIterator(List<Integer> list) {
        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        int max = iterator.next();
        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (cur > max) {
                cur = max;
            }
        }
        System.out.println(max);
        long end = System.currentTimeMillis();
        System.out.println("testIterator消耗时间：" + (end - start));
    }


    public static void testProductStream(List<Product> list) {
        long start = System.currentTimeMillis();

        Optional<Product> max = list.stream().max(Comparator.comparingInt(p -> p.hot));
        System.out.println(max.get());

        long end = System.currentTimeMillis();
        System.out.println("testProductStream消耗时间：" + (end - start));
    }

    public static void testProductParallelStream(List<Product> list) {
        long start = System.currentTimeMillis();

        Optional<Product> max = list.parallelStream().max(Comparator.comparingInt(p -> p.hot));
        System.out.println(max.get());

        long end = System.currentTimeMillis();
        System.out.println("testProductParallelStream消耗时间：" + (end - start));
    }

    public static void testProductForLoop(List<Product> list) {
        long start = System.currentTimeMillis();
        Product max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).hot > max.hot) {
                max = list.get(i);
            }
        }
        System.out.println(max);

        long end = System.currentTimeMillis();
        System.out.println("testProductForLoop消耗时间：" + (end - start));
    }

    public static void testProductStrongForLoop(List<Product> list) {
        long start = System.currentTimeMillis();

        Product max = list.get(0);
        for (Product product : list) {
            if (product.hot > max.hot) {
                max = product;
            }
        }

        System.out.println(max);

        long end = System.currentTimeMillis();
        System.out.println("testProductStrongForLoop消耗时间：" + (end - start));
    }

    public static void testProductInerator(List<Product> list) {
        long start = System.currentTimeMillis();

        Iterator<Product> iterator = list.iterator();
        Product max = iterator.next();

        while (iterator.hasNext()) {
            Product cur = iterator.next();
            if (cur.hot > max.hot) {
                max = cur;
            }
        }

        System.out.println(max);

        long end = System.currentTimeMillis();
        System.out.println("testProductInerator消耗时间：" + (end - start));
    }
}

class Product {
    String name;   //名称
    Integer stock; //库存
    Integer hot;   //热度

    public Product(String name, Integer stock, Integer hot) {
        this.name = name;
        this.stock = stock;
        this.hot = hot;
    }
}
