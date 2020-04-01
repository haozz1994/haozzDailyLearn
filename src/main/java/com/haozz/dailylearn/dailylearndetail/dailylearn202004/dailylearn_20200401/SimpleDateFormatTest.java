package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200401;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haozhezhe@yunquna.com
 * @date 10:33 2020/4/1
 */
public class SimpleDateFormatTest {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            executorService.execute(() -> {
                try {

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
}
