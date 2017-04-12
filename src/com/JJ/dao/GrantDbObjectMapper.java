package com.JJ.dao;

import com.JJ.model.GrantDbObject;
import com.JJ.model.GrantDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GrantDbObjectMapper {
    int countByExample(GrantDbObjectExample example);

    int deleteByExample(GrantDbObjectExample example);

    int deleteByPrimaryKey(Integer grantId);

    int insert(GrantDbObject record);

    int insertSelective(GrantDbObject record);

    List<GrantDbObject> selectByExample(GrantDbObjectExample example);

    GrantDbObject selectByPrimaryKey(Integer grantId);

    int updateByExampleSelective(@Param("record") GrantDbObject record, @Param("example") GrantDbObjectExample example);

    int updateByExample(@Param("record") GrantDbObject record, @Param("example") GrantDbObjectExample example);

    int updateByPrimaryKeySelective(GrantDbObject record);

    int updateByPrimaryKey(GrantDbObject record);
}