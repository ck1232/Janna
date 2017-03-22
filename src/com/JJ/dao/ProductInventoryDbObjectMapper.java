package com.JJ.dao;

import com.JJ.model.ProductInventoryDbObject;
import com.JJ.model.ProductInventoryDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductInventoryDbObjectMapper {
    int countByExample(ProductInventoryDbObjectExample example);

    int deleteByExample(ProductInventoryDbObjectExample example);

    int deleteByPrimaryKey(Integer productInventoryId);

    int insert(ProductInventoryDbObject record);

    int insertSelective(ProductInventoryDbObject record);

    List<ProductInventoryDbObject> selectByExample(ProductInventoryDbObjectExample example);

    ProductInventoryDbObject selectByPrimaryKey(Integer productInventoryId);

    int updateByExampleSelective(@Param("record") ProductInventoryDbObject record, @Param("example") ProductInventoryDbObjectExample example);

    int updateByExample(@Param("record") ProductInventoryDbObject record, @Param("example") ProductInventoryDbObjectExample example);

    int updateByPrimaryKeySelective(ProductInventoryDbObject record);

    int updateByPrimaryKey(ProductInventoryDbObject record);
}