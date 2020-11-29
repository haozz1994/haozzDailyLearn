package com.haozz.dailylearn.dailylearndetail.dailylearn202011.dailylearn20201129;

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


        SecureRandom random = SecureRandom.getInstanceStrong();

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
