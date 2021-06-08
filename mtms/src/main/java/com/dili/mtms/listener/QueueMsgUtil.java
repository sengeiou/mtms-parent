package com.dili.mtms.listener;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.ss.dto.DTOUtils;
import com.dili.ss.redis.delayqueue.dto.DelayMessage;
import java.time.LocalDateTime;

/**
 * 加入消息到队列
 */
public class QueueMsgUtil {

    /**
     * 组装运输单消息体
     * @return
     */
    public static DelayMessage assemblyTransportMsg(TransportOrderQuey order){
        //发送消息
        DelayMessage delayMessage = DTOUtils.newInstance(DelayMessage.class);
        // 消息topic
        delayMessage.setTopic("invalidTransportOrderTopic");
        delayMessage.setBody(String.valueOf(order.getId()));
        //延时到指定时间点(优先于DelayDuration生效)
        Long validTime = order.getServiceTime().getTime()-System.currentTimeMillis();
        delayMessage.setDelayTime(validTime);
        //当前时间往后延时秒数
        //delayMessage.setDelayDuration(30L);
        //消息发送时间
        delayMessage.setCreateTime(LocalDateTime.now());
        return delayMessage;
    }

    /**
     * 组装装卸单消息体
     * @return
     */
    public static DelayMessage assemblyLoadingMsg(LoadingOrderQuey order){
        //发送消息
        DelayMessage delayMessage = DTOUtils.newInstance(DelayMessage.class);
        // 消息topic
        delayMessage.setTopic("invalidLoadingOrderTopic");
        delayMessage.setBody(String.valueOf(order.getId()));
        //延时到指定时间点(优先于DelayDuration生效)
        Long validTime = order.getServiceTime().getTime()-System.currentTimeMillis();
        delayMessage.setDelayTime(validTime);
        //当前时间往后延时秒数
        //delayMessage.setDelayDuration(30L);
        //消息发送时间
        delayMessage.setCreateTime(LocalDateTime.now());
        return delayMessage;
    }
}
