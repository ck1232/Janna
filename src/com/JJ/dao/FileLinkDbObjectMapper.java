package com.JJ.dao;

import com.JJ.model.FileLinkDbObject;
import com.JJ.model.FileLinkDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileLinkDbObjectMapper {
    int countByExample(FileLinkDbObjectExample example);

    int deleteByExample(FileLinkDbObjectExample example);

    int deleteByPrimaryKey(Integer fileLinkId);

    int insert(FileLinkDbObject record);

    int insertSelective(FileLinkDbObject record);

    List<FileLinkDbObject> selectByExample(FileLinkDbObjectExample example);

    FileLinkDbObject selectByPrimaryKey(Integer fileLinkId);

    int updateByExampleSelective(@Param("record") FileLinkDbObject record, @Param("example") FileLinkDbObjectExample example);

    int updateByExample(@Param("record") FileLinkDbObject record, @Param("example") FileLinkDbObjectExample example);

    int updateByPrimaryKeySelective(FileLinkDbObject record);

    int updateByPrimaryKey(FileLinkDbObject record);
}