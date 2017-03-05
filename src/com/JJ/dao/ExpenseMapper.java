package com.JJ.dao;

import com.JJ.model.Expense;
import com.JJ.model.ExpenseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenseMapper {
    int countByExample(ExpenseExample example);

    int deleteByExample(ExpenseExample example);

    int deleteByPrimaryKey(Integer expenseid);

    int insert(Expense record);

    int insertSelective(Expense record);

    List<Expense> selectByExample(ExpenseExample example);

    Expense selectByPrimaryKey(Integer expenseid);

    int updateByExampleSelective(@Param("record") Expense record, @Param("example") ExpenseExample example);

    int updateByExample(@Param("record") Expense record, @Param("example") ExpenseExample example);

    int updateByPrimaryKeySelective(Expense record);

    int updateByPrimaryKey(Expense record);
}