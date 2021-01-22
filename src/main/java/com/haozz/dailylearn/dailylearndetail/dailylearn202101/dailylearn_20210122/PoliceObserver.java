package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210122;

/**
 * 警察类，属于观察者
 *
 * @author haozhezhe@yunquna.com
 * @date 11:27 AM 1/22/21
 */
public class PoliceObserver implements Observer {

    public PoliceObserver(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void update(String event) {
        System.out.println("警察[" + name + "]收到消息，罪犯在" + event);
    }
}
