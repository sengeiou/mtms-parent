package com.dili.mtms.mapper;

import com.dili.mtms.domain.TransportOrder;
import com.dili.mtms.domain.TransportOrderItem;
import com.dili.mtms.dto.TransportOrderQuey;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransportOrderMapper extends MyMapper<TransportOrder> {

    List<TransportOrderQuey> listByQueryParams(TransportOrderQuey quey);

    List<TransportOrderQuey> transportList(TransportOrderQuey order);

    int insertTransport(TransportOrderQuey order);

    int insertTransportItem(@Param("list") List<TransportOrderItem> list, @Param("id") Long id);

    TransportOrderQuey transportDetail(Long id);

    void deleteTransporOrder(Long id);

    void deleteTransporOrderItem(Long id);
}