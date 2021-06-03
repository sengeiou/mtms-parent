package com.dili.mtms.controller;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.BaseData;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.domain.BaseOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/api/transportOrder")
@Slf4j
public class TransportOrderController {
    @Autowired
    TransportOrderService transportOrderService;

    /**
     * 运输单列表
     * @param quey
     * @return
     * @throws Exception
     */
    @PostMapping(value="/listPage.action")
    public @ResponseBody BaseOutput listByQueryParams(TransportOrderQuey quey) {
        BaseData data = null;
        try {
            data = transportOrderService.listByQueryParams(quey);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(data);
    }

    /**
     * 新增TransportOrder
     * @param transportOrder
     * @return BaseOutput
     */
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(TransportOrder transportOrder) {
        transportOrderService.insertSelective(transportOrder);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改TransportOrder
     * @param transportOrder
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(TransportOrder transportOrder) {
        transportOrderService.updateSelective(transportOrder);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除TransportOrder
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        transportOrderService.delete(id);
        return BaseOutput.success("删除成功");
    }
}