package com.dili.mtms.service.impl;

import com.dili.mtms.domain.TransportOrderItem;
import com.dili.mtms.mapper.TransportOrderItemMapper;
import com.dili.mtms.service.TransportOrderItemService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@Service
public class TransportOrderItemServiceImpl extends BaseServiceImpl<TransportOrderItem, Long> implements TransportOrderItemService {

    public TransportOrderItemMapper getActualDao() {
        return (TransportOrderItemMapper)getDao();
    }
}