package com.dili.mtms.dto;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.domain.LoadingOrderItem;
import com.dili.ss.processor.annotation.GenDTOMethod;

import java.util.List;

@GenDTOMethod
public interface LoadingOrderItems extends LoadingOrder {
    List<LoadingOrderItem> loadingOrderItems = null;
}
