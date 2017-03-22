package com.JJ.dao;

import com.JJ.model.ViewProductInventoryLocationDbObject;
import com.JJ.model.ViewProductInventoryLocationDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewProductInventoryLocationDbObjectMapper {
    int countByExample(ViewProductInventoryLocationDbObjectExample example);

    int deleteByExample(ViewProductInventoryLocationDbObjectExample example);

    int insert(ViewProductInventoryLocationDbObject record);

    int insertSelective(ViewProductInventoryLocationDbObject record);

    List<ViewProductInventoryLocationDbObject> selectByExample(ViewProductInventoryLocationDbObjectExample example);

    int updateByExampleSelective(@Param("record") ViewProductInventoryLocationDbObject record, @Param("example") ViewProductInventoryLocationDbObjectExample example);

    int updateByExample(@Param("record") ViewProductInventoryLocationDbObject record, @Param("example") ViewProductInventoryLocationDbObjectExample example);
}