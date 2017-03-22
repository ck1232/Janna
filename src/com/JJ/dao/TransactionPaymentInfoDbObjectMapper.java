package com.JJ.dao;

import com.JJ.model.TransactionPaymentInfoDbObject;
import com.JJ.model.TransactionPaymentInfoDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionPaymentInfoDbObjectMapper {
    int countByExample(TransactionPaymentInfoDbObjectExample example);

    int deleteByExample(TransactionPaymentInfoDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionPaymentInfoDbObject record);

    int insertSelective(TransactionPaymentInfoDbObject record);

    List<TransactionPaymentInfoDbObject> selectByExample(TransactionPaymentInfoDbObjectExample example);

    TransactionPaymentInfoDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionPaymentInfoDbObject record, @Param("example") TransactionPaymentInfoDbObjectExample example);

    int updateByExample(@Param("record") TransactionPaymentInfoDbObject record, @Param("example") TransactionPaymentInfoDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionPaymentInfoDbObject record);

    int updateByPrimaryKey(TransactionPaymentInfoDbObject record);
}