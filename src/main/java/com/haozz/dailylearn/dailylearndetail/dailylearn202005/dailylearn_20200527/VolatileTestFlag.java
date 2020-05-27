package com.haozz.dailylearn.dailylearndetail.dailylearn202005.dailylearn_20200527;

public class VolatileTestFlag {


    public static boolean FLAG = true;

    public static void main(String[] args) {

        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("A线程等待！");
                while (FLAG) {
                    /**
                     * FLAG不加volatile的情况下，aThread会在这里死循环，因为bThread修改了FLAG的值之后，并不满足线程之间可见性原则，不会立即刷回主内存，aThread不会进行总线嗅探
                     */
                    /**
                     * 但是问题在于，就算不加volatile，只是在这里加上下面这行代码，什么也不做，只是打印空字符串，aThread也是会拿到新的FLAG的值的，百思不得其解
                     */
                    System.out.print("");

                }

                System.out.println("A线程等待结束。。。");
            }
        });

        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    changeFlag();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        aThread.start();
        bThread.start();

    }

    public static void changeFlag() {
        System.out.println("B线程改值");
        FLAG = false;
    }

}
