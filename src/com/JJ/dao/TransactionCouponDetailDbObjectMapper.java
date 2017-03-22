package com.JJ.dao;

import com.JJ.model.TransactionCouponDetailDbObject;
import com.JJ.model.TransactionCouponDetailDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransactionCouponDetailDbObjectMapper {
    int countByExample(TransactionCouponDetailDbObjectExample example);

    int deleteByExample(TransactionCouponDetailDbObjectExample example);

    int deleteByPrimaryKey(String transactionId);

    int insert(TransactionCouponDetailDbObject record);

    int insertSelective(TransactionCouponDetailDbObject record);

    List<TransactionCouponDetailDbObject> selectByExample(TransactionCouponDetailDbObjectExample example);

    TransactionCouponDetailDbObject selectByPrimaryKey(String transactionId);

    int updateByExampleSelective(@Param("record") TransactionCouponDetailDbObject record, @Param("example") TransactionCouponDetailDbObjectExample example);

    int updateByExample(@Param("record") TransactionCouponDetailDbObject record, @Param("example") TransactionCouponDetailDbObjectExample example);

    int updateByPrimaryKeySelective(TransactionCouponDetailDbObject record);

    int updateByPrimaryKey(TransactionCouponDetailDbObject record);
}