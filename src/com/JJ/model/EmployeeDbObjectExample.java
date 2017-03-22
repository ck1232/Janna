package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeDbObjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
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

        public Criteria andEmployeeTypeIsNull() {
            addCriterion("employee_type is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIsNotNull() {
            addCriterion("employee_type is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeEqualTo(String value) {
            addCriterion("employee_type =", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotEqualTo(String value) {
            addCriterion("employee_type <>", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeGreaterThan(String value) {
            addCriterion("employee_type >", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("employee_type >=", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLessThan(String value) {
            addCriterion("employee_type <", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLessThanOrEqualTo(String value) {
            addCriterion("employee_type <=", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLike(String value) {
            addCriterion("employee_type like", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotLike(String value) {
            addCriterion("employee_type not like", value, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeIn(List<String> values) {
            addCriterion("employee_type in", values, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotIn(List<String> values) {
            addCriterion("employee_type not in", values, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeBetween(String value1, String value2) {
            addCriterion("employee_type between", value1, value2, "employeeType");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeNotBetween(String value1, String value2) {
            addCriterion("employee_type not between", value1, value2, "employeeType");
            return (Criteria) this;
        }

        public Criteria andDobIsNull() {
            addCriterion("dob is null");
            return (Criteria) this;
        }

        public Criteria andDobIsNotNull() {
            addCriterion("dob is not null");
            return (Criteria) this;
        }

        public Criteria andDobEqualTo(Date value) {
            addCriterionForJDBCDate("dob =", value, "dob");
            return (Criteria) this;
        }

        public Criteria andDobNotEqualTo(Date value) {
            addCriterionForJDBCDate("dob <>", value, "dob");
            return (Criteria) this;
        }

        public Criteria andDobGreaterThan(Date value) {
            addCriterionForJDBCDate("dob >", value, "dob");
            return (Criteria) this;
        }

        public Criteria andDobGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dob >=", value, "dob");
            return (Criteria) this;
        }

        public Criteria andDobLessThan(Date value) {
            addCriterionForJDBCDate("dob <", value, "dob");
            return (Criteria) this;
        }

        public Criteria andDobLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dob <=", value, "dob");
            return (Criteria) this;
        }

        public Criteria andDobIn(List<Date> values) {
            addCriterionForJDBCDate("dob in", values, "dob");
            return (Criteria) this;
        }

        public Criteria andDobNotIn(List<Date> values) {
            addCriterionForJDBCDate("dob not in", values, "dob");
            return (Criteria) this;
        }

        public Criteria andDobBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dob between", value1, value2, "dob");
            return (Criteria) this;
        }

        public Criteria andDobNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dob not between", value1, value2, "dob");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNull() {
            addCriterion("nationality is null");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNotNull() {
            addCriterion("nationality is not null");
            return (Criteria) this;
        }

        public Criteria andNationalityEqualTo(String value) {
            addCriterion("nationality =", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotEqualTo(String value) {
            addCriterion("nationality <>", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThan(String value) {
            addCriterion("nationality >", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("nationality >=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThan(String value) {
            addCriterion("nationality <", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThanOrEqualTo(String value) {
            addCriterion("nationality <=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLike(String value) {
            addCriterion("nationality like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotLike(String value) {
            addCriterion("nationality not like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityIn(List<String> values) {
            addCriterion("nationality in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotIn(List<String> values) {
            addCriterion("nationality not in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityBetween(String value1, String value2) {
            addCriterion("nationality between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotBetween(String value1, String value2) {
            addCriterion("nationality not between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIsNull() {
            addCriterion("basic_salary is null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIsNotNull() {
            addCriterion("basic_salary is not null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryEqualTo(BigDecimal value) {
            addCriterion("basic_salary =", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotEqualTo(BigDecimal value) {
            addCriterion("basic_salary <>", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryGreaterThan(BigDecimal value) {
            addCriterion("basic_salary >", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_salary >=", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryLessThan(BigDecimal value) {
            addCriterion("basic_salary <", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_salary <=", value, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryIn(List<BigDecimal> values) {
            addCriterion("basic_salary in", values, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotIn(List<BigDecimal> values) {
            addCriterion("basic_salary not in", values, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_salary between", value1, value2, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_salary not between", value1, value2, "basicSalary");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateIsNull() {
            addCriterion("employment_start_date is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateIsNotNull() {
            addCriterion("employment_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("employment_start_date =", value, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("employment_start_date <>", value, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("employment_start_date >", value, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("employment_start_date >=", value, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateLessThan(Date value) {
            addCriterionForJDBCDate("employment_start_date <", value, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("employment_start_date <=", value, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("employment_start_date in", values, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("employment_start_date not in", values, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("employment_start_date between", value1, value2, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("employment_start_date not between", value1, value2, "employmentStartDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateIsNull() {
            addCriterion("employment_end_date is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateIsNotNull() {
            addCriterion("employment_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("employment_end_date =", value, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("employment_end_date <>", value, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("employment_end_date >", value, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("employment_end_date >=", value, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateLessThan(Date value) {
            addCriterionForJDBCDate("employment_end_date <", value, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("employment_end_date <=", value, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("employment_end_date in", values, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("employment_end_date not in", values, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("employment_end_date between", value1, value2, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andEmploymentEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("employment_end_date not between", value1, value2, "employmentEndDate");
            return (Criteria) this;
        }

        public Criteria andCdacIndIsNull() {
            addCriterion("cdac_ind is null");
            return (Criteria) this;
        }

        public Criteria andCdacIndIsNotNull() {
            addCriterion("cdac_ind is not null");
            return (Criteria) this;
        }

        public Criteria andCdacIndEqualTo(String value) {
            addCriterion("cdac_ind =", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndNotEqualTo(String value) {
            addCriterion("cdac_ind <>", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndGreaterThan(String value) {
            addCriterion("cdac_ind >", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndGreaterThanOrEqualTo(String value) {
            addCriterion("cdac_ind >=", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndLessThan(String value) {
            addCriterion("cdac_ind <", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndLessThanOrEqualTo(String value) {
            addCriterion("cdac_ind <=", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndLike(String value) {
            addCriterion("cdac_ind like", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndNotLike(String value) {
            addCriterion("cdac_ind not like", value, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndIn(List<String> values) {
            addCriterion("cdac_ind in", values, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndNotIn(List<String> values) {
            addCriterion("cdac_ind not in", values, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndBetween(String value1, String value2) {
            addCriterion("cdac_ind between", value1, value2, "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCdacIndNotBetween(String value1, String value2) {
            addCriterion("cdac_ind not between", value1, value2, "cdacInd");
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

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedOnIsNull() {
            addCriterion("created_on is null");
            return (Criteria) this;
        }

        public Criteria andCreatedOnIsNotNull() {
            addCriterion("created_on is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedOnEqualTo(Date value) {
            addCriterion("created_on =", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnNotEqualTo(Date value) {
            addCriterion("created_on <>", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnGreaterThan(Date value) {
            addCriterion("created_on >", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnGreaterThanOrEqualTo(Date value) {
            addCriterion("created_on >=", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnLessThan(Date value) {
            addCriterion("created_on <", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnLessThanOrEqualTo(Date value) {
            addCriterion("created_on <=", value, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnIn(List<Date> values) {
            addCriterion("created_on in", values, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnNotIn(List<Date> values) {
            addCriterion("created_on not in", values, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnBetween(Date value1, Date value2) {
            addCriterion("created_on between", value1, value2, "createdOn");
            return (Criteria) this;
        }

        public Criteria andCreatedOnNotBetween(Date value1, Date value2) {
            addCriterion("created_on not between", value1, value2, "createdOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("updated_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("updated_by =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("updated_by <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("updated_by >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("updated_by >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("updated_by <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("updated_by <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("updated_by like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("updated_by not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("updated_by in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("updated_by not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("updated_by between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("updated_by not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnIsNull() {
            addCriterion("updated_on is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnIsNotNull() {
            addCriterion("updated_on is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnEqualTo(Date value) {
            addCriterion("updated_on =", value, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnNotEqualTo(Date value) {
            addCriterion("updated_on <>", value, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnGreaterThan(Date value) {
            addCriterion("updated_on >", value, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_on >=", value, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnLessThan(Date value) {
            addCriterion("updated_on <", value, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnLessThanOrEqualTo(Date value) {
            addCriterion("updated_on <=", value, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnIn(List<Date> values) {
            addCriterion("updated_on in", values, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnNotIn(List<Date> values) {
            addCriterion("updated_on not in", values, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnBetween(Date value1, Date value2) {
            addCriterion("updated_on between", value1, value2, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andUpdatedOnNotBetween(Date value1, Date value2) {
            addCriterion("updated_on not between", value1, value2, "updatedOn");
            return (Criteria) this;
        }

        public Criteria andDeleteIndIsNull() {
            addCriterion("delete_ind is null");
            return (Criteria) this;
        }

        public Criteria andDeleteIndIsNotNull() {
            addCriterion("delete_ind is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteIndEqualTo(String value) {
            addCriterion("delete_ind =", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndNotEqualTo(String value) {
            addCriterion("delete_ind <>", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndGreaterThan(String value) {
            addCriterion("delete_ind >", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndGreaterThanOrEqualTo(String value) {
            addCriterion("delete_ind >=", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndLessThan(String value) {
            addCriterion("delete_ind <", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndLessThanOrEqualTo(String value) {
            addCriterion("delete_ind <=", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndLike(String value) {
            addCriterion("delete_ind like", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndNotLike(String value) {
            addCriterion("delete_ind not like", value, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndIn(List<String> values) {
            addCriterion("delete_ind in", values, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndNotIn(List<String> values) {
            addCriterion("delete_ind not in", values, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndBetween(String value1, String value2) {
            addCriterion("delete_ind between", value1, value2, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andDeleteIndNotBetween(String value1, String value2) {
            addCriterion("delete_ind not between", value1, value2, "deleteInd");
            return (Criteria) this;
        }

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(name) like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andEmployeeTypeLikeInsensitive(String value) {
            addCriterion("upper(employee_type) like", value.toUpperCase(), "employeeType");
            return (Criteria) this;
        }

        public Criteria andNationalityLikeInsensitive(String value) {
            addCriterion("upper(nationality) like", value.toUpperCase(), "nationality");
            return (Criteria) this;
        }

        public Criteria andCdacIndLikeInsensitive(String value) {
            addCriterion("upper(cdac_ind) like", value.toUpperCase(), "cdacInd");
            return (Criteria) this;
        }

        public Criteria andCreatedByLikeInsensitive(String value) {
            addCriterion("upper(created_by) like", value.toUpperCase(), "createdBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLikeInsensitive(String value) {
            addCriterion("upper(updated_by) like", value.toUpperCase(), "updatedBy");
            return (Criteria) this;
        }

        public Criteria andDeleteIndLikeInsensitive(String value) {
            addCriterion("upper(delete_ind) like", value.toUpperCase(), "deleteInd");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}