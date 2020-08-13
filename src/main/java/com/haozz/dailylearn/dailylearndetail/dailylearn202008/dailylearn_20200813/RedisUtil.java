package com.haozz.dailylearn.dailylearndetail.dailylearn202008.dailylearn_20200813;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: haozhezhe@yunquna.com
 * @Description:
 * @Date: Created in 20:50 2019/5/14
 * @Modified:
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 计数器
     *
     * @param key
     * @return
     */
    public long setValueIncr(String key) {
        return stringRedisTemplate.opsForValue().increment(key, 1);
    }

    /**
     * 计数器
     *
     * @param key
     * @param value
     * @return
     */
    public long setValueIncr(String key, long value) {
        return stringRedisTemplate.opsForValue().increment(key, value);
    }

    /**
     * 写入值
     *
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 读取值
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 写入集合
     *
     * @param key
     * @param list
     */
    public void setValue(String key, List<?> list) {
        stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(list));
    }

    /**
     * 读取集合
     *
     * @param key
     * @return
     */
    public List<?> getValueList(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if (StringUtil.isNullOrWhiteSpace(value)) {
            return new ArrayList<>();
        }
        return JSON.parseObject(value, ArrayList.class);
    }

    /**
     * 从左边开始写入列表
     *
     * @param key
     * @param value
     */
    public void setListLeft(String key, Object value) {
        stringRedisTemplate.opsForList().leftPush(key, JSON.toJSONString(value));
    }

    /**
     * 从右边开始写入列表
     *
     * @param key
     * @param value
     */
    public void setListRight(String key, Object value) {
        stringRedisTemplate.opsForList().rightPush(key, JSON.toJSONString(value));
    }

    /**
     * 获取集合数据
     *
     * @param key
     * @return
     */
    public List<?> getList(String key) {
        return stringRedisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 从左边读取，然后删除取出来的值
     *
     * @param key
     * @return
     */
    public String getListLeft(String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    /**
     * 从右边读取，然后删除取出来的值
     *
     * @param key
     * @return
     */
    public String getListRight(String key) {
        return stringRedisTemplate.opsForList().rightPop(key);
    }

    /**
     * 设置过期
     *
     * @param key
     * @param timeout
     * @param unit
     */
    public void setExpire(String key, final long timeout, final TimeUnit unit) {
        stringRedisTemplate.expire(key, timeout, unit);
    }
}
