package com.JJ.dao;

import com.JJ.model.CustomerDbObject;
import com.JJ.model.CustomerDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerDbObjectMapper {
    int countByExample(CustomerDbObjectExample example);

    int deleteByExample(CustomerDbObjectExample example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(CustomerDbObject record);

    int insertSelective(CustomerDbObject record);

    List<CustomerDbObject> selectByExample(CustomerDbObjectExample example);

    CustomerDbObject selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") CustomerDbObject record, @Param("example") CustomerDbObjectExample example);

    int updateByExample(@Param("record") CustomerDbObject record, @Param("example") CustomerDbObjectExample example);

    int updateByPrimaryKeySelective(CustomerDbObject record);

    int updateByPrimaryKey(CustomerDbObject record);
}