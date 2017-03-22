package com.JJ.model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTypeDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseTypeDbObjectExample() {
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

        public Criteria andExpenseTypeIdIsNull() {
            addCriterion("expense_type_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdIsNotNull() {
            addCriterion("expense_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdEqualTo(Integer value) {
            addCriterion("expense_type_id =", value, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdNotEqualTo(Integer value) {
            addCriterion("expense_type_id <>", value, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdGreaterThan(Integer value) {
            addCriterion("expense_type_id >", value, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("expense_type_id >=", value, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdLessThan(Integer value) {
            addCriterion("expense_type_id <", value, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("expense_type_id <=", value, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdIn(List<Integer> values) {
            addCriterion("expense_type_id in", values, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdNotIn(List<Integer> values) {
            addCriterion("expense_type_id not in", values, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("expense_type_id between", value1, value2, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("expense_type_id not between", value1, value2, "expenseTypeId");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIsNull() {
            addCriterion("expense_type is null");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIsNotNull() {
            addCriterion("expense_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeEqualTo(String value) {
            addCriterion("expense_type =", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeNotEqualTo(String value) {
            addCriterion("expense_type <>", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeGreaterThan(String value) {
            addCriterion("expense_type >", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("expense_type >=", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeLessThan(String value) {
            addCriterion("expense_type <", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeLessThanOrEqualTo(String value) {
            addCriterion("expense_type <=", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeLike(String value) {
            addCriterion("expense_type like", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeNotLike(String value) {
            addCriterion("expense_type not like", value, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeIn(List<String> values) {
            addCriterion("expense_type in", values, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeNotIn(List<String> values) {
            addCriterion("expense_type not in", values, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeBetween(String value1, String value2) {
            addCriterion("expense_type between", value1, value2, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeNotBetween(String value1, String value2) {
            addCriterion("expense_type not between", value1, value2, "expenseType");
            return (Criteria) this;
        }

        public Criteria andExpenseTypeLikeInsensitive(String value) {
            addCriterion("upper(expense_type) like", value.toUpperCase(), "expenseType");
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