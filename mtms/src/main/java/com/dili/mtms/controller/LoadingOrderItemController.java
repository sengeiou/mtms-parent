package com.dili.mtms.controller;

import com.dili.mtms.domain.LoadingOrderItem;
import com.dili.mtms.service.LoadingOrderItemService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/loadingOrderItem")
public class LoadingOrderItemController {
    @Autowired
    LoadingOrderItemService loadingOrderItemService;

    /**
     * 分页查询LoadingOrderItem，返回easyui分页信息
     * @param loadingOrderItem
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(LoadingOrderItem loadingOrderItem) throws Exception {
        return loadingOrderItemService.listEasyuiPageByExample(loadingOrderItem, true).toString();
    }

    /**
     * 新增LoadingOrderItem
     * @param loadingOrderItem
     * @return BaseOutput
     */
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(LoadingOrderItem loadingOrderItem) {
        loadingOrderItemService.insertSelective(loadingOrderItem);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改LoadingOrderItem
     * @param loadingOrderItem
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(LoadingOrderItem loadingOrderItem) {
        loadingOrderItemService.updateSelective(loadingOrderItem);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除LoadingOrderItem
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        loadingOrderItemService.delete(id);
        return BaseOutput.success("删除成功");
    }
}