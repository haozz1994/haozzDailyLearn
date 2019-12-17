package com.haozz.dailylearn.dailylearn201911.dailylearn_20191130;

import java.util.List;

/**
 * 极客时间：Java并发变成实战第一部分第六讲：https://time.geekbang.org/column/article/85241
 *
 * @author
 * @date 2019/11/30 16:28
 **/

/**
 * 1.对于从来没有获得过互斥锁的线程 所在的等待队列 和 因为wait() 释放锁而进入了等待队列，是否是同一个等待队列？
 *         -- 不是一个队列
 *         -- 这里，“从来没有获得过互斥锁的线程”是EntrySet，"因为wait() 释放锁而进入了等待队列"是WaitSet，可以参考https://www.cnblogs.com/tiancai/p/9371655.html
 *
 * 2.notifyAll() 会发通知给等待队列中所有的线程吗？包括那些从未获得过互斥锁的线程吗？
 *         -- 只唤醒因为wait() 释放锁而进入了等待队列的线程（WaitSet），不会唤醒从来没有获得过互斥锁的线程（EntrySet）
 *
 * 3.因为wait()被阻塞，而又因为notify()重新被唤醒后，代码是接着在wait()之后执行，还是重新执行 apply 方法？
 *         -- wait之后
 *
 *
 *
 */

class Allocator {
    private List<Object> als;

    // 一次性申请所有资源
    //这里我的理解是，Allocator是单例的，所有线程共享一个als，也就是如果als中已经有了from或者to，就证明别的线程获取到过其中一个资源
    //所以这里进入apply方法的时候进行判断，只要from和to有一个在als中了，就需要wait释放锁，也就是说，进入apply方法的时候，如果als中是空的，才算满足条件，那就一次性获取from和to
    synchronized void apply(
            Object from, Object to) {
        // 经典写法
        while (als.contains(from) ||
                als.contains(to)) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        als.add(from);
        als.add(to);
    }

    // 归还资源
    synchronized void free(
            Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }


    public static void main(String[] args) {
        System.out.println(true | false);
    }
}
