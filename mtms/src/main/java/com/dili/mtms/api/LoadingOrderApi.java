package com.dili.mtms.api;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.service.LoadingOrderService;
import com.dili.ss.domain.BaseOutput;
import com.dili.uid.sdk.rpc.feign.UidFeignRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 装卸单管理
 */
@RestController
@RequestMapping("/api/loadingOrder")
@Slf4j
public class LoadingOrderApi {

    @Autowired
    LoadingOrderService loadingOrderService;

    @Autowired
    UidFeignRpc uidFeignRpc;

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
            return BaseOutput.failure();
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
            return BaseOutput.failure();
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
            /*BaseOutput<String> bizNumber = uidFeignRpc.getBizNumber("");
            if (!bizNumber.isSuccess()) {
                String number = bizNumber.getData();
            }*/
            int i = loadingOrderService.insertLoading(order);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return BaseOutput.failure();
        }
        return BaseOutput.success();
    }

    /**
     * 取消订单
     * @param loadingOrder
     * @return
     */
    @PostMapping(value="/cancel")
    public @ResponseBody BaseOutput cancel(LoadingOrder loadingOrder) {
        loadingOrderService.updateSelective(loadingOrder);
        return BaseOutput.success("修改成功");
    }

    /**
     * 确认接单
     * @param loadingOrder
     * @return
     */
    @PostMapping(value="/confirmOrder")
    public @ResponseBody BaseOutput confirmOrder(LoadingOrder loadingOrder) {
        loadingOrderService.updateSelective(loadingOrder);
        return BaseOutput.success("修改成功");
    }

    /**
     * 订单完成
     * @param loadingOrder
     * @return
     */
    @PostMapping(value="/complete")
    public @ResponseBody BaseOutput complete(LoadingOrder loadingOrder) {
        loadingOrderService.updateSelective(loadingOrder);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @PostMapping(value="/delete")
    public @ResponseBody BaseOutput deleteLoadingOrder(Long id) {
        //loadingOrderService.deleteLoadingOrder(id);
        return BaseOutput.success("删除成功");
    }
}