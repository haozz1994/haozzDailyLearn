package com.haozz.dailylearn.dailylearndetail.dailylearn202106.dailylearn_20210604;

/**
 * @author haozhezhe@yunquna.com
 * @date 5:42 PM 6/4/21
 */
public class MustSuccess {

    public static void main(String[] args) {
        // 房屋总数
        int total = 180;

        // 刚需家庭数
        int needTotal = 1000;

        // 普通家庭数
        int normalTotal = 3000;

        // 第一轮摇上概率
        float firstSuccess = (float) (total / 2) / needTotal * 100;

        // 第二轮摇上概率
        float secondSuccess = (float) (total / 2) / (needTotal - (total / 2) + normalTotal) * 100;

        float totalSuccess = firstSuccess + secondSuccess;

        System.out.println("刚需家庭第一轮摇上概率：" + firstSuccess);
        System.out.println("刚需家庭第二轮摇上概率：" + secondSuccess);
        System.out.println("刚需家庭摇上总概率：" + totalSuccess);

        System.out.println("==============================开始模拟摇号========================================");

        for (int i = 1; i <= 100; i++) {
            double tt = Math.random() * 100;
            String result = (tt - totalSuccess < 0) ? "摇上了" : "下次一定";
            System.out.println("第[" + i + "]次模拟摇号，结果是[" + result + "]");
        }
    }
}
