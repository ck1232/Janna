package com.JJ.dao;

import com.JJ.model.ViewProductInventory;
import com.JJ.model.ViewProductInventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewProductInventoryMapper {
    int countByExample(ViewProductInventoryExample example);

    int deleteByExample(ViewProductInventoryExample example);

    int insert(ViewProductInventory record);

    int insertSelective(ViewProductInventory record);

    List<ViewProductInventory> selectByExample(ViewProductInventoryExample example);

    int updateByExampleSelective(@Param("record") ViewProductInventory record, @Param("example") ViewProductInventoryExample example);

    int updateByExample(@Param("record") ViewProductInventory record, @Param("example") ViewProductInventoryExample example);
}