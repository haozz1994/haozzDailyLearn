package com.haozz.dailylearn.dailylearndetail.dailylearn202010.dailylearn_20201027;

import com.rabbitmq.client.Channel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.Message;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author haozhezhe@yunquna.com
 * @date 21:31 2020-10-27
 */
public abstract class AbstractConsumer {

    @Setter
    private String exchangeName;
    @Setter
    @Getter
    private String queueName;
    @Setter
    private String operationFlag;

    private Consumer<String> handler;

    public AbstractConsumer(String exchangeName, String queueName, String operationFlag) {
        this.exchangeName = exchangeName;
        this.queueName = queueName;
        this.operationFlag = operationFlag;
    }

    public AbstractConsumer(){

    }

    public abstract void consumer(@Payload String msg, Channel channel, Message message);

    protected void initHandle(Consumer<String> handle) {
        this.handler = handle;
    }


    /**
     * 子类必须调用此方法进行消息处理
     */
    protected void process(Channel channel, Message message) {
        long start = System.currentTimeMillis();
        this.check();
        Throwable throwable = null;
        String msg = new String(message.getBody());
        try {
//            Request.Header header = RequestHeaderContext.getHeaderContext();
//            if(null == header){
//                header = TraceIdUtil.buildRequestHeader();
//            }
//            RequestHeaderContext.setHeaderContext(header);
            this.handler.accept(msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            throwable = e;
//            if(SettleCodeEnum.isCommonRetryError(e)){
//                Loggers.BIZ.warn(this.getClass().getName(),
//                        operationFlag,
//                        String.format("exchangeName:%s,queueName:%s",exchangeName,queueName),
//                        msg,
//                        e);
//             log
//            }else{
               // log
//            }

            try {
                Thread.sleep(this.expSleepTime());
            } catch (InterruptedException e1) {
                // log
            }
            try {
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            } catch (IOException e1) {
                // log
            }
        } finally {
            // log
            // ThreadLocal.clear();
        }
    }


    /**
     * 默认的异常睡眠时间 5s
     * @return  long
     */
    protected long expSleepTime(){
        return 5000;
    }


    private void check() {
        if (operationFlag == null) {
            // throw Exception;
        }

        if (exchangeName == null) {
            // throw Exception;
        }

        if (queueName == null) {
            // throw Exception;
        }


        if (handler == null) {
            // throw Exception;
        }
    }

}
