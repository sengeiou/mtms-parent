package com.dili.mtms.api;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.mtms.service.TransportOrderService;
import com.dili.ss.domain.BaseOutput;
import com.dili.ss.domain.PageOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * pc端接口
 */
@Controller
@RequestMapping("/api/trans")
public class TransportOrderControllerr {

    @Autowired
    TransportOrderService transportOrderService;

    /**
     * 运输单列表
     * @param quey
     * @return
     * @throws Exception
     */
    @PostMapping(value="/listPage.action")
    public @ResponseBody BaseOutput listPage(TransportOrderQuey quey) {
        PageOutput<List<TransportOrderQuey>> listPageOutput = null;
        try {
             listPageOutput = transportOrderService.listByQueryParams(null);
        }catch (Exception e){
            return BaseOutput.failure();
        }
        return BaseOutput.success().setData(listPageOutput);
    }
}
