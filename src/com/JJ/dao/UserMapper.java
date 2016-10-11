package com.JJ.dao;

import com.JJ.model.User;
import com.JJ.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int insert(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int insertSelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	User selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Mon Oct 10 23:44:35 SGT 2016
	 */
	int updateByPrimaryKey(User record);
}