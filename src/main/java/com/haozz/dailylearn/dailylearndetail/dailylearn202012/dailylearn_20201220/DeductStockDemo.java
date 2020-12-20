package com.haozz.dailylearn.dailylearndetail.dailylearn202012.dailylearn_20201220;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * 分布式锁
 * <p>
 * 扣减库存
 * https://www.tulingxueyuan.cn/course/video/1023#1023
 *
 * @author haozhezhe@yunquna.com
 * @date 3:33 PM 12/20/20
 */

public class DeductStockDemo {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 示例方法：扣减库存
     * <p>
     * 存在问题：
     * 这段代码是有问题的，会存在超卖现象:
     * 如果两个线程同时执行到了step1，同时拿到当前库存为50，然后同时执行step2进行减1，结果都为49，然后都设置回redis
     * 这样，实际上进行了两次售卖，最终剩余库存应该是48，但是最终库存只减掉了一份，剩余库存是49，就会存在超卖问题
     */
    public void deductStock() {

        // step1: 查找redis中记录的当前库存
        int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));

        if (stock > 0) {
            // step2: 如果当前库存大于0，则将库存-1
            int realStock = stock - 1;

            // step3: 将扣减后的库存设置回redis中
            stringRedisTemplate.opsForValue().set("stock", realStock + "");
            System.out.println("扣减成功，剩余库存" + realStock);
        } else {
            System.out.println("扣减失败，库存不足");
        }

    }


    /**
     * 改进：将step1~step3进行synchronized同步处理，放到一个原子块中，保证同一时间只有一个线程可以执行step1的代码
     * <p>
     * <p>
     * <p>
     * 存在问题：
     * synchronized以及ReentrantLock等在单机环境下有效，但是在集群环境下就无效了，
     * java api级别的同步手段，只能解决同一个jvm进程中的并发问题，无法解决集群下的并发
     * <p>
     * <p>
     * 解决方案：引入分布式锁
     */
    public void deductStock1() {

        synchronized (this) {
            // step1: 查找redis中记录的当前库存
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));

//            stringRedisTemplate.opsForValue().increment("stock", -1);

            if (stock > 0) {
                // step2: 如果当前库存大于0，则将库存-1
                int realStock = stock - 1;

                // step3: 将扣减后的库存设置回redis中
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存" + realStock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        }

    }


    /**
     * 使用分布式锁：
     * <p>
     * stringRedisTemplate.opsForValue().setIfAbsent底层是同步的，相当于jedis.setnx(key, value)
     * <p>
     * stringRedisTemplate.opsForValue().increment("stock", -1)底层应该也是同步的
     */
    public String deductStock2() {

        try {
            /**
             * 这句相当于jedis.setnx(key, value)， 它在redis的底层是单线程的，
             * 如果说此时两个线程（不管是不是集群的）同时走到这句话，在redis的底层也会给他们做一个排队，只有一个线程可以执行成功返回true
             * 相当于这里只有一个线程可以拿到锁
             * 这就是分布式锁的含义
             */
            Boolean lock = stringRedisTemplate.opsForValue().setIfAbsent("lock", "1");

            // 没有获取到锁
            if (!lock) {
                // 类似"服务器繁忙，请稍后再试";
                return "errorCode1001";
            }

            // 同一时间只有一个线程可以拿到lock，继续执行

            // step1: 查找redis中记录的当前库存
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));

//            stringRedisTemplate.opsForValue().increment("stock", -1);

            if (stock > 0) {
                // step2: 如果当前库存大于0，则将库存-1
                int realStock = stock - 1;

                // step3: 将扣减后的库存设置回redis中
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存" + realStock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } finally {
            // finally 中解锁
            // 执行完毕需要释放锁，正确的释放锁，需要校验是不是当前线程持有锁
            stringRedisTemplate.delete("lock");
        }


        return "end";

    }

}
