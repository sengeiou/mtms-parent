package com.dili.mtms.dto;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.domain.TransportOrderItem;

import java.util.Date;
import java.util.List;

/**
 * 运输单dto
 */
public interface TransportOrderQuey extends TransportOrder {

    String getKeyword();
    void setKeyword(String keyword);

    String getKeyvalue();
    void setKeyvalue(String keyvalue);

    String getOrderItem();
    void setOrderItem(String orderItem);

    /**
     * 运输单项
     * @return
     */
    List<TransportOrderItem> getTransportItem();
    void setTransportItem(List<TransportOrderItem> transportItem);

    /**
     * 订单时间查询区间
     * @return
     */
    String getOrderTime();
    void setOrderTime(String orderTime);

    Date getOrderStartTime();
    void setOrderStartTime(Date orderStartTime);

    Date getOrderEndTime();
    void setOrderEndTime(Date orderEndTime);

    /**
     * 服务时间查询区间
     * @return
     */
    String getServeTime();
    void setServeTime(String serveTime);

    Date getServiceStartTime();
    void setServiceStartTime(Date serviceStartTime);

    Date getServiceEndTime();
    void setServiceEndTime(Date serviceEndTime);

}
