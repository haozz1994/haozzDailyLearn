package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200401;

import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * spring的重试机制
 * https://blog.csdn.net/qq_20989105/article/details/80003087
 *
 * @author haozhezhe@yunquna.com
 * @date 17:43 2020/4/1
 */
@Component
@EnableRetry
public class SpringRetryDemo {

    /**
     * @Retryable注解
     * 被注解的方法发生异常时会重试
     * value:指定发生的异常进行重试
     * include:和value一样，默认空，当exclude也为空时，所有异常都重试
     * exclude:指定异常不重试，默认空，当include也为空时，所有异常都重试
     * maxAttemps:重试次数，默认3
     * backoff:重试补偿机制，默认没有
     */

    /**
     * 1.引入相关jar包
     * 2.在启动类或使用retry的service上添加@EnableRetry注解
     */


    /**
     * 这个 maxAttempts 重试次数，是指加上第一次执行的次数，也就是设置为2的话，第一次执行抓到异常了，后面会再重试1次。
     * maxAttempts默认为3
     */
    @Retryable(value = Exception.class, maxAttempts = 2)
    public void call() {
        System.out.println("do anything...");
        throw new NullPointerException();
    }
}
