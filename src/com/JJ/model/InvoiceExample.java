package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceExample() {
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

        public Criteria andInvoiceidIsNull() {
            addCriterion("invoiceId is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceidIsNotNull() {
            addCriterion("invoiceId is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceidEqualTo(Integer value) {
            addCriterion("invoiceId =", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidNotEqualTo(Integer value) {
            addCriterion("invoiceId <>", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidGreaterThan(Integer value) {
            addCriterion("invoiceId >", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("invoiceId >=", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidLessThan(Integer value) {
            addCriterion("invoiceId <", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidLessThanOrEqualTo(Integer value) {
            addCriterion("invoiceId <=", value, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidIn(List<Integer> values) {
            addCriterion("invoiceId in", values, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidNotIn(List<Integer> values) {
            addCriterion("invoiceId not in", values, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidBetween(Integer value1, Integer value2) {
            addCriterion("invoiceId between", value1, value2, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andInvoiceidNotBetween(Integer value1, Integer value2) {
            addCriterion("invoiceId not between", value1, value2, "invoiceid");
            return (Criteria) this;
        }

        public Criteria andMessengerIsNull() {
            addCriterion("messenger is null");
            return (Criteria) this;
        }

        public Criteria andMessengerIsNotNull() {
            addCriterion("messenger is not null");
            return (Criteria) this;
        }

        public Criteria andMessengerEqualTo(String value) {
            addCriterion("messenger =", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerNotEqualTo(String value) {
            addCriterion("messenger <>", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerGreaterThan(String value) {
            addCriterion("messenger >", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerGreaterThanOrEqualTo(String value) {
            addCriterion("messenger >=", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerLessThan(String value) {
            addCriterion("messenger <", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerLessThanOrEqualTo(String value) {
            addCriterion("messenger <=", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerLike(String value) {
            addCriterion("messenger like", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerNotLike(String value) {
            addCriterion("messenger not like", value, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerIn(List<String> values) {
            addCriterion("messenger in", values, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerNotIn(List<String> values) {
            addCriterion("messenger not in", values, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerBetween(String value1, String value2) {
            addCriterion("messenger between", value1, value2, "messenger");
            return (Criteria) this;
        }

        public Criteria andMessengerNotBetween(String value1, String value2) {
            addCriterion("messenger not between", value1, value2, "messenger");
            return (Criteria) this;
        }

        public Criteria andInvoicedateIsNull() {
            addCriterion("invoiceDate is null");
            return (Criteria) this;
        }

        public Criteria andInvoicedateIsNotNull() {
            addCriterion("invoiceDate is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicedateEqualTo(Date value) {
            addCriterion("invoiceDate =", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateNotEqualTo(Date value) {
            addCriterion("invoiceDate <>", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateGreaterThan(Date value) {
            addCriterion("invoiceDate >", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateGreaterThanOrEqualTo(Date value) {
            addCriterion("invoiceDate >=", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateLessThan(Date value) {
            addCriterion("invoiceDate <", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateLessThanOrEqualTo(Date value) {
            addCriterion("invoiceDate <=", value, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateIn(List<Date> values) {
            addCriterion("invoiceDate in", values, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateNotIn(List<Date> values) {
            addCriterion("invoiceDate not in", values, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateBetween(Date value1, Date value2) {
            addCriterion("invoiceDate between", value1, value2, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andInvoicedateNotBetween(Date value1, Date value2) {
            addCriterion("invoiceDate not between", value1, value2, "invoicedate");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNull() {
            addCriterion("totalPrice is null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNotNull() {
            addCriterion("totalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceEqualTo(BigDecimal value) {
            addCriterion("totalPrice =", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotEqualTo(BigDecimal value) {
            addCriterion("totalPrice <>", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThan(BigDecimal value) {
            addCriterion("totalPrice >", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalPrice >=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThan(BigDecimal value) {
            addCriterion("totalPrice <", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalPrice <=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIn(List<BigDecimal> values) {
            addCriterion("totalPrice in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotIn(List<BigDecimal> values) {
            addCriterion("totalPrice not in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalPrice between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalPrice not between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andDtecreatedIsNull() {
            addCriterion("dteCreated is null");
            return (Criteria) this;
        }

        public Criteria andDtecreatedIsNotNull() {
            addCriterion("dteCreated is not null");
            return (Criteria) this;
        }

        public Criteria andDtecreatedEqualTo(Date value) {
            addCriterion("dteCreated =", value, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedNotEqualTo(Date value) {
            addCriterion("dteCreated <>", value, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedGreaterThan(Date value) {
            addCriterion("dteCreated >", value, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("dteCreated >=", value, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedLessThan(Date value) {
            addCriterion("dteCreated <", value, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedLessThanOrEqualTo(Date value) {
            addCriterion("dteCreated <=", value, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedIn(List<Date> values) {
            addCriterion("dteCreated in", values, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedNotIn(List<Date> values) {
            addCriterion("dteCreated not in", values, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedBetween(Date value1, Date value2) {
            addCriterion("dteCreated between", value1, value2, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDtecreatedNotBetween(Date value1, Date value2) {
            addCriterion("dteCreated not between", value1, value2, "dtecreated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedIsNull() {
            addCriterion("dteUpdated is null");
            return (Criteria) this;
        }

        public Criteria andDteupdatedIsNotNull() {
            addCriterion("dteUpdated is not null");
            return (Criteria) this;
        }

        public Criteria andDteupdatedEqualTo(Date value) {
            addCriterion("dteUpdated =", value, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedNotEqualTo(Date value) {
            addCriterion("dteUpdated <>", value, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedGreaterThan(Date value) {
            addCriterion("dteUpdated >", value, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("dteUpdated >=", value, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedLessThan(Date value) {
            addCriterion("dteUpdated <", value, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedLessThanOrEqualTo(Date value) {
            addCriterion("dteUpdated <=", value, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedIn(List<Date> values) {
            addCriterion("dteUpdated in", values, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedNotIn(List<Date> values) {
            addCriterion("dteUpdated not in", values, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedBetween(Date value1, Date value2) {
            addCriterion("dteUpdated between", value1, value2, "dteupdated");
            return (Criteria) this;
        }

        public Criteria andDteupdatedNotBetween(Date value1, Date value2) {
            addCriterion("dteUpdated not between", value1, value2, "dteupdated");
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