package com.JJ.dao;

import com.JJ.model.SubModulePermissionDbObject;
import com.JJ.model.SubModulePermissionDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubModulePermissionDbObjectMapper {
    int countByExample(SubModulePermissionDbObjectExample example);

    int deleteByExample(SubModulePermissionDbObjectExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(SubModulePermissionDbObject record);

    int insertSelective(SubModulePermissionDbObject record);

    List<SubModulePermissionDbObject> selectByExample(SubModulePermissionDbObjectExample example);

    SubModulePermissionDbObject selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") SubModulePermissionDbObject record, @Param("example") SubModulePermissionDbObjectExample example);

    int updateByExample(@Param("record") SubModulePermissionDbObject record, @Param("example") SubModulePermissionDbObjectExample example);

    int updateByPrimaryKeySelective(SubModulePermissionDbObject record);

    int updateByPrimaryKey(SubModulePermissionDbObject record);
}