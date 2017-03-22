package com.JJ.dao;

import com.JJ.model.BatchStockIntakeDbObject;
import com.JJ.model.BatchStockIntakeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchStockIntakeDbObjectMapper {
    int countByExample(BatchStockIntakeDbObjectExample example);

    int deleteByExample(BatchStockIntakeDbObjectExample example);

    int deleteByPrimaryKey(Integer batchId);

    int insert(BatchStockIntakeDbObject record);

    int insertSelective(BatchStockIntakeDbObject record);

    List<BatchStockIntakeDbObject> selectByExample(BatchStockIntakeDbObjectExample example);

    BatchStockIntakeDbObject selectByPrimaryKey(Integer batchId);

    int updateByExampleSelective(@Param("record") BatchStockIntakeDbObject record, @Param("example") BatchStockIntakeDbObjectExample example);

    int updateByExample(@Param("record") BatchStockIntakeDbObject record, @Param("example") BatchStockIntakeDbObjectExample example);

    int updateByPrimaryKeySelective(BatchStockIntakeDbObject record);

    int updateByPrimaryKey(BatchStockIntakeDbObject record);
}