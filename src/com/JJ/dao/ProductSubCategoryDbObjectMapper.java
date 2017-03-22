package com.JJ.dao;

import com.JJ.model.ProductSubCategoryDbObject;
import com.JJ.model.ProductSubCategoryDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSubCategoryDbObjectMapper {
    int countByExample(ProductSubCategoryDbObjectExample example);

    int deleteByExample(ProductSubCategoryDbObjectExample example);

    int deleteByPrimaryKey(Integer subCategoryId);

    int insert(ProductSubCategoryDbObject record);

    int insertSelective(ProductSubCategoryDbObject record);

    List<ProductSubCategoryDbObject> selectByExample(ProductSubCategoryDbObjectExample example);

    ProductSubCategoryDbObject selectByPrimaryKey(Integer subCategoryId);

    int updateByExampleSelective(@Param("record") ProductSubCategoryDbObject record, @Param("example") ProductSubCategoryDbObjectExample example);

    int updateByExample(@Param("record") ProductSubCategoryDbObject record, @Param("example") ProductSubCategoryDbObjectExample example);

    int updateByPrimaryKeySelective(ProductSubCategoryDbObject record);

    int updateByPrimaryKey(ProductSubCategoryDbObject record);
}