package com.dili.mtms.mapper;

import com.dili.mtms.domain.LoadingOrder;
import com.dili.mtms.domain.LoadingOrderItem;
import com.dili.mtms.dto.LoadingOrderQuey;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoadingOrderMapper extends MyMapper<LoadingOrder> {

    List<LoadingOrderQuey> loadingList(LoadingOrderQuey order);

    int insertLoading(LoadingOrderQuey order);

    int insertLoadingItem(@Param("list") List<LoadingOrderItem> list, @Param("id") Long id);

    LoadingOrderQuey loadingDetail(Long id);

    void deleteLoadingOrder(Long id);

    void deleteLoadingOrderItem(Long id);

    List<LoadingOrderQuey> listByQueryParams(LoadingOrderQuey quey);

    int loadingCancel(LoadingOrder loadingOrder);

    int loadingComplete(LoadingOrder loadingOrder);

    int confirmLoadingOrder(LoadingOrder loadingOrder);
}