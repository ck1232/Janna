package com.JJ.dao;

import com.JJ.model.EmployeeDbObject;
import com.JJ.model.EmployeeDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDbObjectMapper {
    int countByExample(EmployeeDbObjectExample example);

    int deleteByExample(EmployeeDbObjectExample example);

    int deleteByPrimaryKey(Integer employeeId);

    int insert(EmployeeDbObject record);

    int insertSelective(EmployeeDbObject record);

    List<EmployeeDbObject> selectByExample(EmployeeDbObjectExample example);

    EmployeeDbObject selectByPrimaryKey(Integer employeeId);

    int updateByExampleSelective(@Param("record") EmployeeDbObject record, @Param("example") EmployeeDbObjectExample example);

    int updateByExample(@Param("record") EmployeeDbObject record, @Param("example") EmployeeDbObjectExample example);

    int updateByPrimaryKeySelective(EmployeeDbObject record);

    int updateByPrimaryKey(EmployeeDbObject record);
}