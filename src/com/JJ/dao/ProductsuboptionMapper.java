package com.JJ.dao;

import com.JJ.model.Productsuboption;
import com.JJ.model.ProductsuboptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductsuboptionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int countByExample(ProductsuboptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int deleteByExample(ProductsuboptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int deleteByPrimaryKey(Integer productsuboptionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int insert(Productsuboption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int insertSelective(Productsuboption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    List<Productsuboption> selectByExample(ProductsuboptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    Productsuboption selectByPrimaryKey(Integer productsuboptionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int updateByExampleSelective(@Param("record") Productsuboption record, @Param("example") ProductsuboptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int updateByExample(@Param("record") Productsuboption record, @Param("example") ProductsuboptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int updateByPrimaryKeySelective(Productsuboption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productsuboption
     *
     * @mbggenerated Thu Nov 10 22:03:29 SGT 2016
     */
    int updateByPrimaryKey(Productsuboption record);
}