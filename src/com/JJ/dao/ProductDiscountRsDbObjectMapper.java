package com.JJ.dao;

import com.JJ.model.ProductDiscountRsDbObject;
import com.JJ.model.ProductDiscountRsDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDiscountRsDbObjectMapper {
    int countByExample(ProductDiscountRsDbObjectExample example);

    int deleteByExample(ProductDiscountRsDbObjectExample example);

    int deleteByPrimaryKey(Integer productDiscountRsId);

    int insert(ProductDiscountRsDbObject record);

    int insertSelective(ProductDiscountRsDbObject record);

    List<ProductDiscountRsDbObject> selectByExample(ProductDiscountRsDbObjectExample example);

    ProductDiscountRsDbObject selectByPrimaryKey(Integer productDiscountRsId);

    int updateByExampleSelective(@Param("record") ProductDiscountRsDbObject record, @Param("example") ProductDiscountRsDbObjectExample example);

    int updateByExample(@Param("record") ProductDiscountRsDbObject record, @Param("example") ProductDiscountRsDbObjectExample example);

    int updateByPrimaryKeySelective(ProductDiscountRsDbObject record);

    int updateByPrimaryKey(ProductDiscountRsDbObject record);
}