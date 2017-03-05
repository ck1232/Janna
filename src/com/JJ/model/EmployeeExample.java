package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
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

        public Criteria andEmployeeidIsNull() {
            addCriterion("employeeId is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNotNull() {
            addCriterion("employeeId is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidEqualTo(Integer value) {
            addCriterion("employeeId =", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotEqualTo(Integer value) {
            addCriterion("employeeId <>", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThan(Integer value) {
            addCriterion("employeeId >", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("employeeId >=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThan(Integer value) {
            addCriterion("employeeId <", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThanOrEqualTo(Integer value) {
            addCriterion("employeeId <=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIn(List<Integer> values) {
            addCriterion("employeeId in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotIn(List<Integer> values) {
            addCriterion("employeeId not in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidBetween(Integer value1, Integer value2) {
            addCriterion("employeeId between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotBetween(Integer value1, Integer value2) {
            addCriterion("employeeId not between", value1, value2, "employeeid");
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

        public Criteria andEmploymenttypeIsNull() {
            addCriterion("employmentType is null");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeIsNotNull() {
            addCriterion("employmentType is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeEqualTo(String value) {
            addCriterion("employmentType =", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeNotEqualTo(String value) {
            addCriterion("employmentType <>", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeGreaterThan(String value) {
            addCriterion("employmentType >", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("employmentType >=", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeLessThan(String value) {
            addCriterion("employmentType <", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeLessThanOrEqualTo(String value) {
            addCriterion("employmentType <=", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeLike(String value) {
            addCriterion("employmentType like", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeNotLike(String value) {
            addCriterion("employmentType not like", value, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeIn(List<String> values) {
            addCriterion("employmentType in", values, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeNotIn(List<String> values) {
            addCriterion("employmentType not in", values, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeBetween(String value1, String value2) {
            addCriterion("employmentType between", value1, value2, "employmenttype");
            return (Criteria) this;
        }

        public Criteria andEmploymenttypeNotBetween(String value1, String value2) {
            addCriterion("employmentType not between", value1, value2, "employmenttype");
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

        public Criteria andBasicsalaryIsNull() {
            addCriterion("basicSalary is null");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIsNotNull() {
            addCriterion("basicSalary is not null");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryEqualTo(BigDecimal value) {
            addCriterion("basicSalary =", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotEqualTo(BigDecimal value) {
            addCriterion("basicSalary <>", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryGreaterThan(BigDecimal value) {
            addCriterion("basicSalary >", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basicSalary >=", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryLessThan(BigDecimal value) {
            addCriterion("basicSalary <", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basicSalary <=", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIn(List<BigDecimal> values) {
            addCriterion("basicSalary in", values, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotIn(List<BigDecimal> values) {
            addCriterion("basicSalary not in", values, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basicSalary between", value1, value2, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basicSalary not between", value1, value2, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andDefunctindIsNull() {
            addCriterion("defunctInd is null");
            return (Criteria) this;
        }

        public Criteria andDefunctindIsNotNull() {
            addCriterion("defunctInd is not null");
            return (Criteria) this;
        }

        public Criteria andDefunctindEqualTo(String value) {
            addCriterion("defunctInd =", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindNotEqualTo(String value) {
            addCriterion("defunctInd <>", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindGreaterThan(String value) {
            addCriterion("defunctInd >", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindGreaterThanOrEqualTo(String value) {
            addCriterion("defunctInd >=", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindLessThan(String value) {
            addCriterion("defunctInd <", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindLessThanOrEqualTo(String value) {
            addCriterion("defunctInd <=", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindLike(String value) {
            addCriterion("defunctInd like", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindNotLike(String value) {
            addCriterion("defunctInd not like", value, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindIn(List<String> values) {
            addCriterion("defunctInd in", values, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindNotIn(List<String> values) {
            addCriterion("defunctInd not in", values, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindBetween(String value1, String value2) {
            addCriterion("defunctInd between", value1, value2, "defunctind");
            return (Criteria) this;
        }

        public Criteria andDefunctindNotBetween(String value1, String value2) {
            addCriterion("defunctInd not between", value1, value2, "defunctind");
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