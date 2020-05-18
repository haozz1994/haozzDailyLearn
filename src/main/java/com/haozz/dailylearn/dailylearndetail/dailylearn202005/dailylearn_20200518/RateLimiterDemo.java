package com.haozz.dailylearn.dailylearndetail.dailylearn202005.dailylearn_20200518;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author haozhezhe@yunquna.com
 * @date 13:58 2020/5/18
 */
public class RateLimiterDemo {

    /**
     * 令牌桶算法的原理是系统会以一个恒定的速度往桶里放入令牌，而如果请求需要被处理，则需要先从桶里获取一个令牌，当桶里没有令牌可取时，则拒绝服务。 当桶满时，新添加的令牌被丢弃或拒绝。
     *
     *
     * Guava RateLimiter 提供了令牌桶算法可用于平滑突发限流策略。该示例为每秒中产生5个令牌，每200毫秒会产生一个令牌。limiter.acquire() 表示消费一个令牌。当桶中有足够的令牌时，则直接返回0，否则阻塞，直到有可用的令牌数才返回，返回的值为阻塞的时间。
     */

    private static RateLimiter limiter = RateLimiter.create(5);

    public static void exec() {
        limiter.acquire(1);
        try {
            // 处理核心逻辑
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
