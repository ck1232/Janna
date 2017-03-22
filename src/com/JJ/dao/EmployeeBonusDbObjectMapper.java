package com.JJ.dao;

import com.JJ.model.EmployeeBonusDbObject;
import com.JJ.model.EmployeeBonusDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeBonusDbObjectMapper {
    int countByExample(EmployeeBonusDbObjectExample example);

    int deleteByExample(EmployeeBonusDbObjectExample example);

    int deleteByPrimaryKey(Integer bonusId);

    int insert(EmployeeBonusDbObject record);

    int insertSelective(EmployeeBonusDbObject record);

    List<EmployeeBonusDbObject> selectByExample(EmployeeBonusDbObjectExample example);

    EmployeeBonusDbObject selectByPrimaryKey(Integer bonusId);

    int updateByExampleSelective(@Param("record") EmployeeBonusDbObject record, @Param("example") EmployeeBonusDbObjectExample example);

    int updateByExample(@Param("record") EmployeeBonusDbObject record, @Param("example") EmployeeBonusDbObjectExample example);

    int updateByPrimaryKeySelective(EmployeeBonusDbObject record);

    int updateByPrimaryKey(EmployeeBonusDbObject record);
}