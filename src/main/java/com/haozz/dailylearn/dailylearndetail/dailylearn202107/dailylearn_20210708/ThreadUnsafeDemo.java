package com.haozz.dailylearn.dailylearndetail.dailylearn202107.dailylearn_20210708;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @author haozhezhe@yunquna.com
 * @date 2:08 PM 7/8/21
 */
@Component
public class ThreadUnsafeDemo {

    @Async("asyncServiceExecutor")
    public void ttt(List<UnsafeEntity> list) {
        list.add(UnsafeEntity.builder().id(2).uuid(UUID.randomUUID().toString()).build());
    }
}
