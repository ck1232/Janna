package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ViewProductSubOptionInventoryDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewProductSubOptionInventoryDbObjectExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameIsNull() {
            addCriterion("suboption1_name is null");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameIsNotNull() {
            addCriterion("suboption1_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameEqualTo(String value) {
            addCriterion("suboption1_name =", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameNotEqualTo(String value) {
            addCriterion("suboption1_name <>", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameGreaterThan(String value) {
            addCriterion("suboption1_name >", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameGreaterThanOrEqualTo(String value) {
            addCriterion("suboption1_name >=", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameLessThan(String value) {
            addCriterion("suboption1_name <", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameLessThanOrEqualTo(String value) {
            addCriterion("suboption1_name <=", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameLike(String value) {
            addCriterion("suboption1_name like", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameNotLike(String value) {
            addCriterion("suboption1_name not like", value, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameIn(List<String> values) {
            addCriterion("suboption1_name in", values, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameNotIn(List<String> values) {
            addCriterion("suboption1_name not in", values, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameBetween(String value1, String value2) {
            addCriterion("suboption1_name between", value1, value2, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameNotBetween(String value1, String value2) {
            addCriterion("suboption1_name not between", value1, value2, "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdIsNull() {
            addCriterion("suboption1_id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdIsNotNull() {
            addCriterion("suboption1_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdEqualTo(Integer value) {
            addCriterion("suboption1_id =", value, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdNotEqualTo(Integer value) {
            addCriterion("suboption1_id <>", value, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdGreaterThan(Integer value) {
            addCriterion("suboption1_id >", value, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("suboption1_id >=", value, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdLessThan(Integer value) {
            addCriterion("suboption1_id <", value, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdLessThanOrEqualTo(Integer value) {
            addCriterion("suboption1_id <=", value, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdIn(List<Integer> values) {
            addCriterion("suboption1_id in", values, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdNotIn(List<Integer> values) {
            addCriterion("suboption1_id not in", values, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdBetween(Integer value1, Integer value2) {
            addCriterion("suboption1_id between", value1, value2, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption1IdNotBetween(Integer value1, Integer value2) {
            addCriterion("suboption1_id not between", value1, value2, "suboption1Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameIsNull() {
            addCriterion("suboption2_name is null");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameIsNotNull() {
            addCriterion("suboption2_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameEqualTo(String value) {
            addCriterion("suboption2_name =", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameNotEqualTo(String value) {
            addCriterion("suboption2_name <>", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameGreaterThan(String value) {
            addCriterion("suboption2_name >", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameGreaterThanOrEqualTo(String value) {
            addCriterion("suboption2_name >=", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameLessThan(String value) {
            addCriterion("suboption2_name <", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameLessThanOrEqualTo(String value) {
            addCriterion("suboption2_name <=", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameLike(String value) {
            addCriterion("suboption2_name like", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameNotLike(String value) {
            addCriterion("suboption2_name not like", value, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameIn(List<String> values) {
            addCriterion("suboption2_name in", values, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameNotIn(List<String> values) {
            addCriterion("suboption2_name not in", values, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameBetween(String value1, String value2) {
            addCriterion("suboption2_name between", value1, value2, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameNotBetween(String value1, String value2) {
            addCriterion("suboption2_name not between", value1, value2, "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdIsNull() {
            addCriterion("suboption2_id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdIsNotNull() {
            addCriterion("suboption2_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdEqualTo(Integer value) {
            addCriterion("suboption2_id =", value, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdNotEqualTo(Integer value) {
            addCriterion("suboption2_id <>", value, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdGreaterThan(Integer value) {
            addCriterion("suboption2_id >", value, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("suboption2_id >=", value, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdLessThan(Integer value) {
            addCriterion("suboption2_id <", value, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdLessThanOrEqualTo(Integer value) {
            addCriterion("suboption2_id <=", value, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdIn(List<Integer> values) {
            addCriterion("suboption2_id in", values, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdNotIn(List<Integer> values) {
            addCriterion("suboption2_id not in", values, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdBetween(Integer value1, Integer value2) {
            addCriterion("suboption2_id between", value1, value2, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption2IdNotBetween(Integer value1, Integer value2) {
            addCriterion("suboption2_id not between", value1, value2, "suboption2Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameIsNull() {
            addCriterion("suboption3_name is null");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameIsNotNull() {
            addCriterion("suboption3_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameEqualTo(String value) {
            addCriterion("suboption3_name =", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameNotEqualTo(String value) {
            addCriterion("suboption3_name <>", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameGreaterThan(String value) {
            addCriterion("suboption3_name >", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameGreaterThanOrEqualTo(String value) {
            addCriterion("suboption3_name >=", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameLessThan(String value) {
            addCriterion("suboption3_name <", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameLessThanOrEqualTo(String value) {
            addCriterion("suboption3_name <=", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameLike(String value) {
            addCriterion("suboption3_name like", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameNotLike(String value) {
            addCriterion("suboption3_name not like", value, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameIn(List<String> values) {
            addCriterion("suboption3_name in", values, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameNotIn(List<String> values) {
            addCriterion("suboption3_name not in", values, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameBetween(String value1, String value2) {
            addCriterion("suboption3_name between", value1, value2, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameNotBetween(String value1, String value2) {
            addCriterion("suboption3_name not between", value1, value2, "suboption3Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdIsNull() {
            addCriterion("suboption3_id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdIsNotNull() {
            addCriterion("suboption3_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdEqualTo(Integer value) {
            addCriterion("suboption3_id =", value, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdNotEqualTo(Integer value) {
            addCriterion("suboption3_id <>", value, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdGreaterThan(Integer value) {
            addCriterion("suboption3_id >", value, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("suboption3_id >=", value, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdLessThan(Integer value) {
            addCriterion("suboption3_id <", value, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdLessThanOrEqualTo(Integer value) {
            addCriterion("suboption3_id <=", value, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdIn(List<Integer> values) {
            addCriterion("suboption3_id in", values, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdNotIn(List<Integer> values) {
            addCriterion("suboption3_id not in", values, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdBetween(Integer value1, Integer value2) {
            addCriterion("suboption3_id between", value1, value2, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andSuboption3IdNotBetween(Integer value1, Integer value2) {
            addCriterion("suboption3_id not between", value1, value2, "suboption3Id");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("qty is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("qty is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(BigDecimal value) {
            addCriterion("qty =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(BigDecimal value) {
            addCriterion("qty <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(BigDecimal value) {
            addCriterion("qty >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qty >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(BigDecimal value) {
            addCriterion("qty <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qty <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<BigDecimal> values) {
            addCriterion("qty in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<BigDecimal> values) {
            addCriterion("qty not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qty not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andProductNameLikeInsensitive(String value) {
            addCriterion("upper(product_name) like", value.toUpperCase(), "productName");
            return (Criteria) this;
        }

        public Criteria andSuboption1NameLikeInsensitive(String value) {
            addCriterion("upper(suboption1_name) like", value.toUpperCase(), "suboption1Name");
            return (Criteria) this;
        }

        public Criteria andSuboption2NameLikeInsensitive(String value) {
            addCriterion("upper(suboption2_name) like", value.toUpperCase(), "suboption2Name");
            return (Criteria) this;
        }

        public Criteria andSuboption3NameLikeInsensitive(String value) {
            addCriterion("upper(suboption3_name) like", value.toUpperCase(), "suboption3Name");
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