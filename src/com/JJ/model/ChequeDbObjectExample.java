package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ChequeDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChequeDbObjectExample() {
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

        public Criteria andChequeIdIsNull() {
            addCriterion("cheque_id is null");
            return (Criteria) this;
        }

        public Criteria andChequeIdIsNotNull() {
            addCriterion("cheque_id is not null");
            return (Criteria) this;
        }

        public Criteria andChequeIdEqualTo(Integer value) {
            addCriterion("cheque_id =", value, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdNotEqualTo(Integer value) {
            addCriterion("cheque_id <>", value, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdGreaterThan(Integer value) {
            addCriterion("cheque_id >", value, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cheque_id >=", value, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdLessThan(Integer value) {
            addCriterion("cheque_id <", value, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdLessThanOrEqualTo(Integer value) {
            addCriterion("cheque_id <=", value, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdIn(List<Integer> values) {
            addCriterion("cheque_id in", values, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdNotIn(List<Integer> values) {
            addCriterion("cheque_id not in", values, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdBetween(Integer value1, Integer value2) {
            addCriterion("cheque_id between", value1, value2, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cheque_id not between", value1, value2, "chequeId");
            return (Criteria) this;
        }

        public Criteria andChequeNumIsNull() {
            addCriterion("cheque_num is null");
            return (Criteria) this;
        }

        public Criteria andChequeNumIsNotNull() {
            addCriterion("cheque_num is not null");
            return (Criteria) this;
        }

        public Criteria andChequeNumEqualTo(String value) {
            addCriterion("cheque_num =", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumNotEqualTo(String value) {
            addCriterion("cheque_num <>", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumGreaterThan(String value) {
            addCriterion("cheque_num >", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumGreaterThanOrEqualTo(String value) {
            addCriterion("cheque_num >=", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumLessThan(String value) {
            addCriterion("cheque_num <", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumLessThanOrEqualTo(String value) {
            addCriterion("cheque_num <=", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumLike(String value) {
            addCriterion("cheque_num like", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumNotLike(String value) {
            addCriterion("cheque_num not like", value, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumIn(List<String> values) {
            addCriterion("cheque_num in", values, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumNotIn(List<String> values) {
            addCriterion("cheque_num not in", values, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumBetween(String value1, String value2) {
            addCriterion("cheque_num between", value1, value2, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeNumNotBetween(String value1, String value2) {
            addCriterion("cheque_num not between", value1, value2, "chequeNum");
            return (Criteria) this;
        }

        public Criteria andChequeDateIsNull() {
            addCriterion("cheque_date is null");
            return (Criteria) this;
        }

        public Criteria andChequeDateIsNotNull() {
            addCriterion("cheque_date is not null");
            return (Criteria) this;
        }

        public Criteria andChequeDateEqualTo(Date value) {
            addCriterionForJDBCDate("cheque_date =", value, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("cheque_date <>", value, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("cheque_date >", value, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cheque_date >=", value, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateLessThan(Date value) {
            addCriterionForJDBCDate("cheque_date <", value, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cheque_date <=", value, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateIn(List<Date> values) {
            addCriterionForJDBCDate("cheque_date in", values, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("cheque_date not in", values, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cheque_date between", value1, value2, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cheque_date not between", value1, value2, "chequeDate");
            return (Criteria) this;
        }

        public Criteria andChequeAmtIsNull() {
            addCriterion("cheque_amt is null");
            return (Criteria) this;
        }

        public Criteria andChequeAmtIsNotNull() {
            addCriterion("cheque_amt is not null");
            return (Criteria) this;
        }

        public Criteria andChequeAmtEqualTo(BigDecimal value) {
            addCriterion("cheque_amt =", value, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtNotEqualTo(BigDecimal value) {
            addCriterion("cheque_amt <>", value, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtGreaterThan(BigDecimal value) {
            addCriterion("cheque_amt >", value, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cheque_amt >=", value, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtLessThan(BigDecimal value) {
            addCriterion("cheque_amt <", value, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cheque_amt <=", value, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtIn(List<BigDecimal> values) {
            addCriterion("cheque_amt in", values, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtNotIn(List<BigDecimal> values) {
            addCriterion("cheque_amt not in", values, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cheque_amt between", value1, value2, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andChequeAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cheque_amt not between", value1, value2, "chequeAmt");
            return (Criteria) this;
        }

        public Criteria andDebitDateIsNull() {
            addCriterion("debit_date is null");
            return (Criteria) this;
        }

        public Criteria andDebitDateIsNotNull() {
            addCriterion("debit_date is not null");
            return (Criteria) this;
        }

        public Criteria andDebitDateEqualTo(Date value) {
            addCriterionForJDBCDate("debit_date =", value, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("debit_date <>", value, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateGreaterThan(Date value) {
            addCriterionForJDBCDate("debit_date >", value, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("debit_date >=", value, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateLessThan(Date value) {
            addCriterionForJDBCDate("debit_date <", value, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("debit_date <=", value, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateIn(List<Date> values) {
            addCriterionForJDBCDate("debit_date in", values, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("debit_date not in", values, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("debit_date between", value1, value2, "debitDate");
            return (Criteria) this;
        }

        public Criteria andDebitDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("debit_date not between", value1, value2, "debitDate");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndIsNull() {
            addCriterion("bounce_cheque_ind is null");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndIsNotNull() {
            addCriterion("bounce_cheque_ind is not null");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndEqualTo(String value) {
            addCriterion("bounce_cheque_ind =", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndNotEqualTo(String value) {
            addCriterion("bounce_cheque_ind <>", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndGreaterThan(String value) {
            addCriterion("bounce_cheque_ind >", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndGreaterThanOrEqualTo(String value) {
            addCriterion("bounce_cheque_ind >=", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndLessThan(String value) {
            addCriterion("bounce_cheque_ind <", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndLessThanOrEqualTo(String value) {
            addCriterion("bounce_cheque_ind <=", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndLike(String value) {
            addCriterion("bounce_cheque_ind like", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndNotLike(String value) {
            addCriterion("bounce_cheque_ind not like", value, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndIn(List<String> values) {
            addCriterion("bounce_cheque_ind in", values, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndNotIn(List<String> values) {
            addCriterion("bounce_cheque_ind not in", values, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndBetween(String value1, String value2) {
            addCriterion("bounce_cheque_ind between", value1, value2, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndNotBetween(String value1, String value2) {
            addCriterion("bounce_cheque_ind not between", value1, value2, "bounceChequeInd");
            return (Criteria) this;
        }

        public Criteria andBounceDateIsNull() {
            addCriterion("bounce_date is null");
            return (Criteria) this;
        }

        public Criteria andBounceDateIsNotNull() {
            addCriterion("bounce_date is not null");
            return (Criteria) this;
        }

        public Criteria andBounceDateEqualTo(Date value) {
            addCriterionForJDBCDate("bounce_date =", value, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bounce_date <>", value, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateGreaterThan(Date value) {
            addCriterionForJDBCDate("bounce_date >", value, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bounce_date >=", value, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateLessThan(Date value) {
            addCriterionForJDBCDate("bounce_date <", value, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bounce_date <=", value, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateIn(List<Date> values) {
            addCriterionForJDBCDate("bounce_date in", values, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bounce_date not in", values, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bounce_date between", value1, value2, "bounceDate");
            return (Criteria) this;
        }

        public Criteria andBounceDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bounce_date not between", value1, value2, "bounceDate");
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

        public Criteria andChequeNumLikeInsensitive(String value) {
            addCriterion("upper(cheque_num) like", value.toUpperCase(), "chequeNum");
            return (Criteria) this;
        }

        public Criteria andRemarksLikeInsensitive(String value) {
            addCriterion("upper(remarks) like", value.toUpperCase(), "remarks");
            return (Criteria) this;
        }

        public Criteria andBounceChequeIndLikeInsensitive(String value) {
            addCriterion("upper(bounce_cheque_ind) like", value.toUpperCase(), "bounceChequeInd");
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