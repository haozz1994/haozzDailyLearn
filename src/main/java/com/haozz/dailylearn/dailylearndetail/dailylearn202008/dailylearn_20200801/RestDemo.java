package com.haozz.dailylearn.dailylearndetail.dailylearn202008.dailylearn_20200801;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author haozhezhe@yunquna.com
 * @date 22:51 2020-08-01
 */
public class RestDemo {

    @Autowired
    private RestTemplate restTemplate;

    public void restDemo() {
        String url = "";

        try {
            restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(null, null), String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
