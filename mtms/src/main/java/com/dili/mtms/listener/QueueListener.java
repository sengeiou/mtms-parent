package com.dili.mtms.listener;

import com.dili.ss.redis.delayqueue.annotation.StreamListener;
import com.dili.ss.redis.delayqueue.dto.DelayMessage;
import com.dili.ss.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: WM
 * @time: 2021/6/4 14:18
 */
@Slf4j
@Component
public class QueueListener {

    /**
     * 监听失效运输单
     * @param message
     */
    @StreamListener("invalidTransportOrderTopic")
    public void listenerInvalidTransportOrder(DelayMessage message){
        log.info(DateUtils.format(new Date())+",延时队列接收到消息:"+message.getBody());
    }

    /**
     * 监听失效运输单
     * @param message
     */
    @StreamListener("invalidLoadingOrderTopic")
    public void listenerInvalidLoadingOrder(DelayMessage message){
        log.info(DateUtils.format(new Date())+",延时队列接收到消息:"+message.getBody());
    }

    /*//发送消息
        DelayMessage delayMessage = DTOUtils.newInstance(DelayMessage.class);
// 消息topic
        delayMessage.setTopic("invalidTransportOrderTopic");
        delayMessage.setBody("消息内容JSON");
//延时到指定时间点(优先于DelayDuration生效)
        delayMessage.setDelayTime(System.currentTimeMillis()+5000L);
//当前时间往后延时秒数
//        delayMessage.setDelayDuration(30L);
//消息发送时间
        delayMessage.setCreateTime(LocalDateTime.now());
//向延时队列投递消息
        redisDelayQueue.push(delayMessage);*/
}
