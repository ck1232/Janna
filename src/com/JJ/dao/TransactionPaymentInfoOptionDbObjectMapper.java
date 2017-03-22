package com.JJ.dao;

import com.JJ.model.TransactionPaymentInfoOptionDbObject;
import com.JJ.model.TransactionPaymentInfoOptionDbObjectExample;
import com.JJ.model.TransactionPaymentInfoOptionDbObjectKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionPaymentInfoOptionDbObjectMapper {
    int countByExample(TransactionPaymentInfoOptionDbObjectExample example);

    int deleteByExample(TransactionPaymentInfoOptionDbObjectExample example);

    int deleteByPrimaryKey(TransactionPaymentInfoOptionDbObjectKey key);

    int insert(TransactionPaymentInfoOptionDbObject record);

    int insertSelective(TransactionPaymentInfoOptionDbObject record);

    List<TransactionPaymentInfoOptionDbObject> selectByExample(TransactionPaymentInfoOptionDbObjectExample example);

    TransactionPaymentInfoOptionDbObject selectByPrimaryKey(TransactionPaymentInfoOptionDbObjectKey key);

    int updateByExampleSelective(@Param("record") TransactionPaymentInfoOptionDbObject record, @Param("example") TransactionPaymentInfoOptionDbObjectExample example);

    int updateByExample(@Param("record") TransactionPaymentInfoOptionDbObject record, @Param("example") TransactionPaymentInfoOptionDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionPaymentInfoOptionDbObject record);

    int updateByPrimaryKey(TransactionPaymentInfoOptionDbObject record);
}