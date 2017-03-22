package com.JJ.dao;

import com.JJ.model.ProductSubOptionRsDbObject;
import com.JJ.model.ProductSubOptionRsDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSubOptionRsDbObjectMapper {
    int countByExample(ProductSubOptionRsDbObjectExample example);

    int deleteByExample(ProductSubOptionRsDbObjectExample example);

    int deleteByPrimaryKey(Integer productSuboptionRsId);

    int insert(ProductSubOptionRsDbObject record);

    int insertSelective(ProductSubOptionRsDbObject record);

    List<ProductSubOptionRsDbObject> selectByExample(ProductSubOptionRsDbObjectExample example);

    ProductSubOptionRsDbObject selectByPrimaryKey(Integer productSuboptionRsId);

    int updateByExampleSelective(@Param("record") ProductSubOptionRsDbObject record, @Param("example") ProductSubOptionRsDbObjectExample example);

    int updateByExample(@Param("record") ProductSubOptionRsDbObject record, @Param("example") ProductSubOptionRsDbObjectExample example);

    int updateByPrimaryKeySelective(ProductSubOptionRsDbObject record);

    int updateByPrimaryKey(ProductSubOptionRsDbObject record);
}