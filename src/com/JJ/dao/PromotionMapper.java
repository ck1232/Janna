package com.JJ.dao;

import com.JJ.model.Promotion;
import com.JJ.model.PromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int countByExample(PromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int deleteByExample(PromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int deleteByPrimaryKey(Integer promotionid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int insert(Promotion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int insertSelective(Promotion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	List<Promotion> selectByExample(PromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	Promotion selectByPrimaryKey(Integer promotionid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int updateByExampleSelective(@Param("record") Promotion record, @Param("example") PromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int updateByExample(@Param("record") Promotion record, @Param("example") PromotionExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int updateByPrimaryKeySelective(Promotion record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table promotion
	 * @mbggenerated  Wed Nov 09 23:39:17 SGT 2016
	 */
	int updateByPrimaryKey(Promotion record);
}