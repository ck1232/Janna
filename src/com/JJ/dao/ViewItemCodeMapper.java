package com.JJ.dao;

import com.JJ.model.ViewItemCode;
import com.JJ.model.ViewItemCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewItemCodeMapper {
    int countByExample(ViewItemCodeExample example);

    int deleteByExample(ViewItemCodeExample example);

    int insert(ViewItemCode record);

    int insertSelective(ViewItemCode record);

    List<ViewItemCode> selectByExample(ViewItemCodeExample example);

    int updateByExampleSelective(@Param("record") ViewItemCode record, @Param("example") ViewItemCodeExample example);

    int updateByExample(@Param("record") ViewItemCode record, @Param("example") ViewItemCodeExample example);
}