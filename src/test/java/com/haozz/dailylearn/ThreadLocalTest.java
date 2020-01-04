package com.haozz.dailylearn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @date 2020/1/4 16:28
 **/
@SpringBootTest
public class ThreadLocalTest {

    private ExecutorService executor = Executors.newFixedThreadPool(3);


    @Test
    public void testExecutorAndThreadLocal() {

        executor.submit(() -> {

            try {
                execute();
                ThreadLocal local = new ThreadLocal();
                System.out.println(local.get());
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            } finally {

            }
        });
    }

    private void execute() {
        ThreadLocal local = new ThreadLocal();
        local.set(9527);
    }

    @Test
    public void testRandom(){

        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
        System.out.println((int) (new Random().nextFloat() * 100));
    }


}
