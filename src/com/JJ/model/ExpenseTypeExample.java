package com.JJ.model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseTypeExample() {
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

        public Criteria andExpensetypeidIsNull() {
            addCriterion("expenseTypeId is null");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidIsNotNull() {
            addCriterion("expenseTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidEqualTo(Integer value) {
            addCriterion("expenseTypeId =", value, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidNotEqualTo(Integer value) {
            addCriterion("expenseTypeId <>", value, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidGreaterThan(Integer value) {
            addCriterion("expenseTypeId >", value, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("expenseTypeId >=", value, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidLessThan(Integer value) {
            addCriterion("expenseTypeId <", value, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("expenseTypeId <=", value, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidIn(List<Integer> values) {
            addCriterion("expenseTypeId in", values, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidNotIn(List<Integer> values) {
            addCriterion("expenseTypeId not in", values, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidBetween(Integer value1, Integer value2) {
            addCriterion("expenseTypeId between", value1, value2, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("expenseTypeId not between", value1, value2, "expensetypeid");
            return (Criteria) this;
        }

        public Criteria andExpensetypeIsNull() {
            addCriterion("expenseType is null");
            return (Criteria) this;
        }

        public Criteria andExpensetypeIsNotNull() {
            addCriterion("expenseType is not null");
            return (Criteria) this;
        }

        public Criteria andExpensetypeEqualTo(String value) {
            addCriterion("expenseType =", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeNotEqualTo(String value) {
            addCriterion("expenseType <>", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeGreaterThan(String value) {
            addCriterion("expenseType >", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeGreaterThanOrEqualTo(String value) {
            addCriterion("expenseType >=", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeLessThan(String value) {
            addCriterion("expenseType <", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeLessThanOrEqualTo(String value) {
            addCriterion("expenseType <=", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeLike(String value) {
            addCriterion("expenseType like", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeNotLike(String value) {
            addCriterion("expenseType not like", value, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeIn(List<String> values) {
            addCriterion("expenseType in", values, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeNotIn(List<String> values) {
            addCriterion("expenseType not in", values, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeBetween(String value1, String value2) {
            addCriterion("expenseType between", value1, value2, "expensetype");
            return (Criteria) this;
        }

        public Criteria andExpensetypeNotBetween(String value1, String value2) {
            addCriterion("expenseType not between", value1, value2, "expensetype");
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