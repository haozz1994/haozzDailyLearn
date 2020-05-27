package com.haozz.dailylearn.dailylearndetail.dailylearn202005.dailylearn_20200527;

/**
 * volatile禁止指令重排
 *
 *
 */
public class VolatileTestSort {


    public volatile static int x, y = 0;
    public volatile static int a, b = 0;

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            reSort();
        }
    }

    public static void reSort() throws InterruptedException {

        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1;
                x = b;
            }
        });

        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1;
                y = a;
            }
        });

        aThread.start();
        bThread.start();
        aThread.join();
        bThread.join();

        if (x == 0 && y == 0) {
            System.out.println("(" + x + "," + y + ")");
        }

        x = 0;
        y = 0;
        a = 0;
        b = 0;


    }
}
