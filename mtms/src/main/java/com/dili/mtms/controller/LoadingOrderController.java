package com.dili.mtms.controller;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.service.LoadingOrderService;
import com.dili.ss.domain.BaseOutput;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@RestController
@RequestMapping("/loadingOrder")
public class LoadingOrderController {
    @Autowired
    LoadingOrderService loadingOrderService;

    /**
     * 分页查询LoadingOrder，返回easyui分页信息
     * @param loadingOrder
     * @return String
     * @throws Exception
     */
    @RequestMapping(value="/listPage.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String listPage(LoadingOrder loadingOrder) throws Exception {
        return loadingOrderService.listEasyuiPageByExample(loadingOrder, true).toString();
    }

    /**
     * 新增LoadingOrder
     * @param loadingOrder
     * @return BaseOutput
     */
    @RequestMapping(value="/insert.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput insert(LoadingOrder loadingOrder) {
        loadingOrderService.insertSelective(loadingOrder);
        return BaseOutput.success("新增成功");
    }

    /**
     * 修改LoadingOrder
     * @param loadingOrder
     * @return BaseOutput
     */
    @RequestMapping(value="/update.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput update(LoadingOrder loadingOrder) {
        loadingOrderService.updateSelective(loadingOrder);
        return BaseOutput.success("修改成功");
    }

    /**
     * 删除LoadingOrder
     * @param id
     * @return BaseOutput
     */
    @RequestMapping(value="/delete.action", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody BaseOutput delete(Long id) {
        loadingOrderService.delete(id);
        return BaseOutput.success("删除成功");
    }
}