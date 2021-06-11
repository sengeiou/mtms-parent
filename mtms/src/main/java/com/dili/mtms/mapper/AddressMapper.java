package com.dili.mtms.mapper;

import com.dili.mtms.domain.Address;
import com.dili.ss.base.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper extends MyMapper<Address> {

    int insertAddress(Address address);

    void updateIsdefaultAddress(Address address);

    Address getDefaultAddress(Address address);

    List<Address> listAddress(Address address);

    List<Address> getAdressInfo(@Param("shipperAddressId") Long shipperAddressId,@Param("deliveryAddressId") Long deliveryAddressId);
}