package com.JJ.dao;

import com.JJ.model.ProductsuboptionRs;
import com.JJ.model.ProductsuboptionRsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductsuboptionRsMapper {
    int countByExample(ProductsuboptionRsExample example);

    int deleteByExample(ProductsuboptionRsExample example);

    int deleteByPrimaryKey(Integer productsuboptionid);

    int insert(ProductsuboptionRs record);

    int insertSelective(ProductsuboptionRs record);

    List<ProductsuboptionRs> selectByExample(ProductsuboptionRsExample example);

    ProductsuboptionRs selectByPrimaryKey(Integer productsuboptionid);

    int updateByExampleSelective(@Param("record") ProductsuboptionRs record, @Param("example") ProductsuboptionRsExample example);

    int updateByExample(@Param("record") ProductsuboptionRs record, @Param("example") ProductsuboptionRsExample example);

    int updateByPrimaryKeySelective(ProductsuboptionRs record);

    int updateByPrimaryKey(ProductsuboptionRs record);
}