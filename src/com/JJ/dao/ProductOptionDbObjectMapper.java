package com.JJ.dao;

import com.JJ.model.ProductOptionDbObject;
import com.JJ.model.ProductOptionDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductOptionDbObjectMapper {
    int countByExample(ProductOptionDbObjectExample example);

    int deleteByExample(ProductOptionDbObjectExample example);

    int deleteByPrimaryKey(Integer productOptionId);

    int insert(ProductOptionDbObject record);

    int insertSelective(ProductOptionDbObject record);

    List<ProductOptionDbObject> selectByExample(ProductOptionDbObjectExample example);

    ProductOptionDbObject selectByPrimaryKey(Integer productOptionId);

    int updateByExampleSelective(@Param("record") ProductOptionDbObject record, @Param("example") ProductOptionDbObjectExample example);

    int updateByExample(@Param("record") ProductOptionDbObject record, @Param("example") ProductOptionDbObjectExample example);

    int updateByPrimaryKeySelective(ProductOptionDbObject record);

    int updateByPrimaryKey(ProductOptionDbObject record);
}