package com.JJ.dao;

import com.JJ.model.BatchProductRsDbObject;
import com.JJ.model.BatchProductRsDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchProductRsDbObjectMapper {
    int countByExample(BatchProductRsDbObjectExample example);

    int deleteByExample(BatchProductRsDbObjectExample example);

    int deleteByPrimaryKey(Integer batchProductRsId);

    int insert(BatchProductRsDbObject record);

    int insertSelective(BatchProductRsDbObject record);

    List<BatchProductRsDbObject> selectByExample(BatchProductRsDbObjectExample example);

    BatchProductRsDbObject selectByPrimaryKey(Integer batchProductRsId);

    int updateByExampleSelective(@Param("record") BatchProductRsDbObject record, @Param("example") BatchProductRsDbObjectExample example);

    int updateByExample(@Param("record") BatchProductRsDbObject record, @Param("example") BatchProductRsDbObjectExample example);

    int updateByPrimaryKeySelective(BatchProductRsDbObject record);

    int updateByPrimaryKey(BatchProductRsDbObject record);
}