package com.haozz.dailylearn.dailylearndetail.dailylearn202011.dailylearn_20201129;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author haozhezhe@yunquna.com
 * @date 22:30 2020-11-29
 */
@Component
public class ArthasDemo {


    public static void main(String[] args) throws NoSuchAlgorithmException {


        /**
         * 这种初始化方式，虽然是sonar推荐的，但是在计算随机数的时候，会获取当前服务器的属性，如果获取不到就会阻塞，然后导致jvm阻塞
         *
         * 所以会出现相同的代码，在不同的环境下，有的可以正常运行，有的会报错
         */
        SecureRandom random = SecureRandom.getInstanceStrong();


        /**
         * new的方式初始化   会指定seed = 0
         */
        SecureRandom secureRandom = new SecureRandom();

//        testMethod1();
//
//        int a = 1/0;
//
//        testMethod1();

    }

    public static void testMethod1(){
        System.out.println("method test-1");
    }

    public static void testMethod2(){
        System.out.println("method test-2");
    }

}
