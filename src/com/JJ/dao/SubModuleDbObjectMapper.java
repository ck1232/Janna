package com.JJ.dao;

import com.JJ.model.SubModuleDbObject;
import com.JJ.model.SubModuleDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubModuleDbObjectMapper {
    int countByExample(SubModuleDbObjectExample example);

    int deleteByExample(SubModuleDbObjectExample example);

    int deleteByPrimaryKey(Integer submoduleId);

    int insert(SubModuleDbObject record);

    int insertSelective(SubModuleDbObject record);

    List<SubModuleDbObject> selectByExample(SubModuleDbObjectExample example);

    SubModuleDbObject selectByPrimaryKey(Integer submoduleId);

    int updateByExampleSelective(@Param("record") SubModuleDbObject record, @Param("example") SubModuleDbObjectExample example);

    int updateByExample(@Param("record") SubModuleDbObject record, @Param("example") SubModuleDbObjectExample example);

    int updateByPrimaryKeySelective(SubModuleDbObject record);

    int updateByPrimaryKey(SubModuleDbObject record);
}