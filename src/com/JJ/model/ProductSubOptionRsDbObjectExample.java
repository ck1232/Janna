package com.JJ.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductSubOptionRsDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductSubOptionRsDbObjectExample() {
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

        public Criteria andProductSuboptionRsIdIsNull() {
            addCriterion("product_suboption_rs_id is null");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdIsNotNull() {
            addCriterion("product_suboption_rs_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdEqualTo(Integer value) {
            addCriterion("product_suboption_rs_id =", value, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdNotEqualTo(Integer value) {
            addCriterion("product_suboption_rs_id <>", value, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdGreaterThan(Integer value) {
            addCriterion("product_suboption_rs_id >", value, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_suboption_rs_id >=", value, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdLessThan(Integer value) {
            addCriterion("product_suboption_rs_id <", value, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_suboption_rs_id <=", value, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdIn(List<Integer> values) {
            addCriterion("product_suboption_rs_id in", values, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdNotIn(List<Integer> values) {
            addCriterion("product_suboption_rs_id not in", values, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdBetween(Integer value1, Integer value2) {
            addCriterion("product_suboption_rs_id between", value1, value2, "productSuboptionRsId");
            return (Criteria) this;
        }

        public Criteria andProductSuboptionRsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_suboption_rs_id not between", value1, value2, "productSuboptionRsId");
            return (Criteria) this;
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