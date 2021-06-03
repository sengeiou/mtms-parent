package com.dili.mtms.dto;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.domain.LoadingOrderItem;

import java.util.List;

/**
 * 运输单dto
 */
public interface DriverOrderQuey extends LoadingOrder {

    int getOrderType();
    void setOrderType(int orderType);

}
