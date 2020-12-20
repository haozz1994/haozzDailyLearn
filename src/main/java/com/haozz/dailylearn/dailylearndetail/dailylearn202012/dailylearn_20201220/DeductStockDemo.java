package com.haozz.dailylearn.dailylearndetail.dailylearn202012.dailylearn_20201220;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * 分布式锁
 * <p>
 * 扣减库存
 * https://www.tulingxueyuan.cn/course/video/1023#1023
 * @author haozhezhe@yunquna.com
 * @date 3:33 PM 12/20/20
 */

public class DeductStockDemo {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 示例方法：扣减库存
     *
     * 这段代码是有问题的，会存在超卖现象:
     * 如果两个线程同时执行到了step1，同时拿到当前库存为50，然后同时执行step2进行减1，结果都为49，然后都设置回redis
     * 这样，实际上进行了两次售卖，但是最终库存只减掉了一份 ，就会存在超卖问题
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
}
