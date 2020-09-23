package com.haozz.dailylearn.dailylearndetail.dailylearn202009.dailylearn_20200923;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author haozhezhe@yunquna.com
 * @date 16:02 2020-09-23
 */
@Component
@Order(2)
public class TestApplicationRunnerOrder implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(args.getOptionValues("testParam"));

        System.out.println("the application is running  ===  2");
    }
}
