package com.dili.mtms.api;

import com.dili.mtms.common.BaseData;
import com.dili.mtms.common.CfgContent;
import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.mtms.listener.QueueMsgUtil;
import com.dili.mtms.service.LoadingOrderService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.redis.delayqueue.dto.DelayMessage;
import com.dili.ss.redis.delayqueue.impl.DistributedRedisDelayQueueImpl;
import com.dili.uid.sdk.rpc.feign.UidFeignRpc;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 装卸单管理
 */
@RestController
@RequestMapping("/api/loading")
@Slf4j
public class LoadingOrderApi {

    @Autowired
    LoadingOrderService loadingOrderService;

    @Autowired
    UidFeignRpc uidFeignRpc;

    //多实例延时队列
    @Autowired
    DistributedRedisDelayQueueImpl redisDelayQueue;

    /**
     * 买卖端装卸列表
     * @param loadingOrder
     * @return
     * @throws Exception
     */
    @PostMapping(value="/listPage")
    public @ResponseBody BaseOutput loadingList(LoadingOrderQuey loadingOrder) {
        BaseData data = null;
        try {
            data = loadingOrderService.loadingList(loadingOrder);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success().setData(data);
    }

    /**
     * 装卸单详情
     * @param order
     * @return
     */
    @PostMapping(value = "/detail")
    public @ResponseBody BaseOutput loadingDetail(LoadingOrderQuey order) {
        LoadingOrderQuey detailInfo = null;
        try {
            detailInfo = loadingOrderService.loadingDetail(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success().setData(detailInfo);
    }


    /**
     * 新增LoadingOrder
     * @param order
     * @return BaseOutput
     */
    @PostMapping(value="/insert")
    public @ResponseBody BaseOutput insertLoading(@RequestBody LoadingOrderQuey order) {
        try {
            //获取订单号
            BaseOutput<String> bizNumber = uidFeignRpc.getBizNumber(CfgContent.LOADING_NO);
            if (bizNumber.isSuccess()) {
                String number = bizNumber.getData();
                order.setCode(number);
            }else {
                return BaseOutput.failure("获取订单编号失败");
            }
            LoadingOrderQuey return_order = loadingOrderService.insertLoading(order);
            //订单失效处理(redis队列)
            DelayMessage delayMessage = QueueMsgUtil.assemblyLoadingMsg(return_order);
            redisDelayQueue.push(delayMessage);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }

    /**
     * 取消订单
     * @param loadingOrder
     * @return
     */
    @PostMapping(value="/cancel")
    public @ResponseBody BaseOutput loadingCancel(LoadingOrder loadingOrder) {
        try {
            int i = loadingOrderService.loadingCancel(loadingOrder);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }

    /**
     * 确认接单(司机端装卸)
     * @param loadingOrder
     * @return
     */
    @PostMapping(value="/confirmOrder")
    public @ResponseBody BaseOutput confirmLoadingOrder(LoadingOrder loadingOrder) {
        try {
            int i = loadingOrderService.confirmLoadingOrder(loadingOrder);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }

    /**
     * 订单完成
     * @param loadingOrder
     * @return
     */
    @PostMapping(value="/complete")
    public @ResponseBody BaseOutput loadingComplete(LoadingOrder loadingOrder) {
        try {
            int i = loadingOrderService.loadingComplete(loadingOrder);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @PostMapping(value="/delete")
    public @ResponseBody BaseOutput deleteLoadingOrder(Long id) {
        try {
            loadingOrderService.deleteLoadingOrder(id);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }
}