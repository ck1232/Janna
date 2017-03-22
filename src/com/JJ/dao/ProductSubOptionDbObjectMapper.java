package com.JJ.dao;

import com.JJ.model.ProductSubOptionDbObject;
import com.JJ.model.ProductSubOptionDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSubOptionDbObjectMapper {
    int countByExample(ProductSubOptionDbObjectExample example);

    int deleteByExample(ProductSubOptionDbObjectExample example);

    int deleteByPrimaryKey(Integer productSuboptionId);

    int insert(ProductSubOptionDbObject record);

    int insertSelective(ProductSubOptionDbObject record);

    List<ProductSubOptionDbObject> selectByExample(ProductSubOptionDbObjectExample example);

    ProductSubOptionDbObject selectByPrimaryKey(Integer productSuboptionId);

    int updateByExampleSelective(@Param("record") ProductSubOptionDbObject record, @Param("example") ProductSubOptionDbObjectExample example);

    int updateByExample(@Param("record") ProductSubOptionDbObject record, @Param("example") ProductSubOptionDbObjectExample example);

    int updateByPrimaryKeySelective(ProductSubOptionDbObject record);

    int updateByPrimaryKey(ProductSubOptionDbObject record);
}