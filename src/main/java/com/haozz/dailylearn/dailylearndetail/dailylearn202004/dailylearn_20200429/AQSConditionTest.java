package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200429;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: haozz
 * @date: 2020/4/29 23:39
 */
public class AQSConditionTest {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


        new Thread(() -> {
            lock.lock();

            try {
                System.out.println("begin wait");
                condition.await();
                System.out.println("end wait");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("begin signal");
                condition.signal();
                System.out.println("end signal");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
