package com.dili.mtms.api;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.service.LoadingOrderService;
import com.dili.ss.domain.BaseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 装卸单管理
 */
@RestController
@RequestMapping("/api/loadingOrder")
public class LoadingOrderApi {

    @Autowired
    LoadingOrderService loadingOrderService;

    /**
     * 买卖端装卸列表
     * @param loadingOrder
     * @return
     * @throws Exception
     */
    @PostMapping(value="/listPage")
    public @ResponseBody BaseOutput listPage(LoadingOrder loadingOrder) throws Exception {
        return BaseOutput.success();
    }

    /**
     * 新增LoadingOrder
     * @param loadingOrder
     * @return BaseOutput
     */
    @PostMapping(value="/insert")
    public @ResponseBody BaseOutput insert(LoadingOrder loadingOrder) {
        return BaseOutput.success();
    }
}