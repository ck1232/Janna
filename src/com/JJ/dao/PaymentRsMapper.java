package com.JJ.dao;

import com.JJ.model.PaymentRs;
import com.JJ.model.PaymentRsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentRsMapper {
    int countByExample(PaymentRsExample example);

    int deleteByExample(PaymentRsExample example);

    int deleteByPrimaryKey(Integer paymentrsid);

    int insert(PaymentRs record);

    int insertSelective(PaymentRs record);

    List<PaymentRs> selectByExample(PaymentRsExample example);

    PaymentRs selectByPrimaryKey(Integer paymentrsid);

    int updateByExampleSelective(@Param("record") PaymentRs record, @Param("example") PaymentRsExample example);

    int updateByExample(@Param("record") PaymentRs record, @Param("example") PaymentRsExample example);

    int updateByPrimaryKeySelective(PaymentRs record);

    int updateByPrimaryKey(PaymentRs record);
}