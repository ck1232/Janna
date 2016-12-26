package com.JJ.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductsuboptionRsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductsuboptionRsExample() {
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

        public Criteria andProductsuboptionidIsNull() {
            addCriterion("productsuboptionId is null");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidIsNotNull() {
            addCriterion("productsuboptionId is not null");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidEqualTo(Integer value) {
            addCriterion("productsuboptionId =", value, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidNotEqualTo(Integer value) {
            addCriterion("productsuboptionId <>", value, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidGreaterThan(Integer value) {
            addCriterion("productsuboptionId >", value, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productsuboptionId >=", value, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidLessThan(Integer value) {
            addCriterion("productsuboptionId <", value, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidLessThanOrEqualTo(Integer value) {
            addCriterion("productsuboptionId <=", value, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidIn(List<Integer> values) {
            addCriterion("productsuboptionId in", values, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidNotIn(List<Integer> values) {
            addCriterion("productsuboptionId not in", values, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidBetween(Integer value1, Integer value2) {
            addCriterion("productsuboptionId between", value1, value2, "productsuboptionid");
            return (Criteria) this;
        }

        public Criteria andProductsuboptionidNotBetween(Integer value1, Integer value2) {
            addCriterion("productsuboptionId not between", value1, value2, "productsuboptionid");
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

        public Criteria andSuboption1idIsNull() {
            addCriterion("suboption1Id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption1idIsNotNull() {
            addCriterion("suboption1Id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption1idEqualTo(Integer value) {
            addCriterion("suboption1Id =", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idNotEqualTo(Integer value) {
            addCriterion("suboption1Id <>", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idGreaterThan(Integer value) {
            addCriterion("suboption1Id >", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idGreaterThanOrEqualTo(Integer value) {
            addCriterion("suboption1Id >=", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idLessThan(Integer value) {
            addCriterion("suboption1Id <", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idLessThanOrEqualTo(Integer value) {
            addCriterion("suboption1Id <=", value, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idIn(List<Integer> values) {
            addCriterion("suboption1Id in", values, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idNotIn(List<Integer> values) {
            addCriterion("suboption1Id not in", values, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idBetween(Integer value1, Integer value2) {
            addCriterion("suboption1Id between", value1, value2, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption1idNotBetween(Integer value1, Integer value2) {
            addCriterion("suboption1Id not between", value1, value2, "suboption1id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idIsNull() {
            addCriterion("suboption2Id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption2idIsNotNull() {
            addCriterion("suboption2Id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption2idEqualTo(Integer value) {
            addCriterion("suboption2Id =", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idNotEqualTo(Integer value) {
            addCriterion("suboption2Id <>", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idGreaterThan(Integer value) {
            addCriterion("suboption2Id >", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idGreaterThanOrEqualTo(Integer value) {
            addCriterion("suboption2Id >=", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idLessThan(Integer value) {
            addCriterion("suboption2Id <", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idLessThanOrEqualTo(Integer value) {
            addCriterion("suboption2Id <=", value, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idIn(List<Integer> values) {
            addCriterion("suboption2Id in", values, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idNotIn(List<Integer> values) {
            addCriterion("suboption2Id not in", values, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idBetween(Integer value1, Integer value2) {
            addCriterion("suboption2Id between", value1, value2, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption2idNotBetween(Integer value1, Integer value2) {
            addCriterion("suboption2Id not between", value1, value2, "suboption2id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idIsNull() {
            addCriterion("suboption3Id is null");
            return (Criteria) this;
        }

        public Criteria andSuboption3idIsNotNull() {
            addCriterion("suboption3Id is not null");
            return (Criteria) this;
        }

        public Criteria andSuboption3idEqualTo(Integer value) {
            addCriterion("suboption3Id =", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idNotEqualTo(Integer value) {
            addCriterion("suboption3Id <>", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idGreaterThan(Integer value) {
            addCriterion("suboption3Id >", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idGreaterThanOrEqualTo(Integer value) {
            addCriterion("suboption3Id >=", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idLessThan(Integer value) {
            addCriterion("suboption3Id <", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idLessThanOrEqualTo(Integer value) {
            addCriterion("suboption3Id <=", value, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idIn(List<Integer> values) {
            addCriterion("suboption3Id in", values, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idNotIn(List<Integer> values) {
            addCriterion("suboption3Id not in", values, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idBetween(Integer value1, Integer value2) {
            addCriterion("suboption3Id between", value1, value2, "suboption3id");
            return (Criteria) this;
        }

        public Criteria andSuboption3idNotBetween(Integer value1, Integer value2) {
            addCriterion("suboption3Id not between", value1, value2, "suboption3id");
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