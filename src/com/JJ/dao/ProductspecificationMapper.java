package com.JJ.dao;

import com.JJ.model.Productspecification;
import com.JJ.model.ProductspecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductspecificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int countByExample(ProductspecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int deleteByExample(ProductspecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int deleteByPrimaryKey(Integer productspecificationid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int insert(Productspecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int insertSelective(Productspecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    List<Productspecification> selectByExampleWithBLOBs(ProductspecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    List<Productspecification> selectByExample(ProductspecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    Productspecification selectByPrimaryKey(Integer productspecificationid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int updateByExampleSelective(@Param("record") Productspecification record, @Param("example") ProductspecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int updateByExampleWithBLOBs(@Param("record") Productspecification record, @Param("example") ProductspecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int updateByExample(@Param("record") Productspecification record, @Param("example") ProductspecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int updateByPrimaryKeySelective(Productspecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int updateByPrimaryKeyWithBLOBs(Productspecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productspecification
     *
     * @mbggenerated Sun Nov 20 20:43:32 SGT 2016
     */
    int updateByPrimaryKey(Productspecification record);
}