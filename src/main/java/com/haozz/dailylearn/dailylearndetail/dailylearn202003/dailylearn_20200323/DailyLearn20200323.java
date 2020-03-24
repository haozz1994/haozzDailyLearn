package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200323;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haozhezhe@yunquna.com
 * @date 16:32 2020/3/23
 */

@RestController
@RequestMapping("/dailyLearn20200323")
public class DailyLearn20200323 {

    @Autowired
    private Demo demo;

    @RequestMapping("/test")
    public String test(){

        demo.test();

        return "OK";
    }

}
