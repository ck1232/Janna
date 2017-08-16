package com.JJ.dao;

import com.JJ.model.ImageLinkRsDbObject;
import com.JJ.model.ImageLinkRsDbObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageLinkRsDbObjectMapper {
    int countByExample(ImageLinkRsDbObjectExample example);

    int deleteByExample(ImageLinkRsDbObjectExample example);

    int deleteByPrimaryKey(Integer imageLinkRsId);

    int insert(ImageLinkRsDbObject record);

    int insertSelective(ImageLinkRsDbObject record);

    List<ImageLinkRsDbObject> selectByExample(ImageLinkRsDbObjectExample example);

    ImageLinkRsDbObject selectByPrimaryKey(Integer imageLinkRsId);

    int updateByExampleSelective(@Param("record") ImageLinkRsDbObject record, @Param("example") ImageLinkRsDbObjectExample example);

    int updateByExample(@Param("record") ImageLinkRsDbObject record, @Param("example") ImageLinkRsDbObjectExample example);

    int updateByPrimaryKeySelective(ImageLinkRsDbObject record);

    int updateByPrimaryKey(ImageLinkRsDbObject record);
}