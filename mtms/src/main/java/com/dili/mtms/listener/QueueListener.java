package com.dili.mtms.listener;

import com.dili.mtms.service.LoadingOrderService;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.redis.delayqueue.annotation.StreamListener;
import com.dili.ss.redis.delayqueue.dto.DelayMessage;
import com.dili.ss.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: WM
 * @time: 2021/6/4 14:18
 */
@Slf4j
@Component
public class QueueListener {

    @Autowired
    TransportOrderService transportOrderService;

    @Autowired
    LoadingOrderService loadingOrderService;

    /**
     * 监听失效运输单
     * @param message
     */
    @StreamListener("invalidTransportOrderTopic")
    public void listenerInvalidTransportOrder(DelayMessage message){
        log.info(DateUtils.format(new Date())+",延时队列接收到消息:"+message.getBody());
        try {
            if(StringUtils.isNotBlank(message.getBody())){
                //如果订单状态为已创建则失效
                int i = transportOrderService.orderFailure(message.getBody());
            }
        }catch (Exception e){
            log.error(DateUtils.format(new Date())+",运输单队列消息消费异常:"+e.getMessage());
        }
    }

    /**
     * 监听失效运输单
     * @param message
     */
    @StreamListener("invalidLoadingOrderTopic")
    public void listenerInvalidLoadingOrder(DelayMessage message){
        log.info(DateUtils.format(new Date())+",延时队列接收到消息:"+message.getBody());
        try {
            if(StringUtils.isNotBlank(message.getBody())){
                //如果订单状态为已创建则失效
                int i = loadingOrderService.orderFailure(message.getBody());
            }
        }catch (Exception e){
            log.error(DateUtils.format(new Date())+",装卸单队列消息消费异常:"+e.getMessage());
        }
    }
}
