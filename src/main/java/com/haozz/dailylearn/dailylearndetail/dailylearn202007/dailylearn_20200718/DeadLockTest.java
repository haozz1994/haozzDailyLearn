package com.haozz.dailylearn.dailylearndetail.dailylearn202007.dailylearn_20200718;

/**
 * @author haozhezhe@yunquna.com
 * @date 14:54 2020-07-18
 */
public class DeadLockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    /**
     * 死锁产生之后，可以在jstack PID中看到提示
     * 并且 jvisualvm也可以看到
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    System.out.println("thread1 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                synchronized (lock2) {
                    System.out.println("thread1 end");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                try {
                    System.out.println("thread2 begin");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                synchronized (lock1) {
                    System.out.println("thread2 end");
                }
            }
        }).start();

        System.out.println("main thread end");
    }
}
