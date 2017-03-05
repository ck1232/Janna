package com.JJ.dao;

import com.JJ.model.ExpenseType;
import com.JJ.model.ExpenseTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenseTypeMapper {
    int countByExample(ExpenseTypeExample example);

    int deleteByExample(ExpenseTypeExample example);

    int deleteByPrimaryKey(Integer expensetypeid);

    int insert(ExpenseType record);

    int insertSelective(ExpenseType record);

    List<ExpenseType> selectByExample(ExpenseTypeExample example);

    ExpenseType selectByPrimaryKey(Integer expensetypeid);

    int updateByExampleSelective(@Param("record") ExpenseType record, @Param("example") ExpenseTypeExample example);

    int updateByExample(@Param("record") ExpenseType record, @Param("example") ExpenseTypeExample example);

    int updateByPrimaryKeySelective(ExpenseType record);

    int updateByPrimaryKey(ExpenseType record);
}