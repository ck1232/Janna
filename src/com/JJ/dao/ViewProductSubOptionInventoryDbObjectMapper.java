package com.JJ.dao;

import com.JJ.model.ViewProductSubOptionInventoryDbObject;
import com.JJ.model.ViewProductSubOptionInventoryDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewProductSubOptionInventoryDbObjectMapper {
    int countByExample(ViewProductSubOptionInventoryDbObjectExample example);

    int deleteByExample(ViewProductSubOptionInventoryDbObjectExample example);

    int insert(ViewProductSubOptionInventoryDbObject record);

    int insertSelective(ViewProductSubOptionInventoryDbObject record);

    List<ViewProductSubOptionInventoryDbObject> selectByExample(ViewProductSubOptionInventoryDbObjectExample example);

    int updateByExampleSelective(@Param("record") ViewProductSubOptionInventoryDbObject record, @Param("example") ViewProductSubOptionInventoryDbObjectExample example);

    int updateByExample(@Param("record") ViewProductSubOptionInventoryDbObject record, @Param("example") ViewProductSubOptionInventoryDbObjectExample example);
}