package com.dili.mtms.dto;

import com.dili.mtms.domain.TransportOrder;

import java.util.Date;

/**
 * 运输单dto
 */
public interface TransportOrderQuey extends TransportOrder {

    Date getOrderStartTime();
    void setOrderStartTime(Date orderStartTime);

    Date getOrderEndTime();
    void setOrderEndTime(Date orderEndTime);


}
