package com.JJ.dao;

import com.JJ.model.ModuleDbObject;
import com.JJ.model.ModuleDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleDbObjectMapper {
    int countByExample(ModuleDbObjectExample example);

    int deleteByExample(ModuleDbObjectExample example);

    int deleteByPrimaryKey(Integer moduleId);

    int insert(ModuleDbObject record);

    int insertSelective(ModuleDbObject record);

    List<ModuleDbObject> selectByExample(ModuleDbObjectExample example);

    ModuleDbObject selectByPrimaryKey(Integer moduleId);

    int updateByExampleSelective(@Param("record") ModuleDbObject record, @Param("example") ModuleDbObjectExample example);

    int updateByExample(@Param("record") ModuleDbObject record, @Param("example") ModuleDbObjectExample example);

    int updateByPrimaryKeySelective(ModuleDbObject record);

    int updateByPrimaryKey(ModuleDbObject record);
}