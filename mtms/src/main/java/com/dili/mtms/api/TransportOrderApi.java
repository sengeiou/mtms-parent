package com.dili.mtms.api;

import com.dili.customer.sdk.domain.dto.CustomerExtendDto;
import com.dili.customer.sdk.rpc.CustomerRpc;
import com.dili.mtms.common.BaseData;
import com.dili.mtms.common.CfgContent;
import com.dili.mtms.domain.Address;
import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.listener.QueueMsgUtil;
import com.dili.mtms.service.AddressService;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.constant.ResultCode;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.redis.delayqueue.dto.DelayMessage;
import com.dili.ss.redis.delayqueue.impl.DistributedRedisDelayQueueImpl;
import com.dili.uid.sdk.rpc.feign.UidFeignRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    DistributedRedisDelayQueueImpl redisDelayQueue;

    @Autowired
    private CustomerRpc customerRpc;

    @Autowired
    AddressService addressService;

    /**
     * 买卖端运输单列表
     *
     * @param order
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/listPage")
    public @ResponseBody
    BaseOutput transportList(TransportOrderQuey order) {
        BaseData data = null;
        try {
            data = transportOrderService.transportList(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
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
        try {
            //判断用户状态
            CustomerExtendDto customer = customerRpc.get(order.getShipperId(),order.getFirmId()).getData();
            if(customer != null && customer.getCustomerMarket() != null){
                Integer userStatus = customer.getCustomerMarket().getState();
                if(userStatus == 0){
                    return BaseOutput.create(ResultCode.DATA_ERROR,"用户已注销");
                }else if(userStatus == 2){
                    return BaseOutput.create(ResultCode.DATA_ERROR,"用户已禁用");
                }
            }
            //获取订单号
            BaseOutput<String> bizNumber = uidFeignRpc.getBizNumber(CfgContent.TRANSPORT_NO);
            if (bizNumber.isSuccess()) {
                String number = bizNumber.getData();
                order.setCode(number);
            }else {
                return BaseOutput.failure("获取订单编号失败");
            }
            TransportOrderQuey return_order = transportOrderService.insertTransport(order);
            //订单失效处理(redis队列)
            DelayMessage delayMessage = QueueMsgUtil.assemblyTransportMsg(return_order);
            redisDelayQueue.push(delayMessage);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
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
        TransportOrderQuey info = null;
        try {
            info = transportOrderService.transportDetail(order);
            //封装性别
            if(info.getShipperAddressId() != null && info.getDeliveryAddressId() != null){
                List<Address> addressList = addressService.getAdressInfo(info.getShipperAddressId(),info.getDeliveryAddressId());
                if(addressList.size()>0){
                   for(Address list:addressList){
                       if(info.getShipperAddressId().equals(list.getId())){
                           info.setShipperSex(list.getGender());
                       }
                       if(info.getDeliveryAddressId().equals(list.getId())){
                           info.setDeliverySex(list.getGender());
                       }
                   }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success().setData(info);
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
            int i = transportOrderService.transportCancel(order);
            if (i == 0){
                return BaseOutput.create(ResultCode.DATA_ERROR,"订单已取消");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
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
    BaseOutput confirmTransportOrder(TransportOrder order) {
        try {
            //判断用户状态
            CustomerExtendDto customer = customerRpc.get(order.getShipperId(),order.getFirmId()).getData();
            if(customer != null && customer.getCustomerMarket() != null){
                Integer userStatus = customer.getCustomerMarket().getState();
                if(userStatus == 0){
                    return BaseOutput.create(ResultCode.DATA_ERROR,"用户已注销");
                }else if(userStatus == 2){
                    return BaseOutput.create(ResultCode.DATA_ERROR,"用户已禁用");
                }
            }

            int i = transportOrderService.confirmTransportOrder(order);
            if (i == 0){
                return BaseOutput.create(ResultCode.DATA_ERROR,"订单已被其它司机接单");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
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
    BaseOutput transportComplete(TransportOrder order) {
        try {
            int i = transportOrderService.transportComplete(order);
            if (i == 0){
                return BaseOutput.create(ResultCode.DATA_ERROR,"订单已确认");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }

    /**
     * 删除订单
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/delete")
    public @ResponseBody BaseOutput deleteTransporOrder(TransportOrder order) {
        try {
            transportOrderService.deleteTransporOrder(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return BaseOutput.failure(CfgContent.SYSTEM_EXCEPTION);
        }
        return BaseOutput.success();
    }
}
