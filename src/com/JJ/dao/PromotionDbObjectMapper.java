package com.JJ.dao;

import com.JJ.model.PromotionDbObject;
import com.JJ.model.PromotionDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionDbObjectMapper {
    int countByExample(PromotionDbObjectExample example);

    int deleteByExample(PromotionDbObjectExample example);

    int deleteByPrimaryKey(Integer promotionId);

    int insert(PromotionDbObject record);

    int insertSelective(PromotionDbObject record);

    List<PromotionDbObject> selectByExampleWithBLOBs(PromotionDbObjectExample example);

    List<PromotionDbObject> selectByExample(PromotionDbObjectExample example);

    PromotionDbObject selectByPrimaryKey(Integer promotionId);

    int updateByExampleSelective(@Param("record") PromotionDbObject record, @Param("example") PromotionDbObjectExample example);

    int updateByExampleWithBLOBs(@Param("record") PromotionDbObject record, @Param("example") PromotionDbObjectExample example);

    int updateByExample(@Param("record") PromotionDbObject record, @Param("example") PromotionDbObjectExample example);

    int updateByPrimaryKeySelective(PromotionDbObject record);

    int updateByPrimaryKeyWithBLOBs(PromotionDbObject record);

    int updateByPrimaryKey(PromotionDbObject record);
}