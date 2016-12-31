package com.JJ.dao;

import com.JJ.model.BatchproductRs;
import com.JJ.model.BatchproductRsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BatchproductRsMapper {
    int countByExample(BatchproductRsExample example);

    int deleteByExample(BatchproductRsExample example);

    int deleteByPrimaryKey(Integer batchproductid);

    int insert(BatchproductRs record);

    int insertSelective(BatchproductRs record);

    List<BatchproductRs> selectByExample(BatchproductRsExample example);

    BatchproductRs selectByPrimaryKey(Integer batchproductid);

    int updateByExampleSelective(@Param("record") BatchproductRs record, @Param("example") BatchproductRsExample example);

    int updateByExample(@Param("record") BatchproductRs record, @Param("example") BatchproductRsExample example);

    int updateByPrimaryKeySelective(BatchproductRs record);

    int updateByPrimaryKey(BatchproductRs record);
}