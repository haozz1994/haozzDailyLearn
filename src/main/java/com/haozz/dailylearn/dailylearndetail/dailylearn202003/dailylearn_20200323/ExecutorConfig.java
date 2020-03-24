package com.haozz.dailylearn.dailylearndetail.dailylearn202003.dailylearn_20200323;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author haozhezhe@yunquna.com
 * @date 16:32 2020/3/23
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    @Bean
    public Executor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(30);
        executor.setKeepAliveSeconds(60);
        //配置队列大小
        executor.setQueueCapacity(1000);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("yqn-item-service");
        // 新增定制包装用户请求信息 目前使用方案1
        // 方案1: 直接 setTaskDecorator
        // 方案2: 直接 return new ExceptionHandlingAsyncTaskExecutor(executor);
        executor.setTaskDecorator(runnable -> () -> {
            runnable.run();
        });
        //拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;

    }
}
