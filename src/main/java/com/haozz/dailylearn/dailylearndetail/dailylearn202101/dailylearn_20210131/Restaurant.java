package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210131;

/**
 * 访问者模式
 * https://zhuanlan.zhihu.com/p/259864836
 *
 * 许多设计模式的书中都说访问者模式是最复杂的设计模式，实际上只要我们对它抽丝剥茧，就会发现访问者模式的核心思想并不复杂。
 *
 * 以我们去吃自助餐为例，每个人喜欢的食物是不一样的，比如 Aurora 喜欢吃龙虾和西瓜，Kevin 喜欢吃牛排和香蕉，餐厅不可能单独为某一位顾客专门准备食物。所以餐厅的做法是将所有的食物都准备好，顾客按照需求自由取用。此时，顾客和餐厅之间就形成了一种访问者与被访问者的关系。
 *
 * 准备好各种食物的餐厅：
 * @author haozhezhe@yunquna.com
 * @date 12:11 AM 2/1/21
 */
public class Restaurant {


    /**
     * 在餐厅类中，我们提供了四种食物：龙虾、西瓜、牛排、香蕉。
     */
    private String lobster = "lobster";
    private String watermelon = "watermelon";
    private String steak = "steak";
    private String banana = "banana";


    /**
     * 在餐厅中提供接收访问者的方法：
     */
    public void welcome(IVisitor vistor){
        vistor.chooseLobster(lobster);
        vistor.chooseWatermelon(watermelon);
        vistor.chooseSteak(steak);
        vistor.chooseBanana(banana);
    }


}
