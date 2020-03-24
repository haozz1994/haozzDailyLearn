package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200323;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author haozhezhe@yunquna.com
 * @date 16:35 2020/3/23
 */
@Component
public class Demo {

    @Async("asyncServiceExecutor")
    public void test(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("123");
    }
}
