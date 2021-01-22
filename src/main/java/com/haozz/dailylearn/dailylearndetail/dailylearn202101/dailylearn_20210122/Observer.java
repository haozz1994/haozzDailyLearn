package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210122;

/**
 * https://zhuanlan.zhihu.com/p/259864836
 * 观察者模式
 *
 * 观察者 对 被观察者 的行为作出响应
 * 观察者模式的思想就是一个对象发生一个事件后，逐一通知监听着这个对象的监听者，监听者可以对这个事件马上做出响应。
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
