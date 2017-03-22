package com.JJ.dao;

import com.JJ.model.ProductDbObject;
import com.JJ.model.ProductDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDbObjectMapper {
    int countByExample(ProductDbObjectExample example);

    int deleteByExample(ProductDbObjectExample example);

    int deleteByPrimaryKey(Integer productId);

    int insert(ProductDbObject record);

    int insertSelective(ProductDbObject record);

    List<ProductDbObject> selectByExample(ProductDbObjectExample example);

    ProductDbObject selectByPrimaryKey(Integer productId);

    int updateByExampleSelective(@Param("record") ProductDbObject record, @Param("example") ProductDbObjectExample example);

    int updateByExample(@Param("record") ProductDbObject record, @Param("example") ProductDbObjectExample example);

    int updateByPrimaryKeySelective(ProductDbObject record);

    int updateByPrimaryKey(ProductDbObject record);
}