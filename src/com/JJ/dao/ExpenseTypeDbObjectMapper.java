package com.JJ.dao;

import com.JJ.model.ExpenseTypeDbObject;
import com.JJ.model.ExpenseTypeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenseTypeDbObjectMapper {
    int countByExample(ExpenseTypeDbObjectExample example);

    int deleteByExample(ExpenseTypeDbObjectExample example);

    int deleteByPrimaryKey(Integer expenseTypeId);

    int insert(ExpenseTypeDbObject record);

    int insertSelective(ExpenseTypeDbObject record);

    List<ExpenseTypeDbObject> selectByExample(ExpenseTypeDbObjectExample example);

    ExpenseTypeDbObject selectByPrimaryKey(Integer expenseTypeId);

    int updateByExampleSelective(@Param("record") ExpenseTypeDbObject record, @Param("example") ExpenseTypeDbObjectExample example);

    int updateByExample(@Param("record") ExpenseTypeDbObject record, @Param("example") ExpenseTypeDbObjectExample example);

    int updateByPrimaryKeySelective(ExpenseTypeDbObject record);

    int updateByPrimaryKey(ExpenseTypeDbObject record);
}