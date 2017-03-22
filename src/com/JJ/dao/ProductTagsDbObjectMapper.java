package com.JJ.dao;

import com.JJ.model.ProductTagsDbObject;
import com.JJ.model.ProductTagsDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductTagsDbObjectMapper {
    int countByExample(ProductTagsDbObjectExample example);

    int deleteByExample(ProductTagsDbObjectExample example);

    int deleteByPrimaryKey(Integer tagsId);

    int insert(ProductTagsDbObject record);

    int insertSelective(ProductTagsDbObject record);

    List<ProductTagsDbObject> selectByExample(ProductTagsDbObjectExample example);

    ProductTagsDbObject selectByPrimaryKey(Integer tagsId);

    int updateByExampleSelective(@Param("record") ProductTagsDbObject record, @Param("example") ProductTagsDbObjectExample example);

    int updateByExample(@Param("record") ProductTagsDbObject record, @Param("example") ProductTagsDbObjectExample example);

    int updateByPrimaryKeySelective(ProductTagsDbObject record);

    int updateByPrimaryKey(ProductTagsDbObject record);
}