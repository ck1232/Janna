package com.JJ.dao;

import com.JJ.model.TransactionPayerInfoDbObject;
import com.JJ.model.TransactionPayerInfoDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionPayerInfoDbObjectMapper {
    int countByExample(TransactionPayerInfoDbObjectExample example);

    int deleteByExample(TransactionPayerInfoDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionPayerInfoDbObject record);

    int insertSelective(TransactionPayerInfoDbObject record);

    List<TransactionPayerInfoDbObject> selectByExample(TransactionPayerInfoDbObjectExample example);

    TransactionPayerInfoDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionPayerInfoDbObject record, @Param("example") TransactionPayerInfoDbObjectExample example);

    int updateByExample(@Param("record") TransactionPayerInfoDbObject record, @Param("example") TransactionPayerInfoDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionPayerInfoDbObject record);

    int updateByPrimaryKey(TransactionPayerInfoDbObject record);
}