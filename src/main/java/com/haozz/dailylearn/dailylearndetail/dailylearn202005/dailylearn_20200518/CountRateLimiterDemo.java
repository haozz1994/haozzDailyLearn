package com.haozz.dailylearn.dailylearndetail.dailylearn202005.dailylearn_20200518;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haozhezhe@yunquna.com
 * @date 14:06 2020/5/18
 */
public class CountRateLimiterDemo {

    private static AtomicInteger count = new AtomicInteger(0);

    public static void exec() {
        if (count.get() > 5) {
            System.out.println("请求用户过多，请稍后在试！" + System.currentTimeMillis() / 1000);
        } else {
            count.incrementAndGet();
            try {
                //处理核心逻辑
                TimeUnit.SECONDS.sleep(1);
                System.out.println("--" + System.currentTimeMillis() / 1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                count.decrementAndGet();
            }
        }
    }
}
