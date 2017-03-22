package com.JJ.dao;

import com.JJ.model.TransactionPaymentItemDbObject;
import com.JJ.model.TransactionPaymentItemDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionPaymentItemDbObjectMapper {
    int countByExample(TransactionPaymentItemDbObjectExample example);

    int deleteByExample(TransactionPaymentItemDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionPaymentItemDbObject record);

    int insertSelective(TransactionPaymentItemDbObject record);

    List<TransactionPaymentItemDbObject> selectByExample(TransactionPaymentItemDbObjectExample example);

    TransactionPaymentItemDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionPaymentItemDbObject record, @Param("example") TransactionPaymentItemDbObjectExample example);

    int updateByExample(@Param("record") TransactionPaymentItemDbObject record, @Param("example") TransactionPaymentItemDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionPaymentItemDbObject record);

    int updateByPrimaryKey(TransactionPaymentItemDbObject record);
}