package com.haozz.dailylearn.dailylearndetail.dailylearn202005.dailylearn_20200518;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author haozhezhe@yunquna.com
 * @date 13:58 2020/5/18
 */
public class RateLimiterDemo {

    private static RateLimiter limiter = RateLimiter.create(5);

    public static void exec() {
        limiter.acquire(1);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
