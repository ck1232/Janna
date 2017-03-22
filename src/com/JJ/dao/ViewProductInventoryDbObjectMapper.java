package com.JJ.dao;

import com.JJ.model.ViewProductInventoryDbObject;
import com.JJ.model.ViewProductInventoryDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewProductInventoryDbObjectMapper {
    int countByExample(ViewProductInventoryDbObjectExample example);

    int deleteByExample(ViewProductInventoryDbObjectExample example);

    int insert(ViewProductInventoryDbObject record);

    int insertSelective(ViewProductInventoryDbObject record);

    List<ViewProductInventoryDbObject> selectByExample(ViewProductInventoryDbObjectExample example);

    int updateByExampleSelective(@Param("record") ViewProductInventoryDbObject record, @Param("example") ViewProductInventoryDbObjectExample example);

    int updateByExample(@Param("record") ViewProductInventoryDbObject record, @Param("example") ViewProductInventoryDbObjectExample example);
}