package com.JJ.dao;

import com.JJ.model.PaymentDetailDbObject;
import com.JJ.model.PaymentDetailDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentDetailDbObjectMapper {
    int countByExample(PaymentDetailDbObjectExample example);

    int deleteByExample(PaymentDetailDbObjectExample example);

    int deleteByPrimaryKey(Integer paymentDetailId);

    int insert(PaymentDetailDbObject record);

    int insertSelective(PaymentDetailDbObject record);

    List<PaymentDetailDbObject> selectByExample(PaymentDetailDbObjectExample example);

    PaymentDetailDbObject selectByPrimaryKey(Integer paymentDetailId);

    int updateByExampleSelective(@Param("record") PaymentDetailDbObject record, @Param("example") PaymentDetailDbObjectExample example);

    int updateByExample(@Param("record") PaymentDetailDbObject record, @Param("example") PaymentDetailDbObjectExample example);

    int updateByPrimaryKeySelective(PaymentDetailDbObject record);

    int updateByPrimaryKey(PaymentDetailDbObject record);
}