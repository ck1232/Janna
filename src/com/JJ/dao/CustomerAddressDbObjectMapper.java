package com.JJ.dao;

import com.JJ.model.CustomerAddressDbObject;
import com.JJ.model.CustomerAddressDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerAddressDbObjectMapper {
    int countByExample(CustomerAddressDbObjectExample example);

    int deleteByExample(CustomerAddressDbObjectExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(CustomerAddressDbObject record);

    int insertSelective(CustomerAddressDbObject record);

    List<CustomerAddressDbObject> selectByExample(CustomerAddressDbObjectExample example);

    CustomerAddressDbObject selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") CustomerAddressDbObject record, @Param("example") CustomerAddressDbObjectExample example);

    int updateByExample(@Param("record") CustomerAddressDbObject record, @Param("example") CustomerAddressDbObjectExample example);

    int updateByPrimaryKeySelective(CustomerAddressDbObject record);

    int updateByPrimaryKey(CustomerAddressDbObject record);
}