package com.haozz.dailylearn.dailylearndetail.dailylearn202010.dailylearn_20201027;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haozhezhe@yunquna.com
 * @date 21:40 2020-10-27
 */
@Component
public class DemoConsumer extends AbstractConsumer{

    private static final String DEMO_EXCHANGE = "demo_exchange";
    private static final String DEMO_QUEUE = "demo_queue";

    @Autowired
    private DemoManager demoManager;

    public DemoConsumer() {
        super(DEMO_EXCHANGE,
                DEMO_QUEUE,
                "demo_flag");
    }

    @Override
    @RabbitListener(bindings = @QueueBinding(value = @Queue(DEMO_EXCHANGE),
            exchange = @Exchange(DEMO_QUEUE)),
            containerFactory = "demoFactory")
    public void consumer(String msg, Channel channel, Message message) {
        super.initHandle(demoManager::demoHandle);
        process(channel, message);
    }
}
