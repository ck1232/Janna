package com.JJ.dao;

import com.JJ.model.Productoption;
import com.JJ.model.ProductoptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductoptionMapper {
    int countByExample(ProductoptionExample example);

    int deleteByExample(ProductoptionExample example);

    int deleteByPrimaryKey(Integer productoptionid);

    int insert(Productoption record);

    int insertSelective(Productoption record);

    List<Productoption> selectByExample(ProductoptionExample example);

    Productoption selectByPrimaryKey(Integer productoptionid);

    int updateByExampleSelective(@Param("record") Productoption record, @Param("example") ProductoptionExample example);

    int updateByExample(@Param("record") Productoption record, @Param("example") ProductoptionExample example);

    int updateByPrimaryKeySelective(Productoption record);

    int updateByPrimaryKey(Productoption record);
}