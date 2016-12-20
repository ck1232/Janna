package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ViewProductSuboptionInventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewProductSuboptionInventoryExample() {
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

        public Criteria andProductnameIsNull() {
            addCriterion("ProductName is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("ProductName is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("ProductName =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("ProductName <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("ProductName >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("ProductName >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("ProductName <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("ProductName <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("ProductName like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("ProductName not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("ProductName in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("ProductName not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("ProductName between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("ProductName not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("ProductId is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("ProductId is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Integer value) {
            addCriterion("ProductId =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Integer value) {
            addCriterion("ProductId <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Integer value) {
            addCriterion("ProductId >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ProductId >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Integer value) {
            addCriterion("ProductId <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Integer value) {
            addCriterion("ProductId <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Integer> values) {
            addCriterion("ProductId in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Integer> values) {
            addCriterion("ProductId not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Integer value1, Integer value2) {
            addCriterion("ProductId between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Integer value1, Integer value2) {
            addCriterion("ProductId not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameIsNull() {
            addCriterion("suboption1Name is null");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameIsNotNull() {
            addCriterion("suboption1Name is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameEqualTo(String value) {
            addCriterion("suboption1Name =", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameNotEqualTo(String value) {
            addCriterion("suboption1Name <>", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameGreaterThan(String value) {
            addCriterion("suboption1Name >", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameGreaterThanOrEqualTo(String value) {
            addCriterion("suboption1Name >=", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameLessThan(String value) {
            addCriterion("suboption1Name <", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameLessThanOrEqualTo(String value) {
            addCriterion("suboption1Name <=", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameLike(String value) {
            addCriterion("suboption1Name like", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameNotLike(String value) {
            addCriterion("suboption1Name not like", value, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameIn(List<String> values) {
            addCriterion("suboption1Name in", values, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameNotIn(List<String> values) {
            addCriterion("suboption1Name not in", values, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameBetween(String value1, String value2) {
            addCriterion("suboption1Name between", value1, value2, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1nameNotBetween(String value1, String value2) {
            addCriterion("suboption1Name not between", value1, value2, "suboption1name");
            return (Criteria) this;
        }

        public Criteria andSuboption1idIsNull() {
            addCriterion("subOption1Id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption1idIsNotNull() {
            addCriterion("subOption1Id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption1idEqualTo(Integer value) {
            addCriterion("subOption1Id =", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idNotEqualTo(Integer value) {
            addCriterion("subOption1Id <>", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idGreaterThan(Integer value) {
            addCriterion("subOption1Id >", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idGreaterThanOrEqualTo(Integer value) {
            addCriterion("subOption1Id >=", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idLessThan(Integer value) {
            addCriterion("subOption1Id <", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idLessThanOrEqualTo(Integer value) {
            addCriterion("subOption1Id <=", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idIn(List<Integer> values) {
            addCriterion("subOption1Id in", values, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idNotIn(List<Integer> values) {
            addCriterion("subOption1Id not in", values, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idBetween(Integer value1, Integer value2) {
            addCriterion("subOption1Id between", value1, value2, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idNotBetween(Integer value1, Integer value2) {
            addCriterion("subOption1Id not between", value1, value2, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameIsNull() {
            addCriterion("suboption2Name is null");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameIsNotNull() {
            addCriterion("suboption2Name is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameEqualTo(String value) {
            addCriterion("suboption2Name =", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameNotEqualTo(String value) {
            addCriterion("suboption2Name <>", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameGreaterThan(String value) {
            addCriterion("suboption2Name >", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameGreaterThanOrEqualTo(String value) {
            addCriterion("suboption2Name >=", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameLessThan(String value) {
            addCriterion("suboption2Name <", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameLessThanOrEqualTo(String value) {
            addCriterion("suboption2Name <=", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameLike(String value) {
            addCriterion("suboption2Name like", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameNotLike(String value) {
            addCriterion("suboption2Name not like", value, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameIn(List<String> values) {
            addCriterion("suboption2Name in", values, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameNotIn(List<String> values) {
            addCriterion("suboption2Name not in", values, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameBetween(String value1, String value2) {
            addCriterion("suboption2Name between", value1, value2, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2nameNotBetween(String value1, String value2) {
            addCriterion("suboption2Name not between", value1, value2, "suboption2name");
            return (Criteria) this;
        }

        public Criteria andSuboption2idIsNull() {
            addCriterion("subOption2Id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption2idIsNotNull() {
            addCriterion("subOption2Id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption2idEqualTo(Integer value) {
            addCriterion("subOption2Id =", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idNotEqualTo(Integer value) {
            addCriterion("subOption2Id <>", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idGreaterThan(Integer value) {
            addCriterion("subOption2Id >", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idGreaterThanOrEqualTo(Integer value) {
            addCriterion("subOption2Id >=", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idLessThan(Integer value) {
            addCriterion("subOption2Id <", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idLessThanOrEqualTo(Integer value) {
            addCriterion("subOption2Id <=", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idIn(List<Integer> values) {
            addCriterion("subOption2Id in", values, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idNotIn(List<Integer> values) {
            addCriterion("subOption2Id not in", values, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idBetween(Integer value1, Integer value2) {
            addCriterion("subOption2Id between", value1, value2, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idNotBetween(Integer value1, Integer value2) {
            addCriterion("subOption2Id not between", value1, value2, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameIsNull() {
            addCriterion("suboption3Name is null");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameIsNotNull() {
            addCriterion("suboption3Name is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameEqualTo(String value) {
            addCriterion("suboption3Name =", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameNotEqualTo(String value) {
            addCriterion("suboption3Name <>", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameGreaterThan(String value) {
            addCriterion("suboption3Name >", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameGreaterThanOrEqualTo(String value) {
            addCriterion("suboption3Name >=", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameLessThan(String value) {
            addCriterion("suboption3Name <", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameLessThanOrEqualTo(String value) {
            addCriterion("suboption3Name <=", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameLike(String value) {
            addCriterion("suboption3Name like", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameNotLike(String value) {
            addCriterion("suboption3Name not like", value, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameIn(List<String> values) {
            addCriterion("suboption3Name in", values, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameNotIn(List<String> values) {
            addCriterion("suboption3Name not in", values, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameBetween(String value1, String value2) {
            addCriterion("suboption3Name between", value1, value2, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3nameNotBetween(String value1, String value2) {
            addCriterion("suboption3Name not between", value1, value2, "suboption3name");
            return (Criteria) this;
        }

        public Criteria andSuboption3idIsNull() {
            addCriterion("subOption3Id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption3idIsNotNull() {
            addCriterion("subOption3Id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption3idEqualTo(Integer value) {
            addCriterion("subOption3Id =", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idNotEqualTo(Integer value) {
            addCriterion("subOption3Id <>", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idGreaterThan(Integer value) {
            addCriterion("subOption3Id >", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idGreaterThanOrEqualTo(Integer value) {
            addCriterion("subOption3Id >=", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idLessThan(Integer value) {
            addCriterion("subOption3Id <", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idLessThanOrEqualTo(Integer value) {
            addCriterion("subOption3Id <=", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idIn(List<Integer> values) {
            addCriterion("subOption3Id in", values, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idNotIn(List<Integer> values) {
            addCriterion("subOption3Id not in", values, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idBetween(Integer value1, Integer value2) {
            addCriterion("subOption3Id between", value1, value2, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idNotBetween(Integer value1, Integer value2) {
            addCriterion("subOption3Id not between", value1, value2, "suboption3id");
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