package com.haozz.dailylearn.dailylearndetail.dailylearn202004.dailylearn_20200401;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haozhezhe@yunquna.com
 * @date 17:52 2020/4/1
 */
@RestController
@RequestMapping("/retry")
public class SpringRetryController {

    @Autowired
    private SpringRetryDemo retryDemo;

    @RequestMapping("/demo")
    public void retryDemo() {
        retryDemo.call();
    }
}
