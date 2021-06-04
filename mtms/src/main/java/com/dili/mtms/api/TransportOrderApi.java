package com.dili.mtms.api;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.service.TransportOrderItemService;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.dto.DTOUtils;
import com.dili.ss.redis.delayqueue.dto.DelayMessage;
import com.dili.ss.redis.delayqueue.impl.DistributedRedisDelayQueueImpl;
import com.dili.uid.sdk.rpc.feign.UidFeignRpc;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 运输单管理
 */
@RestController
@RequestMapping("/api/transport")
@Slf4j
public class TransportOrderApi {

    @Autowired
    TransportOrderService transportOrderService;

    @Autowired
    UidFeignRpc uidFeignRpc;

    //多实例延时队列
    @Autowired
    DistributedRedisDelayQueueImpl redisDelayQueue;

    /**
     * 买卖端运输单列表
     *
     * @param order
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/listPage")
    public @ResponseBody
    BaseOutput transportList(TransportOrder order) throws Exception {
        //发送消息
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
        redisDelayQueue.push(delayMessage);

        BaseData data = null;
        try {
            data = transportOrderService.transportList(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(data);
    }

    /**
     * 买卖端发布运输单
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/insert")
    public @ResponseBody
    BaseOutput insertTransport(@RequestBody TransportOrderQuey order) {
        //BaseOutput baseOutput = new BaseOutput();
        try {
            //获取订单号
            /*BaseOutput<String> bizNumber = uidFeignRpc.getBizNumber("");
            if (!bizNumber.isSuccess()) {
                String number = bizNumber.getData();
            }*/
            int i = transportOrderService.insertTransport(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success();
    }

    /**
     * 订单详情
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/detail")
    public @ResponseBody
    BaseOutput transportDetail(TransportOrderQuey order) {
        TransportOrderQuey detailInfo = null;
        try {
            detailInfo = transportOrderService.transportDetail(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(detailInfo);
    }

    /**
     * 取消订单
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/cancel")
    public @ResponseBody BaseOutput transportCancel(TransportOrder order) {
        try {
            transportOrderService.updateSelective(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success();
    }

    /**
     * 确认接单
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/confirmOrder")
    public @ResponseBody
    BaseOutput confirmOrder(TransportOrder order) {
        try {
            transportOrderService.updateSelective(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success();
    }

    /**
     * 订单完成（确认收获）
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/complete")
    public @ResponseBody
    BaseOutput complete(TransportOrder order) {
        try {
            transportOrderService.updateSelective(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success();
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/delete")
    public @ResponseBody
    BaseOutput deleteTransporOrder(Long id) {
        try {
            transportOrderService.deleteTransporOrder(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success();
    }
}
