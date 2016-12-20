package com.JJ.dao;

import com.JJ.model.ViewProductInventoryLocation;
import com.JJ.model.ViewProductInventoryLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewProductInventoryLocationMapper {
    int countByExample(ViewProductInventoryLocationExample example);

    int deleteByExample(ViewProductInventoryLocationExample example);

    int insert(ViewProductInventoryLocation record);

    int insertSelective(ViewProductInventoryLocation record);

    List<ViewProductInventoryLocation> selectByExample(ViewProductInventoryLocationExample example);

    int updateByExampleSelective(@Param("record") ViewProductInventoryLocation record, @Param("example") ViewProductInventoryLocationExample example);

    int updateByExample(@Param("record") ViewProductInventoryLocation record, @Param("example") ViewProductInventoryLocationExample example);
}