package com.JJ.dao;

import com.JJ.model.EmployeeSalary;
import com.JJ.model.EmployeeSalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeSalaryMapper {
    int countByExample(EmployeeSalaryExample example);

    int deleteByExample(EmployeeSalaryExample example);

    int deleteByPrimaryKey(Integer salaryid);

    int insert(EmployeeSalary record);

    int insertSelective(EmployeeSalary record);

    List<EmployeeSalary> selectByExample(EmployeeSalaryExample example);

    EmployeeSalary selectByPrimaryKey(Integer salaryid);

    int updateByExampleSelective(@Param("record") EmployeeSalary record, @Param("example") EmployeeSalaryExample example);

    int updateByExample(@Param("record") EmployeeSalary record, @Param("example") EmployeeSalaryExample example);

    int updateByPrimaryKeySelective(EmployeeSalary record);

    int updateByPrimaryKey(EmployeeSalary record);
}