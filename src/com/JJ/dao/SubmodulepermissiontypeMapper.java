package com.JJ.dao;

import com.JJ.model.Submodulepermissiontype;
import com.JJ.model.SubmodulepermissiontypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubmodulepermissiontypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int countByExample(SubmodulepermissiontypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int deleteByExample(SubmodulepermissiontypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int insert(Submodulepermissiontype record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int insertSelective(Submodulepermissiontype record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	List<Submodulepermissiontype> selectByExample(SubmodulepermissiontypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	Submodulepermissiontype selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int updateByExampleSelective(@Param("record") Submodulepermissiontype record,
			@Param("example") SubmodulepermissiontypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int updateByExample(@Param("record") Submodulepermissiontype record,
			@Param("example") SubmodulepermissiontypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int updateByPrimaryKeySelective(Submodulepermissiontype record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table submodulepermissiontype
	 * @mbggenerated  Sat Oct 22 17:26:22 SGT 2016
	 */
	int updateByPrimaryKey(Submodulepermissiontype record);
}