package com.haozz.dailylearn.dailylearndetail.dailylearn202007.dailylearn_20200704;

public class AllotOnStack {

    /**
     * 测试栈上分配
     * @param args
     */

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("zhuge");
    }


}
