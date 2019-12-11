package com.haozz.dailylearn.dailylearn_20191210;

import org.springframework.util.StopWatch;


/**
 * @author haozhezhe@yunquna.com
 * @date 13:10 2019/12/11
 */
public class DailyLearn20191210 {

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();

        sw.start("step1:test1");
        sw.stop();


        sw.start("step2:test2");
        sw.stop();


        sw.start("step3:test3");
        sw.stop();


        System.out.println(sw.prettyPrint());
    }
}
