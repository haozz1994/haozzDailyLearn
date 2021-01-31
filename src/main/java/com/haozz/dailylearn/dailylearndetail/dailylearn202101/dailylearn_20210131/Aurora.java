package com.haozz.dailylearn.dailylearndetail.dailylearn202101.dailylearn_20210131;

/**
 * 顾客如果想要访问餐厅选择自己喜欢的食物，只需要实现 IVisitor 接口即可。
 * Aurora 喜欢吃龙虾和西瓜
 *
 * @author haozhezhe@yunquna.com
 * @date 12:18 AM 2/1/21
 */
public class Aurora implements IVisitor {
    @Override
    public void chooseLobster(String lobster) {
        System.out.println("Aurora gets a " + lobster);
    }

    @Override
    public void chooseWatermelon(String watermelon) {
        System.out.println("Aurora gets a " + watermelon);
    }

    @Override
    public void chooseSteak(String steak) {
        System.out.println("Aurora doesn't like " + steak);
    }

    @Override
    public void chooseBanana(String banana) {
        System.out.println("Aurora doesn't like " + banana);
    }


    /**
     * 客户端测试
     * @param args
     */
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        IVisitor Aurora = new Aurora();
        restaurant.welcome(Aurora);
    }
}
