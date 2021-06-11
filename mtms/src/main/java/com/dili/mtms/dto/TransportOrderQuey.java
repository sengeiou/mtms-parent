package com.dili.mtms.dto;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.domain.TransportOrderItem;

import java.util.Date;
import java.util.List;

/**
 * 运输单dto
 */
public interface TransportOrderQuey extends TransportOrder {

    Byte getShipperSex();
    void setShipperSex(Byte shipperSex);

    Byte getDeliverySex();
    void setDeliverySex(Byte deliverySex);


    Integer getStatus();
    void setStatus(Integer status);


    /**
     * pc端关键字查询
     * @return
     */
    String getKeyword();
    void setKeyword(String keyword);

    String getKeyvalue();
    void setKeyvalue(String keyvalue);

    /**
     * 批量新增单项
     * @return
     */
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
