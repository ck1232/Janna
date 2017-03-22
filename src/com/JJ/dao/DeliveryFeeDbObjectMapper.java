package com.JJ.dao;

import com.JJ.model.DeliveryFeeDbObject;
import com.JJ.model.DeliveryFeeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryFeeDbObjectMapper {
    int countByExample(DeliveryFeeDbObjectExample example);

    int deleteByExample(DeliveryFeeDbObjectExample example);

    int deleteByPrimaryKey(Integer deliveryFeeId);

    int insert(DeliveryFeeDbObject record);

    int insertSelective(DeliveryFeeDbObject record);

    List<DeliveryFeeDbObject> selectByExample(DeliveryFeeDbObjectExample example);

    DeliveryFeeDbObject selectByPrimaryKey(Integer deliveryFeeId);

    int updateByExampleSelective(@Param("record") DeliveryFeeDbObject record, @Param("example") DeliveryFeeDbObjectExample example);

    int updateByExample(@Param("record") DeliveryFeeDbObject record, @Param("example") DeliveryFeeDbObjectExample example);

    int updateByPrimaryKeySelective(DeliveryFeeDbObject record);

    int updateByPrimaryKey(DeliveryFeeDbObject record);
}