package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeSalaryDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeSalaryDbObjectExample() {
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

        public Criteria andSalaryIdIsNull() {
            addCriterion("salary_id is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIdIsNotNull() {
            addCriterion("salary_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryIdEqualTo(Integer value) {
            addCriterion("salary_id =", value, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdNotEqualTo(Integer value) {
            addCriterion("salary_id <>", value, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdGreaterThan(Integer value) {
            addCriterion("salary_id >", value, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("salary_id >=", value, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdLessThan(Integer value) {
            addCriterion("salary_id <", value, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdLessThanOrEqualTo(Integer value) {
            addCriterion("salary_id <=", value, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdIn(List<Integer> values) {
            addCriterion("salary_id in", values, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdNotIn(List<Integer> values) {
            addCriterion("salary_id not in", values, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdBetween(Integer value1, Integer value2) {
            addCriterion("salary_id between", value1, value2, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("salary_id not between", value1, value2, "salaryId");
            return (Criteria) this;
        }

        public Criteria andSalaryDateIsNull() {
            addCriterion("salary_date is null");
            return (Criteria) this;
        }

        public Criteria andSalaryDateIsNotNull() {
            addCriterion("salary_date is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryDateEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date =", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date <>", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateGreaterThan(Date value) {
            addCriterionForJDBCDate("salary_date >", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date >=", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateLessThan(Date value) {
            addCriterionForJDBCDate("salary_date <", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("salary_date <=", value, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateIn(List<Date> values) {
            addCriterionForJDBCDate("salary_date in", values, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("salary_date not in", values, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salary_date between", value1, value2, "salaryDate");
            return (Criteria) this;
        }

        public Criteria andSalaryDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("salary_date not between", value1, value2, "salaryDate");
            return (Criteria) this;
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

        public Criteria andBasicSalaryAmtIsNull() {
            addCriterion("basic_salary_amt is null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtIsNotNull() {
            addCriterion("basic_salary_amt is not null");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtEqualTo(BigDecimal value) {
            addCriterion("basic_salary_amt =", value, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtNotEqualTo(BigDecimal value) {
            addCriterion("basic_salary_amt <>", value, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtGreaterThan(BigDecimal value) {
            addCriterion("basic_salary_amt >", value, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_salary_amt >=", value, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtLessThan(BigDecimal value) {
            addCriterion("basic_salary_amt <", value, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_salary_amt <=", value, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtIn(List<BigDecimal> values) {
            addCriterion("basic_salary_amt in", values, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtNotIn(List<BigDecimal> values) {
            addCriterion("basic_salary_amt not in", values, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_salary_amt between", value1, value2, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andBasicSalaryAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_salary_amt not between", value1, value2, "basicSalaryAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtIsNull() {
            addCriterion("over_time_amt is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtIsNotNull() {
            addCriterion("over_time_amt is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtEqualTo(BigDecimal value) {
            addCriterion("over_time_amt =", value, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtNotEqualTo(BigDecimal value) {
            addCriterion("over_time_amt <>", value, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtGreaterThan(BigDecimal value) {
            addCriterion("over_time_amt >", value, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("over_time_amt >=", value, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtLessThan(BigDecimal value) {
            addCriterion("over_time_amt <", value, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("over_time_amt <=", value, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtIn(List<BigDecimal> values) {
            addCriterion("over_time_amt in", values, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtNotIn(List<BigDecimal> values) {
            addCriterion("over_time_amt not in", values, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("over_time_amt between", value1, value2, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("over_time_amt not between", value1, value2, "overTimeAmt");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursIsNull() {
            addCriterion("over_time_hours is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursIsNotNull() {
            addCriterion("over_time_hours is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursEqualTo(BigDecimal value) {
            addCriterion("over_time_hours =", value, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursNotEqualTo(BigDecimal value) {
            addCriterion("over_time_hours <>", value, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursGreaterThan(BigDecimal value) {
            addCriterion("over_time_hours >", value, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("over_time_hours >=", value, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursLessThan(BigDecimal value) {
            addCriterion("over_time_hours <", value, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursLessThanOrEqualTo(BigDecimal value) {
            addCriterion("over_time_hours <=", value, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursIn(List<BigDecimal> values) {
            addCriterion("over_time_hours in", values, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursNotIn(List<BigDecimal> values) {
            addCriterion("over_time_hours not in", values, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("over_time_hours between", value1, value2, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeHoursNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("over_time_hours not between", value1, value2, "overTimeHours");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksIsNull() {
            addCriterion("over_time_remarks is null");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksIsNotNull() {
            addCriterion("over_time_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksEqualTo(String value) {
            addCriterion("over_time_remarks =", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksNotEqualTo(String value) {
            addCriterion("over_time_remarks <>", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksGreaterThan(String value) {
            addCriterion("over_time_remarks >", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("over_time_remarks >=", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksLessThan(String value) {
            addCriterion("over_time_remarks <", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksLessThanOrEqualTo(String value) {
            addCriterion("over_time_remarks <=", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksLike(String value) {
            addCriterion("over_time_remarks like", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksNotLike(String value) {
            addCriterion("over_time_remarks not like", value, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksIn(List<String> values) {
            addCriterion("over_time_remarks in", values, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksNotIn(List<String> values) {
            addCriterion("over_time_remarks not in", values, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksBetween(String value1, String value2) {
            addCriterion("over_time_remarks between", value1, value2, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andOverTimeRemarksNotBetween(String value1, String value2) {
            addCriterion("over_time_remarks not between", value1, value2, "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNull() {
            addCriterion("allowance is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNotNull() {
            addCriterion("allowance is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceEqualTo(BigDecimal value) {
            addCriterion("allowance =", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("allowance <>", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThan(BigDecimal value) {
            addCriterion("allowance >", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("allowance >=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThan(BigDecimal value) {
            addCriterion("allowance <", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("allowance <=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceIn(List<BigDecimal> values) {
            addCriterion("allowance in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("allowance not in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("allowance between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("allowance not between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andMedicalIsNull() {
            addCriterion("medical is null");
            return (Criteria) this;
        }

        public Criteria andMedicalIsNotNull() {
            addCriterion("medical is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalEqualTo(BigDecimal value) {
            addCriterion("medical =", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotEqualTo(BigDecimal value) {
            addCriterion("medical <>", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalGreaterThan(BigDecimal value) {
            addCriterion("medical >", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("medical >=", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalLessThan(BigDecimal value) {
            addCriterion("medical <", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("medical <=", value, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalIn(List<BigDecimal> values) {
            addCriterion("medical in", values, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotIn(List<BigDecimal> values) {
            addCriterion("medical not in", values, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medical between", value1, value2, "medical");
            return (Criteria) this;
        }

        public Criteria andMedicalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("medical not between", value1, value2, "medical");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtIsNull() {
            addCriterion("unpaid_leave_amt is null");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtIsNotNull() {
            addCriterion("unpaid_leave_amt is not null");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtEqualTo(BigDecimal value) {
            addCriterion("unpaid_leave_amt =", value, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtNotEqualTo(BigDecimal value) {
            addCriterion("unpaid_leave_amt <>", value, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtGreaterThan(BigDecimal value) {
            addCriterion("unpaid_leave_amt >", value, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unpaid_leave_amt >=", value, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtLessThan(BigDecimal value) {
            addCriterion("unpaid_leave_amt <", value, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unpaid_leave_amt <=", value, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtIn(List<BigDecimal> values) {
            addCriterion("unpaid_leave_amt in", values, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtNotIn(List<BigDecimal> values) {
            addCriterion("unpaid_leave_amt not in", values, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unpaid_leave_amt between", value1, value2, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unpaid_leave_amt not between", value1, value2, "unpaidLeaveAmt");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksIsNull() {
            addCriterion("unpaid_leave_remarks is null");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksIsNotNull() {
            addCriterion("unpaid_leave_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksEqualTo(String value) {
            addCriterion("unpaid_leave_remarks =", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksNotEqualTo(String value) {
            addCriterion("unpaid_leave_remarks <>", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksGreaterThan(String value) {
            addCriterion("unpaid_leave_remarks >", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("unpaid_leave_remarks >=", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksLessThan(String value) {
            addCriterion("unpaid_leave_remarks <", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksLessThanOrEqualTo(String value) {
            addCriterion("unpaid_leave_remarks <=", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksLike(String value) {
            addCriterion("unpaid_leave_remarks like", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksNotLike(String value) {
            addCriterion("unpaid_leave_remarks not like", value, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksIn(List<String> values) {
            addCriterion("unpaid_leave_remarks in", values, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksNotIn(List<String> values) {
            addCriterion("unpaid_leave_remarks not in", values, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksBetween(String value1, String value2) {
            addCriterion("unpaid_leave_remarks between", value1, value2, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksNotBetween(String value1, String value2) {
            addCriterion("unpaid_leave_remarks not between", value1, value2, "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfIsNull() {
            addCriterion("employee_cpf is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfIsNotNull() {
            addCriterion("employee_cpf is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfEqualTo(BigDecimal value) {
            addCriterion("employee_cpf =", value, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfNotEqualTo(BigDecimal value) {
            addCriterion("employee_cpf <>", value, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfGreaterThan(BigDecimal value) {
            addCriterion("employee_cpf >", value, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("employee_cpf >=", value, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfLessThan(BigDecimal value) {
            addCriterion("employee_cpf <", value, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("employee_cpf <=", value, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfIn(List<BigDecimal> values) {
            addCriterion("employee_cpf in", values, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfNotIn(List<BigDecimal> values) {
            addCriterion("employee_cpf not in", values, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employee_cpf between", value1, value2, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployeeCpfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employee_cpf not between", value1, value2, "employeeCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfIsNull() {
            addCriterion("employer_cpf is null");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfIsNotNull() {
            addCriterion("employer_cpf is not null");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfEqualTo(BigDecimal value) {
            addCriterion("employer_cpf =", value, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfNotEqualTo(BigDecimal value) {
            addCriterion("employer_cpf <>", value, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfGreaterThan(BigDecimal value) {
            addCriterion("employer_cpf >", value, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("employer_cpf >=", value, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfLessThan(BigDecimal value) {
            addCriterion("employer_cpf <", value, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("employer_cpf <=", value, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfIn(List<BigDecimal> values) {
            addCriterion("employer_cpf in", values, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfNotIn(List<BigDecimal> values) {
            addCriterion("employer_cpf not in", values, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employer_cpf between", value1, value2, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andEmployerCpfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employer_cpf not between", value1, value2, "employerCpf");
            return (Criteria) this;
        }

        public Criteria andCdacAmtIsNull() {
            addCriterion("cdac_amt is null");
            return (Criteria) this;
        }

        public Criteria andCdacAmtIsNotNull() {
            addCriterion("cdac_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCdacAmtEqualTo(BigDecimal value) {
            addCriterion("cdac_amt =", value, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtNotEqualTo(BigDecimal value) {
            addCriterion("cdac_amt <>", value, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtGreaterThan(BigDecimal value) {
            addCriterion("cdac_amt >", value, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cdac_amt >=", value, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtLessThan(BigDecimal value) {
            addCriterion("cdac_amt <", value, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cdac_amt <=", value, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtIn(List<BigDecimal> values) {
            addCriterion("cdac_amt in", values, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtNotIn(List<BigDecimal> values) {
            addCriterion("cdac_amt not in", values, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cdac_amt between", value1, value2, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andCdacAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cdac_amt not between", value1, value2, "cdacAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtIsNull() {
            addCriterion("sdl_amt is null");
            return (Criteria) this;
        }

        public Criteria andSdlAmtIsNotNull() {
            addCriterion("sdl_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSdlAmtEqualTo(BigDecimal value) {
            addCriterion("sdl_amt =", value, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtNotEqualTo(BigDecimal value) {
            addCriterion("sdl_amt <>", value, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtGreaterThan(BigDecimal value) {
            addCriterion("sdl_amt >", value, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sdl_amt >=", value, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtLessThan(BigDecimal value) {
            addCriterion("sdl_amt <", value, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sdl_amt <=", value, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtIn(List<BigDecimal> values) {
            addCriterion("sdl_amt in", values, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtNotIn(List<BigDecimal> values) {
            addCriterion("sdl_amt not in", values, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sdl_amt between", value1, value2, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andSdlAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sdl_amt not between", value1, value2, "sdlAmt");
            return (Criteria) this;
        }

        public Criteria andFwLevyIsNull() {
            addCriterion("fw_levy is null");
            return (Criteria) this;
        }

        public Criteria andFwLevyIsNotNull() {
            addCriterion("fw_levy is not null");
            return (Criteria) this;
        }

        public Criteria andFwLevyEqualTo(BigDecimal value) {
            addCriterion("fw_levy =", value, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyNotEqualTo(BigDecimal value) {
            addCriterion("fw_levy <>", value, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyGreaterThan(BigDecimal value) {
            addCriterion("fw_levy >", value, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fw_levy >=", value, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyLessThan(BigDecimal value) {
            addCriterion("fw_levy <", value, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fw_levy <=", value, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyIn(List<BigDecimal> values) {
            addCriterion("fw_levy in", values, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyNotIn(List<BigDecimal> values) {
            addCriterion("fw_levy not in", values, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fw_levy between", value1, value2, "fwLevy");
            return (Criteria) this;
        }

        public Criteria andFwLevyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fw_levy not between", value1, value2, "fwLevy");
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

        public Criteria andOverTimeRemarksLikeInsensitive(String value) {
            addCriterion("upper(over_time_remarks) like", value.toUpperCase(), "overTimeRemarks");
            return (Criteria) this;
        }

        public Criteria andUnpaidLeaveRemarksLikeInsensitive(String value) {
            addCriterion("upper(unpaid_leave_remarks) like", value.toUpperCase(), "unpaidLeaveRemarks");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
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