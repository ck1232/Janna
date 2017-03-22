package com.JJ.dao;

import com.JJ.model.TransactionShippingOptionDbObject;
import com.JJ.model.TransactionShippingOptionDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionShippingOptionDbObjectMapper {
    int countByExample(TransactionShippingOptionDbObjectExample example);

    int deleteByExample(TransactionShippingOptionDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionShippingOptionDbObject record);

    int insertSelective(TransactionShippingOptionDbObject record);

    List<TransactionShippingOptionDbObject> selectByExample(TransactionShippingOptionDbObjectExample example);

    TransactionShippingOptionDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionShippingOptionDbObject record, @Param("example") TransactionShippingOptionDbObjectExample example);

    int updateByExample(@Param("record") TransactionShippingOptionDbObject record, @Param("example") TransactionShippingOptionDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionShippingOptionDbObject record);

    int updateByPrimaryKey(TransactionShippingOptionDbObject record);
}