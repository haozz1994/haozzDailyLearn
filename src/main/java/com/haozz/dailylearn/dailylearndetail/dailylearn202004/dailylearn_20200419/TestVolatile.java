package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200419;

/**
 * @author: haozz
 * @date: 2020/4/19 21:33
 */
public class TestVolatile {

    public static class ReadThread extends Thread {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (ready) { // 1
                    System.out.println(num + num); // 2
                }
                System.out.println("read thread...");
            }
        }

    }

    public static class WriteThread extends Thread {
        @Override
        public void run() {
            num = 2; // 3
            ready = true; //4
            System.out.println("write thread set over...");
        }

    }

    private static int num = 0;
//    private static boolean ready = false;
    private static volatile boolean ready = false;


    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        WriteThread wt = new WriteThread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit...");

    }

    /**
     * 在不考虑内存可见性问题的情况下，是否一定输出4？   不一定
     *
     * 指令重排序造成的影响：
     * 由于代码1234件不存在依赖关系，所以writeThread的代码3、4可能被重排序为先执行4再执行3，那么执行4后readThread可能已经执行了1操作，并且在3执行前开始执行2操作，这时候输出结果为0而不是4
     *
     *
     * 使用volatile修饰ready变量，就可以避免重排序和内存可见性问题
     *
     *
     *
     */

}
