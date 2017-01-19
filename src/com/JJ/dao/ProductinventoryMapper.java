package com.JJ.dao;

import com.JJ.model.Productinventory;
import com.JJ.model.ProductinventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductinventoryMapper {
    int countByExample(ProductinventoryExample example);

    int deleteByExample(ProductinventoryExample example);

    int deleteByPrimaryKey(Integer productinventoryid);

    int insert(Productinventory record);

    int insertSelective(Productinventory record);

    List<Productinventory> selectByExample(ProductinventoryExample example);

    Productinventory selectByPrimaryKey(Integer productinventoryid);

    int updateByExampleSelective(@Param("record") Productinventory record, @Param("example") ProductinventoryExample example);

    int updateByExample(@Param("record") Productinventory record, @Param("example") ProductinventoryExample example);

    int updateByPrimaryKeySelective(Productinventory record);

    int updateByPrimaryKey(Productinventory record);
}