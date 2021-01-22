package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210122;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者基类（张三）
 *
 * @author haozhezhe@yunquna.com
 * @date 11:20 AM 1/22/21
 */
public class Observable {

    /**
     * 观察者列表
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * 将 observer 对象添加到观察者列表中
     *
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * 将 observer 对象从观察者列表中移除
     *
     * @param observer
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有观察者有事件发生，具体实现是调用所有观察者的 update 方法
     *
     * @param event
     */
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
