package com.haozz.dailylearn.dailylearndetail.dailylearn202007.dailylearn_20200726;

/**
 * @author haozhezhe@yunquna.com
 * @date 14:41 2020-07-26
 */
public class Fobernaci {

    /**
     * 1,1,2,3,5,8,13,21,34
     */
    public static int calculator(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }

        return calculator(i-2) + calculator(i-1);

    }

    public static void main(String[] args) {
        System.out.println(calculator(1));
        System.out.println(calculator(2));
        System.out.println(calculator(3));
        System.out.println(calculator(4));
        System.out.println(calculator(5));
        System.out.println(calculator(6));
        System.out.println(calculator(7));
        System.out.println(calculator(8));
        System.out.println(calculator(9));
    }
}
