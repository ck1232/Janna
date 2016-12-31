package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchproductRsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BatchproductRsExample() {
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

        public Criteria andBatchproductidIsNull() {
            addCriterion("batchproductId is null");
            return (Criteria) this;
        }

        public Criteria andBatchproductidIsNotNull() {
            addCriterion("batchproductId is not null");
            return (Criteria) this;
        }

        public Criteria andBatchproductidEqualTo(Integer value) {
            addCriterion("batchproductId =", value, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidNotEqualTo(Integer value) {
            addCriterion("batchproductId <>", value, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidGreaterThan(Integer value) {
            addCriterion("batchproductId >", value, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("batchproductId >=", value, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidLessThan(Integer value) {
            addCriterion("batchproductId <", value, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidLessThanOrEqualTo(Integer value) {
            addCriterion("batchproductId <=", value, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidIn(List<Integer> values) {
            addCriterion("batchproductId in", values, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidNotIn(List<Integer> values) {
            addCriterion("batchproductId not in", values, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidBetween(Integer value1, Integer value2) {
            addCriterion("batchproductId between", value1, value2, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchproductidNotBetween(Integer value1, Integer value2) {
            addCriterion("batchproductId not between", value1, value2, "batchproductid");
            return (Criteria) this;
        }

        public Criteria andBatchidIsNull() {
            addCriterion("batchid is null");
            return (Criteria) this;
        }

        public Criteria andBatchidIsNotNull() {
            addCriterion("batchid is not null");
            return (Criteria) this;
        }

        public Criteria andBatchidEqualTo(Integer value) {
            addCriterion("batchid =", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotEqualTo(Integer value) {
            addCriterion("batchid <>", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThan(Integer value) {
            addCriterion("batchid >", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThanOrEqualTo(Integer value) {
            addCriterion("batchid >=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThan(Integer value) {
            addCriterion("batchid <", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThanOrEqualTo(Integer value) {
            addCriterion("batchid <=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidIn(List<Integer> values) {
            addCriterion("batchid in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotIn(List<Integer> values) {
            addCriterion("batchid not in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidBetween(Integer value1, Integer value2) {
            addCriterion("batchid between", value1, value2, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotBetween(Integer value1, Integer value2) {
            addCriterion("batchid not between", value1, value2, "batchid");
            return (Criteria) this;
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

        public Criteria andUnitcostIsNull() {
            addCriterion("unitcost is null");
            return (Criteria) this;
        }

        public Criteria andUnitcostIsNotNull() {
            addCriterion("unitcost is not null");
            return (Criteria) this;
        }

        public Criteria andUnitcostEqualTo(BigDecimal value) {
            addCriterion("unitcost =", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostNotEqualTo(BigDecimal value) {
            addCriterion("unitcost <>", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostGreaterThan(BigDecimal value) {
            addCriterion("unitcost >", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unitcost >=", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostLessThan(BigDecimal value) {
            addCriterion("unitcost <", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unitcost <=", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostIn(List<BigDecimal> values) {
            addCriterion("unitcost in", values, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostNotIn(List<BigDecimal> values) {
            addCriterion("unitcost not in", values, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitcost between", value1, value2, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitcost not between", value1, value2, "unitcost");
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

        public Criteria andQtyEqualTo(Integer value) {
            addCriterion("qty =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(Integer value) {
            addCriterion("qty <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(Integer value) {
            addCriterion("qty >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("qty >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(Integer value) {
            addCriterion("qty <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(Integer value) {
            addCriterion("qty <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<Integer> values) {
            addCriterion("qty in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<Integer> values) {
            addCriterion("qty not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(Integer value1, Integer value2) {
            addCriterion("qty between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("qty not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andDeleteindIsNull() {
            addCriterion("deleteind is null");
            return (Criteria) this;
        }

        public Criteria andDeleteindIsNotNull() {
            addCriterion("deleteind is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteindEqualTo(String value) {
            addCriterion("deleteind =", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindNotEqualTo(String value) {
            addCriterion("deleteind <>", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindGreaterThan(String value) {
            addCriterion("deleteind >", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindGreaterThanOrEqualTo(String value) {
            addCriterion("deleteind >=", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindLessThan(String value) {
            addCriterion("deleteind <", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindLessThanOrEqualTo(String value) {
            addCriterion("deleteind <=", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindLike(String value) {
            addCriterion("deleteind like", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindNotLike(String value) {
            addCriterion("deleteind not like", value, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindIn(List<String> values) {
            addCriterion("deleteind in", values, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindNotIn(List<String> values) {
            addCriterion("deleteind not in", values, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindBetween(String value1, String value2) {
            addCriterion("deleteind between", value1, value2, "deleteind");
            return (Criteria) this;
        }

        public Criteria andDeleteindNotBetween(String value1, String value2) {
            addCriterion("deleteind not between", value1, value2, "deleteind");
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