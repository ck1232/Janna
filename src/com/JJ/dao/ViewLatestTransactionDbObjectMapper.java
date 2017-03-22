package com.JJ.dao;

import com.JJ.model.ViewLatestTransactionDbObject;
import com.JJ.model.ViewLatestTransactionDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewLatestTransactionDbObjectMapper {
    int countByExample(ViewLatestTransactionDbObjectExample example);

    int deleteByExample(ViewLatestTransactionDbObjectExample example);

    int insert(ViewLatestTransactionDbObject record);

    int insertSelective(ViewLatestTransactionDbObject record);

    List<ViewLatestTransactionDbObject> selectByExample(ViewLatestTransactionDbObjectExample example);

    int updateByExampleSelective(@Param("record") ViewLatestTransactionDbObject record, @Param("example") ViewLatestTransactionDbObjectExample example);

    int updateByExample(@Param("record") ViewLatestTransactionDbObject record, @Param("example") ViewLatestTransactionDbObjectExample example);
}