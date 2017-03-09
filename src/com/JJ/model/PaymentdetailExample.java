package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PaymentdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentdetailExample() {
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

        public Criteria andPaymentdetailidIsNull() {
            addCriterion("paymentDetailId is null");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidIsNotNull() {
            addCriterion("paymentDetailId is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidEqualTo(Integer value) {
            addCriterion("paymentDetailId =", value, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidNotEqualTo(Integer value) {
            addCriterion("paymentDetailId <>", value, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidGreaterThan(Integer value) {
            addCriterion("paymentDetailId >", value, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paymentDetailId >=", value, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidLessThan(Integer value) {
            addCriterion("paymentDetailId <", value, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidLessThanOrEqualTo(Integer value) {
            addCriterion("paymentDetailId <=", value, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidIn(List<Integer> values) {
            addCriterion("paymentDetailId in", values, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidNotIn(List<Integer> values) {
            addCriterion("paymentDetailId not in", values, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidBetween(Integer value1, Integer value2) {
            addCriterion("paymentDetailId between", value1, value2, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdetailidNotBetween(Integer value1, Integer value2) {
            addCriterion("paymentDetailId not between", value1, value2, "paymentdetailid");
            return (Criteria) this;
        }

        public Criteria andPaymentdateIsNull() {
            addCriterion("paymentDate is null");
            return (Criteria) this;
        }

        public Criteria andPaymentdateIsNotNull() {
            addCriterion("paymentDate is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentdateEqualTo(Date value) {
            addCriterionForJDBCDate("paymentDate =", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("paymentDate <>", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateGreaterThan(Date value) {
            addCriterionForJDBCDate("paymentDate >", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("paymentDate >=", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateLessThan(Date value) {
            addCriterionForJDBCDate("paymentDate <", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("paymentDate <=", value, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateIn(List<Date> values) {
            addCriterionForJDBCDate("paymentDate in", values, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("paymentDate not in", values, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("paymentDate between", value1, value2, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("paymentDate not between", value1, value2, "paymentdate");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeIsNull() {
            addCriterion("paymentMode is null");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeIsNotNull() {
            addCriterion("paymentMode is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeEqualTo(Integer value) {
            addCriterion("paymentMode =", value, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeNotEqualTo(Integer value) {
            addCriterion("paymentMode <>", value, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeGreaterThan(Integer value) {
            addCriterion("paymentMode >", value, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("paymentMode >=", value, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeLessThan(Integer value) {
            addCriterion("paymentMode <", value, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeLessThanOrEqualTo(Integer value) {
            addCriterion("paymentMode <=", value, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeIn(List<Integer> values) {
            addCriterion("paymentMode in", values, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeNotIn(List<Integer> values) {
            addCriterion("paymentMode not in", values, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeBetween(Integer value1, Integer value2) {
            addCriterion("paymentMode between", value1, value2, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentmodeNotBetween(Integer value1, Integer value2) {
            addCriterion("paymentMode not between", value1, value2, "paymentmode");
            return (Criteria) this;
        }

        public Criteria andPaymentamountIsNull() {
            addCriterion("paymentAmount is null");
            return (Criteria) this;
        }

        public Criteria andPaymentamountIsNotNull() {
            addCriterion("paymentAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentamountEqualTo(BigDecimal value) {
            addCriterion("paymentAmount =", value, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountNotEqualTo(BigDecimal value) {
            addCriterion("paymentAmount <>", value, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountGreaterThan(BigDecimal value) {
            addCriterion("paymentAmount >", value, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paymentAmount >=", value, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountLessThan(BigDecimal value) {
            addCriterion("paymentAmount <", value, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paymentAmount <=", value, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountIn(List<BigDecimal> values) {
            addCriterion("paymentAmount in", values, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountNotIn(List<BigDecimal> values) {
            addCriterion("paymentAmount not in", values, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymentAmount between", value1, value2, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andPaymentamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paymentAmount not between", value1, value2, "paymentamount");
            return (Criteria) this;
        }

        public Criteria andChequenumIsNull() {
            addCriterion("chequeNum is null");
            return (Criteria) this;
        }

        public Criteria andChequenumIsNotNull() {
            addCriterion("chequeNum is not null");
            return (Criteria) this;
        }

        public Criteria andChequenumEqualTo(String value) {
            addCriterion("chequeNum =", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumNotEqualTo(String value) {
            addCriterion("chequeNum <>", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumGreaterThan(String value) {
            addCriterion("chequeNum >", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumGreaterThanOrEqualTo(String value) {
            addCriterion("chequeNum >=", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumLessThan(String value) {
            addCriterion("chequeNum <", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumLessThanOrEqualTo(String value) {
            addCriterion("chequeNum <=", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumLike(String value) {
            addCriterion("chequeNum like", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumNotLike(String value) {
            addCriterion("chequeNum not like", value, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumIn(List<String> values) {
            addCriterion("chequeNum in", values, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumNotIn(List<String> values) {
            addCriterion("chequeNum not in", values, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumBetween(String value1, String value2) {
            addCriterion("chequeNum between", value1, value2, "chequenum");
            return (Criteria) this;
        }

        public Criteria andChequenumNotBetween(String value1, String value2) {
            addCriterion("chequeNum not between", value1, value2, "chequenum");
            return (Criteria) this;
        }

        public Criteria andBouncechqindIsNull() {
            addCriterion("bounceChqInd is null");
            return (Criteria) this;
        }

        public Criteria andBouncechqindIsNotNull() {
            addCriterion("bounceChqInd is not null");
            return (Criteria) this;
        }

        public Criteria andBouncechqindEqualTo(String value) {
            addCriterion("bounceChqInd =", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindNotEqualTo(String value) {
            addCriterion("bounceChqInd <>", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindGreaterThan(String value) {
            addCriterion("bounceChqInd >", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindGreaterThanOrEqualTo(String value) {
            addCriterion("bounceChqInd >=", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindLessThan(String value) {
            addCriterion("bounceChqInd <", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindLessThanOrEqualTo(String value) {
            addCriterion("bounceChqInd <=", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindLike(String value) {
            addCriterion("bounceChqInd like", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindNotLike(String value) {
            addCriterion("bounceChqInd not like", value, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindIn(List<String> values) {
            addCriterion("bounceChqInd in", values, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindNotIn(List<String> values) {
            addCriterion("bounceChqInd not in", values, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindBetween(String value1, String value2) {
            addCriterion("bounceChqInd between", value1, value2, "bouncechqind");
            return (Criteria) this;
        }

        public Criteria andBouncechqindNotBetween(String value1, String value2) {
            addCriterion("bounceChqInd not between", value1, value2, "bouncechqind");
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