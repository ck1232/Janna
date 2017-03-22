package com.JJ.dao;

import com.JJ.model.ProductImageDbObject;
import com.JJ.model.ProductImageDbObjectExample;
import com.JJ.model.ProductImageDbObjectWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductImageDbObjectMapper {
    int countByExample(ProductImageDbObjectExample example);

    int deleteByExample(ProductImageDbObjectExample example);

    int deleteByPrimaryKey(Integer productImageId);

    int insert(ProductImageDbObjectWithBLOBs record);

    int insertSelective(ProductImageDbObjectWithBLOBs record);

    List<ProductImageDbObjectWithBLOBs> selectByExampleWithBLOBs(ProductImageDbObjectExample example);

    List<ProductImageDbObject> selectByExample(ProductImageDbObjectExample example);

    ProductImageDbObjectWithBLOBs selectByPrimaryKey(Integer productImageId);

    int updateByExampleSelective(@Param("record") ProductImageDbObjectWithBLOBs record, @Param("example") ProductImageDbObjectExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductImageDbObjectWithBLOBs record, @Param("example") ProductImageDbObjectExample example);

    int updateByExample(@Param("record") ProductImageDbObject record, @Param("example") ProductImageDbObjectExample example);

    int updateByPrimaryKeySelective(ProductImageDbObjectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductImageDbObjectWithBLOBs record);

    int updateByPrimaryKey(ProductImageDbObject record);
}