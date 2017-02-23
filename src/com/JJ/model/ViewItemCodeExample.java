package com.JJ.model;

import java.util.ArrayList;
import java.util.List;

public class ViewItemCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewItemCodeExample() {
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

        public Criteria andProductsuboptionrsidIsNull() {
            addCriterion("productsuboptionRsId is null");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidIsNotNull() {
            addCriterion("productsuboptionRsId is not null");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidEqualTo(Integer value) {
            addCriterion("productsuboptionRsId =", value, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidNotEqualTo(Integer value) {
            addCriterion("productsuboptionRsId <>", value, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidGreaterThan(Integer value) {
            addCriterion("productsuboptionRsId >", value, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productsuboptionRsId >=", value, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidLessThan(Integer value) {
            addCriterion("productsuboptionRsId <", value, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidLessThanOrEqualTo(Integer value) {
            addCriterion("productsuboptionRsId <=", value, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidIn(List<Integer> values) {
            addCriterion("productsuboptionRsId in", values, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidNotIn(List<Integer> values) {
            addCriterion("productsuboptionRsId not in", values, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidBetween(Integer value1, Integer value2) {
            addCriterion("productsuboptionRsId between", value1, value2, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionrsidNotBetween(Integer value1, Integer value2) {
            addCriterion("productsuboptionRsId not between", value1, value2, "productsuboptionrsid");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Integer value) {
            addCriterion("productId =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Integer value) {
            addCriterion("productId <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Integer value) {
            addCriterion("productId >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productId >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Integer value) {
            addCriterion("productId <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Integer value) {
            addCriterion("productId <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Integer> values) {
            addCriterion("productId in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Integer> values) {
            addCriterion("productId not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Integer value1, Integer value2) {
            addCriterion("productId between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Integer value1, Integer value2) {
            addCriterion("productId not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("productName =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("productName >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("productName <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("productName like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("productName not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("productName in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productname");
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

        public Criteria andItemCodeIsNull() {
            addCriterion("item_code is null");
            return (Criteria) this;
        }

        public Criteria andItemCodeIsNotNull() {
            addCriterion("item_code is not null");
            return (Criteria) this;
        }

        public Criteria andItemCodeEqualTo(String value) {
            addCriterion("item_code =", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            addCriterion("item_code <>", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThan(String value) {
            addCriterion("item_code >", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("item_code >=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThan(String value) {
            addCriterion("item_code <", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            addCriterion("item_code <=", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeLike(String value) {
            addCriterion("item_code like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotLike(String value) {
            addCriterion("item_code not like", value, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeIn(List<String> values) {
            addCriterion("item_code in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            addCriterion("item_code not in", values, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            addCriterion("item_code between", value1, value2, "itemCode");
            return (Criteria) this;
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            addCriterion("item_code not between", value1, value2, "itemCode");
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