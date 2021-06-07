package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210322;

import cn.hutool.core.collection.CollectionUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.util.function.Tuple2;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author haozhezhe@yunquna.com
 * @date 3:29 PM 3/22/21
 */
public class RedissonDemo {

    /**
     * redisson分布式锁demo
     */

    /**
     * 引入mvn
     *        <dependency>
     *             <groupId>org.redisson</groupId>
     *             <artifactId>redisson-spring-boot-starter</artifactId>
     *             <version>3.10.6</version>
     *         </dependency>
     */

    /**
     * @see DeductStockDemo
     */

    @Autowired
    private RedissonClient redissonClient;

    public final static String KEY_PROFIX = "lock_";

    public void onShelf(List<Product> products) {

        Tuple2<Set<String>, Set<String>> tuple2 = lock(products.stream().map(Product::getBusinessKey).collect(Collectors.toSet()));

        // 这个地方还应该判断 ，如果全部失败了 ，说明这个时候其他的操作量比较大，可以等待1秒后继续


        // 成功的部分，执行上架处理，并且在finally中释放锁
        try {
            onShelf(tuple2.getT1());
        } catch (Exception e) {

        } finally {
            unLock(tuple2.getT1());
        }


        if (CollectionUtil.isNotEmpty(tuple2.getT2())) {
            // 失败的部分 递归进行
            List<Product> collect = products.stream().filter(i -> tuple2.getT2().stream().anyMatch(y -> Objects.equals(i.getBusinessKey(), y))).collect(Collectors.toList());
            onShelf(collect);
        }


    }

    /**
     * 商品批量上架
     * <p>
     * 在上架的过程中不允许对商品做其他操作，比如调整价格之类, 所以对商品加分布式锁
     */
    public Tuple2<Set<String>, Set<String>> lock(Set<String> businessKeys) {


        Set<String> successSet = new HashSet<>();
        Set<String> failSet = new HashSet<>();

        // 遍历处理
        for (String s : businessKeys) {

            // 对每个商品加锁
            String lockKey = KEY_PROFIX + s;

            // 获取锁对象，此时还没有加锁
            RLock lock = redissonClient.getLock(lockKey);

            try {
                /**
                 * 1. 商品批量获取锁等待时间 单位秒 ，0为不等待，及时返回获取锁的结果
                 * 2. 商品批量加锁时，单个商品超时解锁时间 单位秒
                 * 3. 时间单位
                 */

                boolean isLock = lock.tryLock(0, 60, TimeUnit.SECONDS);

                if (isLock) {
                    // 获取到锁
                    successSet.add(s);
                } else {
                    //  未获取到锁
                    failSet.add(s);
                }

            } catch (Exception e) {

            }
        }

//        return new Tuple2<>(successSet, failSet);
        //Error:(112, 16) java: <T1,T2>Tuple2(T1,T2)在reactor.util.function.Tuple2中不是公共的; 无法从外部程序包中对其进行访问
        return null;
    }

    public void onShelf(Set<String> businessKeys) {
        // todo 执行下架操作
    }

    public void unLock(Set<String> businessKeys) {
        for (String businessKey : businessKeys) {

            String key = KEY_PROFIX + businessKey;
            RLock lock = redissonClient.getLock(key);
            // 释放锁之前，要校验这个锁是不是存在 并且 是上锁状态 并且 是被当前线程持有
            if (lock != null && lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }

        }
    }


}
