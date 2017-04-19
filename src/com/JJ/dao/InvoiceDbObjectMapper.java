package com.JJ.dao;

import com.JJ.model.InvoiceDbObject;
import com.JJ.model.InvoiceDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvoiceDbObjectMapper {
    int countByExample(InvoiceDbObjectExample example);

    int deleteByExample(InvoiceDbObjectExample example);

    int deleteByPrimaryKey(Integer invoiceId);

    int insert(InvoiceDbObject record);

    int insertSelective(InvoiceDbObject record);

    List<InvoiceDbObject> selectByExample(InvoiceDbObjectExample example);

    InvoiceDbObject selectByPrimaryKey(Integer invoiceId);

    int updateByExampleSelective(@Param("record") InvoiceDbObject record, @Param("example") InvoiceDbObjectExample example);

    int updateByExample(@Param("record") InvoiceDbObject record, @Param("example") InvoiceDbObjectExample example);

    int updateByPrimaryKeySelective(InvoiceDbObject record);

    int updateByPrimaryKey(InvoiceDbObject record);
}