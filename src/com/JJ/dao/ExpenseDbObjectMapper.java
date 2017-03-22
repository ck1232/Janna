package com.JJ.dao;

import com.JJ.model.ExpenseDbObject;
import com.JJ.model.ExpenseDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenseDbObjectMapper {
    int countByExample(ExpenseDbObjectExample example);

    int deleteByExample(ExpenseDbObjectExample example);

    int deleteByPrimaryKey(Integer expenseId);

    int insert(ExpenseDbObject record);

    int insertSelective(ExpenseDbObject record);

    List<ExpenseDbObject> selectByExample(ExpenseDbObjectExample example);

    ExpenseDbObject selectByPrimaryKey(Integer expenseId);

    int updateByExampleSelective(@Param("record") ExpenseDbObject record, @Param("example") ExpenseDbObjectExample example);

    int updateByExample(@Param("record") ExpenseDbObject record, @Param("example") ExpenseDbObjectExample example);

    int updateByPrimaryKeySelective(ExpenseDbObject record);

    int updateByPrimaryKey(ExpenseDbObject record);
}