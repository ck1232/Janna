package com.JJ.dao;

import com.JJ.model.RoleDbObject;
import com.JJ.model.RoleDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDbObjectMapper {
    int countByExample(RoleDbObjectExample example);

    int deleteByExample(RoleDbObjectExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleDbObject record);

    int insertSelective(RoleDbObject record);

    List<RoleDbObject> selectByExample(RoleDbObjectExample example);

    RoleDbObject selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") RoleDbObject record, @Param("example") RoleDbObjectExample example);

    int updateByExample(@Param("record") RoleDbObject record, @Param("example") RoleDbObjectExample example);

    int updateByPrimaryKeySelective(RoleDbObject record);

    int updateByPrimaryKey(RoleDbObject record);
}