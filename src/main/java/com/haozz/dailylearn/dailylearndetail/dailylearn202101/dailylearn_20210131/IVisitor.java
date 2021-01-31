package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210131;

/**
 * 为顾客提供的接口：
 *
 * @author haozhezhe@yunquna.com
 * @date 12:14 AM 2/1/21
 */
public interface IVisitor {

    /**
     * 接口中提供了四个方法， 让顾客依次选择每种食物。
     * @param lobster
     */

    void chooseLobster(String lobster);

    void chooseWatermelon(String watermelon);

    void chooseSteak(String steak);

    void chooseBanana(String banana);
}
