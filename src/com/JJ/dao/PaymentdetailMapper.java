package com.JJ.dao;

import com.JJ.model.Paymentdetail;
import com.JJ.model.PaymentdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentdetailMapper {
    int countByExample(PaymentdetailExample example);

    int deleteByExample(PaymentdetailExample example);

    int deleteByPrimaryKey(Integer paymentdetailid);

    int insert(Paymentdetail record);

    int insertSelective(Paymentdetail record);

    List<Paymentdetail> selectByExample(PaymentdetailExample example);

    Paymentdetail selectByPrimaryKey(Integer paymentdetailid);

    int updateByExampleSelective(@Param("record") Paymentdetail record, @Param("example") PaymentdetailExample example);

    int updateByExample(@Param("record") Paymentdetail record, @Param("example") PaymentdetailExample example);

    int updateByPrimaryKeySelective(Paymentdetail record);

    int updateByPrimaryKey(Paymentdetail record);
}