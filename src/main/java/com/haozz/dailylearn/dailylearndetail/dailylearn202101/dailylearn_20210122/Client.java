package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210122;

/**
 * @author haozhezhe@yunquna.com
 * @date 11:37 AM 1/22/21
 */
public class Client {

    public static void main(String[] args) {
        CriminalObservable zhangSan = new CriminalObservable();
        PoliceObserver police1 = new PoliceObserver("罗翔老师");
        PoliceObserver police2 = new PoliceObserver("AAA");
        PoliceObserver police3 = new PoliceObserver("BBB");
        zhangSan.addObserver(police1);
        zhangSan.addObserver(police2);
        zhangSan.addObserver(police3);
        zhangSan.crime("放狗咬人");
    }
}
