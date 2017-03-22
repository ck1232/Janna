package com.JJ.dao;

import com.JJ.model.DiscountDbObject;
import com.JJ.model.DiscountDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscountDbObjectMapper {
    int countByExample(DiscountDbObjectExample example);

    int deleteByExample(DiscountDbObjectExample example);

    int deleteByPrimaryKey(Integer discountId);

    int insert(DiscountDbObject record);

    int insertSelective(DiscountDbObject record);

    List<DiscountDbObject> selectByExample(DiscountDbObjectExample example);

    DiscountDbObject selectByPrimaryKey(Integer discountId);

    int updateByExampleSelective(@Param("record") DiscountDbObject record, @Param("example") DiscountDbObjectExample example);

    int updateByExample(@Param("record") DiscountDbObject record, @Param("example") DiscountDbObjectExample example);

    int updateByPrimaryKeySelective(DiscountDbObject record);

    int updateByPrimaryKey(DiscountDbObject record);
}