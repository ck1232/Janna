package com.JJ.dao;

import com.JJ.model.ChequeDbObject;
import com.JJ.model.ChequeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChequeDbObjectMapper {
    int countByExample(ChequeDbObjectExample example);

    int deleteByExample(ChequeDbObjectExample example);

    int deleteByPrimaryKey(Integer chequeId);

    int insert(ChequeDbObject record);

    int insertSelective(ChequeDbObject record);

    List<ChequeDbObject> selectByExample(ChequeDbObjectExample example);

    ChequeDbObject selectByPrimaryKey(Integer chequeId);

    int updateByExampleSelective(@Param("record") ChequeDbObject record, @Param("example") ChequeDbObjectExample example);

    int updateByExample(@Param("record") ChequeDbObject record, @Param("example") ChequeDbObjectExample example);

    int updateByPrimaryKeySelective(ChequeDbObject record);

    int updateByPrimaryKey(ChequeDbObject record);
}