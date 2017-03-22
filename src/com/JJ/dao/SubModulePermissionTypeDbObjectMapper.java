package com.JJ.dao;

import com.JJ.model.SubModulePermissionTypeDbObject;
import com.JJ.model.SubModulePermissionTypeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubModulePermissionTypeDbObjectMapper {
    int countByExample(SubModulePermissionTypeDbObjectExample example);

    int deleteByExample(SubModulePermissionTypeDbObjectExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(SubModulePermissionTypeDbObject record);

    int insertSelective(SubModulePermissionTypeDbObject record);

    List<SubModulePermissionTypeDbObject> selectByExample(SubModulePermissionTypeDbObjectExample example);

    SubModulePermissionTypeDbObject selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") SubModulePermissionTypeDbObject record, @Param("example") SubModulePermissionTypeDbObjectExample example);

    int updateByExample(@Param("record") SubModulePermissionTypeDbObject record, @Param("example") SubModulePermissionTypeDbObjectExample example);

    int updateByPrimaryKeySelective(SubModulePermissionTypeDbObject record);

    int updateByPrimaryKey(SubModulePermissionTypeDbObject record);
}