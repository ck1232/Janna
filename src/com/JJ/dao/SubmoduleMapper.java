package com.JJ.dao;

import com.JJ.model.Submodule;
import com.JJ.model.SubmoduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubmoduleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int countByExample(SubmoduleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int deleteByExample(SubmoduleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int insert(Submodule record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int insertSelective(Submodule record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	List<Submodule> selectByExample(SubmoduleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	Submodule selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int updateByExampleSelective(@Param("record") Submodule record, @Param("example") SubmoduleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int updateByExample(@Param("record") Submodule record, @Param("example") SubmoduleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int updateByPrimaryKeySelective(Submodule record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodule
	 * @mbggenerated  Wed Nov 09 23:39:36 SGT 2016
	 */
	int updateByPrimaryKey(Submodule record);
}