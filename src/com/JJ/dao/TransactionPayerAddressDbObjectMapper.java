package com.JJ.dao;

import com.JJ.model.TransactionPayerAddressDbObject;
import com.JJ.model.TransactionPayerAddressDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionPayerAddressDbObjectMapper {
    int countByExample(TransactionPayerAddressDbObjectExample example);

    int deleteByExample(TransactionPayerAddressDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionPayerAddressDbObject record);

    int insertSelective(TransactionPayerAddressDbObject record);

    List<TransactionPayerAddressDbObject> selectByExample(TransactionPayerAddressDbObjectExample example);

    TransactionPayerAddressDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionPayerAddressDbObject record, @Param("example") TransactionPayerAddressDbObjectExample example);

    int updateByExample(@Param("record") TransactionPayerAddressDbObject record, @Param("example") TransactionPayerAddressDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionPayerAddressDbObject record);

    int updateByPrimaryKey(TransactionPayerAddressDbObject record);
}