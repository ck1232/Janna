package com.JJ.dao;

import com.JJ.model.PaymentMode;
import com.JJ.model.PaymentModeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentModeMapper {
    int countByExample(PaymentModeExample example);

    int deleteByExample(PaymentModeExample example);

    int deleteByPrimaryKey(Integer paymentmodeid);

    int insert(PaymentMode record);

    int insertSelective(PaymentMode record);

    List<PaymentMode> selectByExample(PaymentModeExample example);

    PaymentMode selectByPrimaryKey(Integer paymentmodeid);

    int updateByExampleSelective(@Param("record") PaymentMode record, @Param("example") PaymentModeExample example);

    int updateByExample(@Param("record") PaymentMode record, @Param("example") PaymentModeExample example);

    int updateByPrimaryKeySelective(PaymentMode record);

    int updateByPrimaryKey(PaymentMode record);
}