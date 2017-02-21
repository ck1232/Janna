package com.JJ.dao;

import com.JJ.model.Productsuboption;
import com.JJ.model.ProductsuboptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductsuboptionMapper {
    int countByExample(ProductsuboptionExample example);

    int deleteByExample(ProductsuboptionExample example);

    int deleteByPrimaryKey(Integer productsuboptionid);

    int insert(Productsuboption record);

    int insertSelective(Productsuboption record);

    List<Productsuboption> selectByExample(ProductsuboptionExample example);

    Productsuboption selectByPrimaryKey(Integer productsuboptionid);

    int updateByExampleSelective(@Param("record") Productsuboption record, @Param("example") ProductsuboptionExample example);

    int updateByExample(@Param("record") Productsuboption record, @Param("example") ProductsuboptionExample example);

    int updateByPrimaryKeySelective(Productsuboption record);

    int updateByPrimaryKey(Productsuboption record);
}