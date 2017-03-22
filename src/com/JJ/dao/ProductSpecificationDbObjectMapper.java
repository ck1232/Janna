package com.JJ.dao;

import com.JJ.model.ProductSpecificationDbObject;
import com.JJ.model.ProductSpecificationDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSpecificationDbObjectMapper {
    int countByExample(ProductSpecificationDbObjectExample example);

    int deleteByExample(ProductSpecificationDbObjectExample example);

    int deleteByPrimaryKey(Integer productSpecificationId);

    int insert(ProductSpecificationDbObject record);

    int insertSelective(ProductSpecificationDbObject record);

    List<ProductSpecificationDbObject> selectByExampleWithBLOBs(ProductSpecificationDbObjectExample example);

    List<ProductSpecificationDbObject> selectByExample(ProductSpecificationDbObjectExample example);

    ProductSpecificationDbObject selectByPrimaryKey(Integer productSpecificationId);

    int updateByExampleSelective(@Param("record") ProductSpecificationDbObject record, @Param("example") ProductSpecificationDbObjectExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductSpecificationDbObject record, @Param("example") ProductSpecificationDbObjectExample example);

    int updateByExample(@Param("record") ProductSpecificationDbObject record, @Param("example") ProductSpecificationDbObjectExample example);

    int updateByPrimaryKeySelective(ProductSpecificationDbObject record);

    int updateByPrimaryKeyWithBLOBs(ProductSpecificationDbObject record);

    int updateByPrimaryKey(ProductSpecificationDbObject record);
}