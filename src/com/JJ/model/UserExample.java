package com.JJ.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public UserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("userid is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userid is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(String value) {
			addCriterion("userid =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(String value) {
			addCriterion("userid <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(String value) {
			addCriterion("userid >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(String value) {
			addCriterion("userid >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(String value) {
			addCriterion("userid <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(String value) {
			addCriterion("userid <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLike(String value) {
			addCriterion("userid like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotLike(String value) {
			addCriterion("userid not like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<String> values) {
			addCriterion("userid in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<String> values) {
			addCriterion("userid not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(String value1, String value2) {
			addCriterion("userid between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(String value1, String value2) {
			addCriterion("userid not between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andEmailaddressIsNull() {
			addCriterion("emailaddress is null");
			return (Criteria) this;
		}

		public Criteria andEmailaddressIsNotNull() {
			addCriterion("emailaddress is not null");
			return (Criteria) this;
		}

		public Criteria andEmailaddressEqualTo(String value) {
			addCriterion("emailaddress =", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressNotEqualTo(String value) {
			addCriterion("emailaddress <>", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressGreaterThan(String value) {
			addCriterion("emailaddress >", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressGreaterThanOrEqualTo(String value) {
			addCriterion("emailaddress >=", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressLessThan(String value) {
			addCriterion("emailaddress <", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressLessThanOrEqualTo(String value) {
			addCriterion("emailaddress <=", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressLike(String value) {
			addCriterion("emailaddress like", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressNotLike(String value) {
			addCriterion("emailaddress not like", value, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressIn(List<String> values) {
			addCriterion("emailaddress in", values, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressNotIn(List<String> values) {
			addCriterion("emailaddress not in", values, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressBetween(String value1, String value2) {
			addCriterion("emailaddress between", value1, value2, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andEmailaddressNotBetween(String value1, String value2) {
			addCriterion("emailaddress not between", value1, value2, "emailaddress");
			return (Criteria) this;
		}

		public Criteria andLastlogintsIsNull() {
			addCriterion("lastlogints is null");
			return (Criteria) this;
		}

		public Criteria andLastlogintsIsNotNull() {
			addCriterion("lastlogints is not null");
			return (Criteria) this;
		}

		public Criteria andLastlogintsEqualTo(Date value) {
			addCriterion("lastlogints =", value, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsNotEqualTo(Date value) {
			addCriterion("lastlogints <>", value, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsGreaterThan(Date value) {
			addCriterion("lastlogints >", value, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsGreaterThanOrEqualTo(Date value) {
			addCriterion("lastlogints >=", value, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsLessThan(Date value) {
			addCriterion("lastlogints <", value, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsLessThanOrEqualTo(Date value) {
			addCriterion("lastlogints <=", value, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsIn(List<Date> values) {
			addCriterion("lastlogints in", values, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsNotIn(List<Date> values) {
			addCriterion("lastlogints not in", values, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsBetween(Date value1, Date value2) {
			addCriterion("lastlogints between", value1, value2, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andLastlogintsNotBetween(Date value1, Date value2) {
			addCriterion("lastlogints not between", value1, value2, "lastlogints");
			return (Criteria) this;
		}

		public Criteria andEnabledIsNull() {
			addCriterion("enabled is null");
			return (Criteria) this;
		}

		public Criteria andEnabledIsNotNull() {
			addCriterion("enabled is not null");
			return (Criteria) this;
		}

		public Criteria andEnabledEqualTo(Boolean value) {
			addCriterion("enabled =", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotEqualTo(Boolean value) {
			addCriterion("enabled <>", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledGreaterThan(Boolean value) {
			addCriterion("enabled >", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
			addCriterion("enabled >=", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledLessThan(Boolean value) {
			addCriterion("enabled <", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
			addCriterion("enabled <=", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledIn(List<Boolean> values) {
			addCriterion("enabled in", values, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotIn(List<Boolean> values) {
			addCriterion("enabled not in", values, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
			addCriterion("enabled between", value1, value2, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
			addCriterion("enabled not between", value1, value2, "enabled");
			return (Criteria) this;
		}

		public Criteria andDeleteindIsNull() {
			addCriterion("deleteInd is null");
			return (Criteria) this;
		}

		public Criteria andDeleteindIsNotNull() {
			addCriterion("deleteInd is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteindEqualTo(String value) {
			addCriterion("deleteInd =", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindNotEqualTo(String value) {
			addCriterion("deleteInd <>", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindGreaterThan(String value) {
			addCriterion("deleteInd >", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindGreaterThanOrEqualTo(String value) {
			addCriterion("deleteInd >=", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindLessThan(String value) {
			addCriterion("deleteInd <", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindLessThanOrEqualTo(String value) {
			addCriterion("deleteInd <=", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindLike(String value) {
			addCriterion("deleteInd like", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindNotLike(String value) {
			addCriterion("deleteInd not like", value, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindIn(List<String> values) {
			addCriterion("deleteInd in", values, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindNotIn(List<String> values) {
			addCriterion("deleteInd not in", values, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindBetween(String value1, String value2) {
			addCriterion("deleteInd between", value1, value2, "deleteind");
			return (Criteria) this;
		}

		public Criteria andDeleteindNotBetween(String value1, String value2) {
			addCriterion("deleteInd not between", value1, value2, "deleteind");
			return (Criteria) this;
		}

		public Criteria andCreatedbyIsNull() {
			addCriterion("createdby is null");
			return (Criteria) this;
		}

		public Criteria andCreatedbyIsNotNull() {
			addCriterion("createdby is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedbyEqualTo(String value) {
			addCriterion("createdby =", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyNotEqualTo(String value) {
			addCriterion("createdby <>", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyGreaterThan(String value) {
			addCriterion("createdby >", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyGreaterThanOrEqualTo(String value) {
			addCriterion("createdby >=", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyLessThan(String value) {
			addCriterion("createdby <", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyLessThanOrEqualTo(String value) {
			addCriterion("createdby <=", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyLike(String value) {
			addCriterion("createdby like", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyNotLike(String value) {
			addCriterion("createdby not like", value, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyIn(List<String> values) {
			addCriterion("createdby in", values, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyNotIn(List<String> values) {
			addCriterion("createdby not in", values, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyBetween(String value1, String value2) {
			addCriterion("createdby between", value1, value2, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedbyNotBetween(String value1, String value2) {
			addCriterion("createdby not between", value1, value2, "createdby");
			return (Criteria) this;
		}

		public Criteria andCreatedonIsNull() {
			addCriterion("createdon is null");
			return (Criteria) this;
		}

		public Criteria andCreatedonIsNotNull() {
			addCriterion("createdon is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedonEqualTo(Date value) {
			addCriterion("createdon =", value, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonNotEqualTo(Date value) {
			addCriterion("createdon <>", value, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonGreaterThan(Date value) {
			addCriterion("createdon >", value, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonGreaterThanOrEqualTo(Date value) {
			addCriterion("createdon >=", value, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonLessThan(Date value) {
			addCriterion("createdon <", value, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonLessThanOrEqualTo(Date value) {
			addCriterion("createdon <=", value, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonIn(List<Date> values) {
			addCriterion("createdon in", values, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonNotIn(List<Date> values) {
			addCriterion("createdon not in", values, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonBetween(Date value1, Date value2) {
			addCriterion("createdon between", value1, value2, "createdon");
			return (Criteria) this;
		}

		public Criteria andCreatedonNotBetween(Date value1, Date value2) {
			addCriterion("createdon not between", value1, value2, "createdon");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyIsNull() {
			addCriterion("updatedby is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyIsNotNull() {
			addCriterion("updatedby is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyEqualTo(String value) {
			addCriterion("updatedby =", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyNotEqualTo(String value) {
			addCriterion("updatedby <>", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyGreaterThan(String value) {
			addCriterion("updatedby >", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyGreaterThanOrEqualTo(String value) {
			addCriterion("updatedby >=", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyLessThan(String value) {
			addCriterion("updatedby <", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyLessThanOrEqualTo(String value) {
			addCriterion("updatedby <=", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyLike(String value) {
			addCriterion("updatedby like", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyNotLike(String value) {
			addCriterion("updatedby not like", value, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyIn(List<String> values) {
			addCriterion("updatedby in", values, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyNotIn(List<String> values) {
			addCriterion("updatedby not in", values, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyBetween(String value1, String value2) {
			addCriterion("updatedby between", value1, value2, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedbyNotBetween(String value1, String value2) {
			addCriterion("updatedby not between", value1, value2, "updatedby");
			return (Criteria) this;
		}

		public Criteria andUpdatedonIsNull() {
			addCriterion("updatedon is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedonIsNotNull() {
			addCriterion("updatedon is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedonEqualTo(Date value) {
			addCriterion("updatedon =", value, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonNotEqualTo(Date value) {
			addCriterion("updatedon <>", value, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonGreaterThan(Date value) {
			addCriterion("updatedon >", value, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonGreaterThanOrEqualTo(Date value) {
			addCriterion("updatedon >=", value, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonLessThan(Date value) {
			addCriterion("updatedon <", value, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonLessThanOrEqualTo(Date value) {
			addCriterion("updatedon <=", value, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonIn(List<Date> values) {
			addCriterion("updatedon in", values, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonNotIn(List<Date> values) {
			addCriterion("updatedon not in", values, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonBetween(Date value1, Date value2) {
			addCriterion("updatedon between", value1, value2, "updatedon");
			return (Criteria) this;
		}

		public Criteria andUpdatedonNotBetween(Date value1, Date value2) {
			addCriterion("updatedon not between", value1, value2, "updatedon");
			return (Criteria) this;
		}

		public Criteria andVersionIsNull() {
			addCriterion("version is null");
			return (Criteria) this;
		}

		public Criteria andVersionIsNotNull() {
			addCriterion("version is not null");
			return (Criteria) this;
		}

		public Criteria andVersionEqualTo(Integer value) {
			addCriterion("version =", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotEqualTo(Integer value) {
			addCriterion("version <>", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThan(Integer value) {
			addCriterion("version >", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
			addCriterion("version >=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThan(Integer value) {
			addCriterion("version <", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionLessThanOrEqualTo(Integer value) {
			addCriterion("version <=", value, "version");
			return (Criteria) this;
		}

		public Criteria andVersionIn(List<Integer> values) {
			addCriterion("version in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotIn(List<Integer> values) {
			addCriterion("version not in", values, "version");
			return (Criteria) this;
		}

		public Criteria andVersionBetween(Integer value1, Integer value2) {
			addCriterion("version between", value1, value2, "version");
			return (Criteria) this;
		}

		public Criteria andVersionNotBetween(Integer value1, Integer value2) {
			addCriterion("version not between", value1, value2, "version");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbggenerated  Wed Nov 09 23:34:49 SGT 2016
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbggenerated do_not_delete_during_merge Mon Oct 10 22:36:09 SGT 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}