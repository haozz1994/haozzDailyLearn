package com.haozz.dailylearn.dailylearn202001.dailylearn_20200104;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/1/4 16:37
 **/
@RestController
@RequestMapping("/test")
public class ExecutorService {

    @Autowired
    private ExecutorManager executorManager;


    @PostMapping("/test")
    public String test(){
        executorManager.test();
        return "YES";
    }
}
