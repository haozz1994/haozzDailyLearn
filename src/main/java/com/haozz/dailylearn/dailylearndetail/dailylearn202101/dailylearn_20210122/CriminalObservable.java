package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210122;

/**
 * 罪犯类，属于被观察者
 *
 * @author haozhezhe@yunquna.com
 * @date 11:30 AM 1/22/21
 */
public class CriminalObservable extends Observable {

    public void crime(String event) {
        System.out.println("罪犯正在" + event);
        notifyObservers(event);
    }
}
