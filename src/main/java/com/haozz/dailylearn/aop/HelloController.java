package com.haozz.dailylearn.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: haozz
 * @date: 2020/1/14 22:06
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/say")
    public String sayHello(@RequestParam String name) {
        return "hello: " + name;
    }

}
