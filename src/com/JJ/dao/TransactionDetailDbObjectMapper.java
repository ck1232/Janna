package com.JJ.dao;

import com.JJ.model.TransactionDetailDbObject;
import com.JJ.model.TransactionDetailDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionDetailDbObjectMapper {
    int countByExample(TransactionDetailDbObjectExample example);

    int deleteByExample(TransactionDetailDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionDetailDbObject record);

    int insertSelective(TransactionDetailDbObject record);

    List<TransactionDetailDbObject> selectByExample(TransactionDetailDbObjectExample example);

    TransactionDetailDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionDetailDbObject record, @Param("example") TransactionDetailDbObjectExample example);

    int updateByExample(@Param("record") TransactionDetailDbObject record, @Param("example") TransactionDetailDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionDetailDbObject record);

    int updateByPrimaryKey(TransactionDetailDbObject record);
}