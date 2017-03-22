package com.JJ.dao;

import com.JJ.model.PaymentModeDbObject;
import com.JJ.model.PaymentModeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentModeDbObjectMapper {
    int countByExample(PaymentModeDbObjectExample example);

    int deleteByExample(PaymentModeDbObjectExample example);

    int deleteByPrimaryKey(Integer paymentModeId);

    int insert(PaymentModeDbObject record);

    int insertSelective(PaymentModeDbObject record);

    List<PaymentModeDbObject> selectByExample(PaymentModeDbObjectExample example);

    PaymentModeDbObject selectByPrimaryKey(Integer paymentModeId);

    int updateByExampleSelective(@Param("record") PaymentModeDbObject record, @Param("example") PaymentModeDbObjectExample example);

    int updateByExample(@Param("record") PaymentModeDbObject record, @Param("example") PaymentModeDbObjectExample example);

    int updateByPrimaryKeySelective(PaymentModeDbObject record);

    int updateByPrimaryKey(PaymentModeDbObject record);
}