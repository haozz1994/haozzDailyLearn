package com.haozz.dailylearn.dailylearndetail.dailylearn202005.dailylearn_20200507;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: haozz
 * @date: 2020/5/7 23:39
 */
public class JoinCountDownLatch2 {


    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("child threadOne over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("child threadTwo over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        System.out.println("wait all child thread over!");

        countDownLatch.await();

        System.out.println("all child thread over!");

        executorService.shutdown();
    }
}
