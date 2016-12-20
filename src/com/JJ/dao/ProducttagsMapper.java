package com.JJ.dao;

import com.JJ.model.Producttags;
import com.JJ.model.ProducttagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProducttagsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int countByExample(ProducttagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int deleteByExample(ProducttagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int deleteByPrimaryKey(Integer tagsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int insert(Producttags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int insertSelective(Producttags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    List<Producttags> selectByExample(ProducttagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    Producttags selectByPrimaryKey(Integer tagsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int updateByExampleSelective(@Param("record") Producttags record, @Param("example") ProducttagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int updateByExample(@Param("record") Producttags record, @Param("example") ProducttagsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int updateByPrimaryKeySelective(Producttags record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table producttags
     *
     * @mbggenerated Mon Dec 05 12:17:14 SGT 2016
     */
    int updateByPrimaryKey(Producttags record);
}