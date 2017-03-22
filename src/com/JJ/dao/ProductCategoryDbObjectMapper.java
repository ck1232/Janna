package com.JJ.dao;

import com.JJ.model.ProductCategoryDbObject;
import com.JJ.model.ProductCategoryDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryDbObjectMapper {
    int countByExample(ProductCategoryDbObjectExample example);

    int deleteByExample(ProductCategoryDbObjectExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(ProductCategoryDbObject record);

    int insertSelective(ProductCategoryDbObject record);

    List<ProductCategoryDbObject> selectByExample(ProductCategoryDbObjectExample example);

    ProductCategoryDbObject selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") ProductCategoryDbObject record, @Param("example") ProductCategoryDbObjectExample example);

    int updateByExample(@Param("record") ProductCategoryDbObject record, @Param("example") ProductCategoryDbObjectExample example);

    int updateByPrimaryKeySelective(ProductCategoryDbObject record);

    int updateByPrimaryKey(ProductCategoryDbObject record);
}