package com.JJ.dao;

import com.JJ.model.UserRoleDbObject;
import com.JJ.model.UserRoleDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDbObjectMapper {
    int countByExample(UserRoleDbObjectExample example);

    int deleteByExample(UserRoleDbObjectExample example);

    int deleteByPrimaryKey(Integer userRoleId);

    int insert(UserRoleDbObject record);

    int insertSelective(UserRoleDbObject record);

    List<UserRoleDbObject> selectByExample(UserRoleDbObjectExample example);

    UserRoleDbObject selectByPrimaryKey(Integer userRoleId);

    int updateByExampleSelective(@Param("record") UserRoleDbObject record, @Param("example") UserRoleDbObjectExample example);

    int updateByExample(@Param("record") UserRoleDbObject record, @Param("example") UserRoleDbObjectExample example);

    int updateByPrimaryKeySelective(UserRoleDbObject record);

    int updateByPrimaryKey(UserRoleDbObject record);
}