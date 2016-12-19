package com.JJ.dao;

import com.JJ.model.ViewProductSuboptionInventory;
import com.JJ.model.ViewProductSuboptionInventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewProductSuboptionInventoryMapper {
    int countByExample(ViewProductSuboptionInventoryExample example);

    int deleteByExample(ViewProductSuboptionInventoryExample example);

    int insert(ViewProductSuboptionInventory record);

    int insertSelective(ViewProductSuboptionInventory record);

    List<ViewProductSuboptionInventory> selectByExample(ViewProductSuboptionInventoryExample example);

    int updateByExampleSelective(@Param("record") ViewProductSuboptionInventory record, @Param("example") ViewProductSuboptionInventoryExample example);

    int updateByExample(@Param("record") ViewProductSuboptionInventory record, @Param("example") ViewProductSuboptionInventoryExample example);
}