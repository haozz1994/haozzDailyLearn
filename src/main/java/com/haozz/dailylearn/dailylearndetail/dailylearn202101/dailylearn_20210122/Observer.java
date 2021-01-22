package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210122;

/**
 * https://zhuanlan.zhihu.com/p/259864836
 * 观察者模式
 *
 */
/**
 * 观察者接口（警察）
 * @author haozhezhe@yunquna.com
 * @date 11:15 AM 1/22/21
 */
public interface Observer {

    /**
     * 对被观察者发出的事件做出响应
     * @param event
     */
    void update(String event);

}
