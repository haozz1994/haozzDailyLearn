package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200401;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleDateFormat线程不安全测试
 * https://blog.csdn.net/zxh87/article/details/19414885
 *
 * 解决方案：
 *      * 1.每个线程内部创建SimpleDateFormat实例。 ×不推荐
 *      * 2.同步SimpleDateFormat对象。  ×不推荐，会降低并发性
 *      * 3.使用其他类库工具。   √推荐
 *      * 4.使用ThreadLocal。   √推荐
 *
 * @author haozhezhe@yunquna.com
 * @date 10:33 2020/4/1
 */
public class SimpleDateFormatTest {

    /**
     * static的变量存在方法区，对象共享，线程共享
     */
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                try {

                    /**
                     * SimpleDateFormat类中的Calendar对象是成员变量，所有线程会共享，会导致并发问题
                     */
                    //ArrayIndexOutOfBoundsException
                    sdf.format(new Date(Math.abs(new Random().nextLong())));

                    //NumberFormatException
                    sdf.parse("20200101-000000");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     *
     *
     */
}
