package com.haozz.dailylearn.dailylearndetail.dailylearn202107.dailylearn_20210708;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author haozhezhe@yunquna.com
 * @date 2:07 PM 7/8/21
 */
public class ThreadUnsafeTest {

    @Autowired
    private ThreadUnsafeDemo demo;

    public void test() throws InterruptedException {
        List<UnsafeEntity> list = new ArrayList<>();

        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            try {
                demo.ttt(list);

            } catch (Exception e) {
                System.out.println(JSON.toJSONString(e));
            } finally {
                countDownLatch.countDown();
            }
        }

        countDownLatch.await();
        System.out.println(JSON.toJSONString(list));


    }
}
