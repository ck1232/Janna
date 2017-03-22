package com.JJ.dao;

import com.JJ.model.EmployeeSalaryDbObject;
import com.JJ.model.EmployeeSalaryDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeSalaryDbObjectMapper {
    int countByExample(EmployeeSalaryDbObjectExample example);

    int deleteByExample(EmployeeSalaryDbObjectExample example);

    int deleteByPrimaryKey(Integer salaryId);

    int insert(EmployeeSalaryDbObject record);

    int insertSelective(EmployeeSalaryDbObject record);

    List<EmployeeSalaryDbObject> selectByExample(EmployeeSalaryDbObjectExample example);

    EmployeeSalaryDbObject selectByPrimaryKey(Integer salaryId);

    int updateByExampleSelective(@Param("record") EmployeeSalaryDbObject record, @Param("example") EmployeeSalaryDbObjectExample example);

    int updateByExample(@Param("record") EmployeeSalaryDbObject record, @Param("example") EmployeeSalaryDbObjectExample example);

    int updateByPrimaryKeySelective(EmployeeSalaryDbObject record);

    int updateByPrimaryKey(EmployeeSalaryDbObject record);
}