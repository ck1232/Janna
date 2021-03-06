package com.JJ.dao;

import com.JJ.model.Storagelocation;
import com.JJ.model.StoragelocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoragelocationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int countByExample(StoragelocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int deleteByExample(StoragelocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int deleteByPrimaryKey(Integer locationid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int insert(Storagelocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int insertSelective(Storagelocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    List<Storagelocation> selectByExample(StoragelocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    Storagelocation selectByPrimaryKey(Integer locationid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int updateByExampleSelective(@Param("record") Storagelocation record, @Param("example") StoragelocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int updateByExample(@Param("record") Storagelocation record, @Param("example") StoragelocationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int updateByPrimaryKeySelective(Storagelocation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storagelocation
     *
     * @mbggenerated Tue Dec 06 21:53:27 SGT 2016
     */
    int updateByPrimaryKey(Storagelocation record);
}