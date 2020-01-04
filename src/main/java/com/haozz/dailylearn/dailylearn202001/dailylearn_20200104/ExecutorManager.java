package com.haozz.dailylearn.dailylearn202001.dailylearn_20200104;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @date 2020/1/4 16:44
 **/
@Component
public class ExecutorManager {

    private ExecutorService executor = Executors.newFixedThreadPool(3);

    public void test() {
        executor.submit(() -> {
            try {
                execute();
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            } finally {

                //此处，线程执行完后需要进行ThreadLocal的清楚，否则线程池中线程复用，会拿到其他线程的ThreadLocal的值
            }
        });
    }

    private void execute() {
        System.out.println(ThreadLocalHolder.getCurrentFlag());

        //do something...

        int random = (int) (new Random().nextFloat() * 100);

        //如果当前线程的flag为null，说明这个线程没有被复用过，就给它的ThreadLocal中设置值
        if (Objects.isNull(ThreadLocalHolder.getCurrentFlag())) {
            ThreadLocalHolder.setFlag(random);
        }


        //每次项目启动，第一个线程进来，ThreadLocal里必为null，后面开始每个线程会设置一个随机值
        //多次调用，根据打印的ThreadLocal值可以发现，线程的复用是轮询的


        //ThreadLocal的使用都用于session存储，参考https://www.cnblogs.com/yxysuanfa/p/7125761.html
    }

}
