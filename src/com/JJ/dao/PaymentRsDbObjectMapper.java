package com.JJ.dao;

import com.JJ.model.PaymentRsDbObject;
import com.JJ.model.PaymentRsDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentRsDbObjectMapper {
    int countByExample(PaymentRsDbObjectExample example);

    int deleteByExample(PaymentRsDbObjectExample example);

    int deleteByPrimaryKey(Integer paymentRsId);

    int insert(PaymentRsDbObject record);

    int insertSelective(PaymentRsDbObject record);

    List<PaymentRsDbObject> selectByExample(PaymentRsDbObjectExample example);

    PaymentRsDbObject selectByPrimaryKey(Integer paymentRsId);

    int updateByExampleSelective(@Param("record") PaymentRsDbObject record, @Param("example") PaymentRsDbObjectExample example);

    int updateByExample(@Param("record") PaymentRsDbObject record, @Param("example") PaymentRsDbObjectExample example);

    int updateByPrimaryKeySelective(PaymentRsDbObject record);

    int updateByPrimaryKey(PaymentRsDbObject record);
}