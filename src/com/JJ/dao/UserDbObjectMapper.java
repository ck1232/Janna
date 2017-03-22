package com.JJ.dao;

import com.JJ.model.UserDbObject;
import com.JJ.model.UserDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDbObjectMapper {
    int countByExample(UserDbObjectExample example);

    int deleteByExample(UserDbObjectExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserDbObject record);

    int insertSelective(UserDbObject record);

    List<UserDbObject> selectByExample(UserDbObjectExample example);

    UserDbObject selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserDbObject record, @Param("example") UserDbObjectExample example);

    int updateByExample(@Param("record") UserDbObject record, @Param("example") UserDbObjectExample example);

    int updateByPrimaryKeySelective(UserDbObject record);

    int updateByPrimaryKey(UserDbObject record);
}