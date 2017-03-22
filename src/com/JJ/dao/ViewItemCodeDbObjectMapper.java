package com.JJ.dao;

import com.JJ.model.ViewItemCodeDbObject;
import com.JJ.model.ViewItemCodeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewItemCodeDbObjectMapper {
    int countByExample(ViewItemCodeDbObjectExample example);

    int deleteByExample(ViewItemCodeDbObjectExample example);

    int insert(ViewItemCodeDbObject record);

    int insertSelective(ViewItemCodeDbObject record);

    List<ViewItemCodeDbObject> selectByExample(ViewItemCodeDbObjectExample example);

    int updateByExampleSelective(@Param("record") ViewItemCodeDbObject record, @Param("example") ViewItemCodeDbObjectExample example);

    int updateByExample(@Param("record") ViewItemCodeDbObject record, @Param("example") ViewItemCodeDbObjectExample example);
}