package com.JJ.dao;

import com.JJ.model.StorageLocationDbObject;
import com.JJ.model.StorageLocationDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageLocationDbObjectMapper {
    int countByExample(StorageLocationDbObjectExample example);

    int deleteByExample(StorageLocationDbObjectExample example);

    int deleteByPrimaryKey(Integer locationId);

    int insert(StorageLocationDbObject record);

    int insertSelective(StorageLocationDbObject record);

    List<StorageLocationDbObject> selectByExample(StorageLocationDbObjectExample example);

    StorageLocationDbObject selectByPrimaryKey(Integer locationId);

    int updateByExampleSelective(@Param("record") StorageLocationDbObject record, @Param("example") StorageLocationDbObjectExample example);

    int updateByExample(@Param("record") StorageLocationDbObject record, @Param("example") StorageLocationDbObjectExample example);

    int updateByPrimaryKeySelective(StorageLocationDbObject record);

    int updateByPrimaryKey(StorageLocationDbObject record);
}