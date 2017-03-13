package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeBonusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeBonusExample() {
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

        public Criteria andBonusidIsNull() {
            addCriterion("bonusId is null");
            return (Criteria) this;
        }

        public Criteria andBonusidIsNotNull() {
            addCriterion("bonusId is not null");
            return (Criteria) this;
        }

        public Criteria andBonusidEqualTo(Integer value) {
            addCriterion("bonusId =", value, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidNotEqualTo(Integer value) {
            addCriterion("bonusId <>", value, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidGreaterThan(Integer value) {
            addCriterion("bonusId >", value, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bonusId >=", value, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidLessThan(Integer value) {
            addCriterion("bonusId <", value, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidLessThanOrEqualTo(Integer value) {
            addCriterion("bonusId <=", value, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidIn(List<Integer> values) {
            addCriterion("bonusId in", values, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidNotIn(List<Integer> values) {
            addCriterion("bonusId not in", values, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidBetween(Integer value1, Integer value2) {
            addCriterion("bonusId between", value1, value2, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusidNotBetween(Integer value1, Integer value2) {
            addCriterion("bonusId not between", value1, value2, "bonusid");
            return (Criteria) this;
        }

        public Criteria andBonusdateIsNull() {
            addCriterion("bonusDate is null");
            return (Criteria) this;
        }

        public Criteria andBonusdateIsNotNull() {
            addCriterion("bonusDate is not null");
            return (Criteria) this;
        }

        public Criteria andBonusdateEqualTo(Date value) {
            addCriterionForJDBCDate("bonusDate =", value, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bonusDate <>", value, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateGreaterThan(Date value) {
            addCriterionForJDBCDate("bonusDate >", value, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bonusDate >=", value, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateLessThan(Date value) {
            addCriterionForJDBCDate("bonusDate <", value, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bonusDate <=", value, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateIn(List<Date> values) {
            addCriterionForJDBCDate("bonusDate in", values, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bonusDate not in", values, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bonusDate between", value1, value2, "bonusdate");
            return (Criteria) this;
        }

        public Criteria andBonusdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bonusDate not between", value1, value2, "bonusdate");
            return (Criteria) this;
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

        public Criteria andBonusamountIsNull() {
            addCriterion("bonusAmount is null");
            return (Criteria) this;
        }

        public Criteria andBonusamountIsNotNull() {
            addCriterion("bonusAmount is not null");
            return (Criteria) this;
        }

        public Criteria andBonusamountEqualTo(BigDecimal value) {
            addCriterion("bonusAmount =", value, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountNotEqualTo(BigDecimal value) {
            addCriterion("bonusAmount <>", value, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountGreaterThan(BigDecimal value) {
            addCriterion("bonusAmount >", value, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bonusAmount >=", value, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountLessThan(BigDecimal value) {
            addCriterion("bonusAmount <", value, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bonusAmount <=", value, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountIn(List<BigDecimal> values) {
            addCriterion("bonusAmount in", values, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountNotIn(List<BigDecimal> values) {
            addCriterion("bonusAmount not in", values, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonusAmount between", value1, value2, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andBonusamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonusAmount not between", value1, value2, "bonusamount");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfIsNull() {
            addCriterion("employeeCPF is null");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfIsNotNull() {
            addCriterion("employeeCPF is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfEqualTo(BigDecimal value) {
            addCriterion("employeeCPF =", value, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfNotEqualTo(BigDecimal value) {
            addCriterion("employeeCPF <>", value, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfGreaterThan(BigDecimal value) {
            addCriterion("employeeCPF >", value, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("employeeCPF >=", value, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfLessThan(BigDecimal value) {
            addCriterion("employeeCPF <", value, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("employeeCPF <=", value, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfIn(List<BigDecimal> values) {
            addCriterion("employeeCPF in", values, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfNotIn(List<BigDecimal> values) {
            addCriterion("employeeCPF not in", values, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employeeCPF between", value1, value2, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployeecpfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employeeCPF not between", value1, value2, "employeecpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfIsNull() {
            addCriterion("employerCPF is null");
            return (Criteria) this;
        }

        public Criteria andEmployercpfIsNotNull() {
            addCriterion("employerCPF is not null");
            return (Criteria) this;
        }

        public Criteria andEmployercpfEqualTo(BigDecimal value) {
            addCriterion("employerCPF =", value, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfNotEqualTo(BigDecimal value) {
            addCriterion("employerCPF <>", value, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfGreaterThan(BigDecimal value) {
            addCriterion("employerCPF >", value, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("employerCPF >=", value, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfLessThan(BigDecimal value) {
            addCriterion("employerCPF <", value, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("employerCPF <=", value, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfIn(List<BigDecimal> values) {
            addCriterion("employerCPF in", values, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfNotIn(List<BigDecimal> values) {
            addCriterion("employerCPF not in", values, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employerCPF between", value1, value2, "employercpf");
            return (Criteria) this;
        }

        public Criteria andEmployercpfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("employerCPF not between", value1, value2, "employercpf");
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