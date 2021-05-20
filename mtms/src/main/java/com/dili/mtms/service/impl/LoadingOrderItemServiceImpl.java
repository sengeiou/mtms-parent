package com.dili.mtms.service.impl;

import com.dili.mtms.domain.LoadingOrderItem;
import com.dili.mtms.mapper.LoadingOrderItemMapper;
import com.dili.mtms.service.LoadingOrderItemService;
import com.dili.ss.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 由MyBatis Generator工具自动生成
 * This file was generated on 2021-05-20 17:20:00.
 */
@Service
public class LoadingOrderItemServiceImpl extends BaseServiceImpl<LoadingOrderItem, Long> implements LoadingOrderItemService {

    public LoadingOrderItemMapper getActualDao() {
        return (LoadingOrderItemMapper)getDao();
    }
}