package com.JJ.dao;

import com.JJ.model.TransactionDbObject;
import com.JJ.model.TransactionDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionDbObjectMapper {
    int countByExample(TransactionDbObjectExample example);

    int deleteByExample(TransactionDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionDbObject record);

    int insertSelective(TransactionDbObject record);

    List<TransactionDbObject> selectByExample(TransactionDbObjectExample example);

    TransactionDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionDbObject record, @Param("example") TransactionDbObjectExample example);

    int updateByExample(@Param("record") TransactionDbObject record, @Param("example") TransactionDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionDbObject record);

    int updateByPrimaryKey(TransactionDbObject record);
}