package com.JJ.dao;

import com.JJ.model.EmployeeBonus;
import com.JJ.model.EmployeeBonusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeBonusMapper {
    int countByExample(EmployeeBonusExample example);

    int deleteByExample(EmployeeBonusExample example);

    int deleteByPrimaryKey(Integer bonusid);

    int insert(EmployeeBonus record);

    int insertSelective(EmployeeBonus record);

    List<EmployeeBonus> selectByExample(EmployeeBonusExample example);

    EmployeeBonus selectByPrimaryKey(Integer bonusid);

    int updateByExampleSelective(@Param("record") EmployeeBonus record, @Param("example") EmployeeBonusExample example);

    int updateByExample(@Param("record") EmployeeBonus record, @Param("example") EmployeeBonusExample example);

    int updateByPrimaryKeySelective(EmployeeBonus record);

    int updateByPrimaryKey(EmployeeBonus record);
}