package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProductInventoryDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductInventoryDbObjectExample() {
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

        public Criteria andProductInventoryIdIsNull() {
            addCriterion("product_inventory_id is null");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdIsNotNull() {
            addCriterion("product_inventory_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdEqualTo(Integer value) {
            addCriterion("product_inventory_id =", value, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdNotEqualTo(Integer value) {
            addCriterion("product_inventory_id <>", value, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdGreaterThan(Integer value) {
            addCriterion("product_inventory_id >", value, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_inventory_id >=", value, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdLessThan(Integer value) {
            addCriterion("product_inventory_id <", value, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_inventory_id <=", value, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdIn(List<Integer> values) {
            addCriterion("product_inventory_id in", values, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdNotIn(List<Integer> values) {
            addCriterion("product_inventory_id not in", values, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdBetween(Integer value1, Integer value2) {
            addCriterion("product_inventory_id between", value1, value2, "productInventoryId");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_inventory_id not between", value1, value2, "productInventoryId");
            return (Criteria) this;
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

        public Criteria andTransferFromIsNull() {
            addCriterion("transfer_from is null");
            return (Criteria) this;
        }

        public Criteria andTransferFromIsNotNull() {
            addCriterion("transfer_from is not null");
            return (Criteria) this;
        }

        public Criteria andTransferFromEqualTo(Integer value) {
            addCriterion("transfer_from =", value, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromNotEqualTo(Integer value) {
            addCriterion("transfer_from <>", value, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromGreaterThan(Integer value) {
            addCriterion("transfer_from >", value, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_from >=", value, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromLessThan(Integer value) {
            addCriterion("transfer_from <", value, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_from <=", value, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromIn(List<Integer> values) {
            addCriterion("transfer_from in", values, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromNotIn(List<Integer> values) {
            addCriterion("transfer_from not in", values, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromBetween(Integer value1, Integer value2) {
            addCriterion("transfer_from between", value1, value2, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferFromNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_from not between", value1, value2, "transferFrom");
            return (Criteria) this;
        }

        public Criteria andTransferToIsNull() {
            addCriterion("transfer_to is null");
            return (Criteria) this;
        }

        public Criteria andTransferToIsNotNull() {
            addCriterion("transfer_to is not null");
            return (Criteria) this;
        }

        public Criteria andTransferToEqualTo(Integer value) {
            addCriterion("transfer_to =", value, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToNotEqualTo(Integer value) {
            addCriterion("transfer_to <>", value, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToGreaterThan(Integer value) {
            addCriterion("transfer_to >", value, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_to >=", value, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToLessThan(Integer value) {
            addCriterion("transfer_to <", value, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_to <=", value, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToIn(List<Integer> values) {
            addCriterion("transfer_to in", values, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToNotIn(List<Integer> values) {
            addCriterion("transfer_to not in", values, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToBetween(Integer value1, Integer value2) {
            addCriterion("transfer_to between", value1, value2, "transferTo");
            return (Criteria) this;
        }

        public Criteria andTransferToNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_to not between", value1, value2, "transferTo");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusIsNull() {
            addCriterion("plus_or_minus is null");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusIsNotNull() {
            addCriterion("plus_or_minus is not null");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusEqualTo(Boolean value) {
            addCriterion("plus_or_minus =", value, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusNotEqualTo(Boolean value) {
            addCriterion("plus_or_minus <>", value, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusGreaterThan(Boolean value) {
            addCriterion("plus_or_minus >", value, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("plus_or_minus >=", value, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusLessThan(Boolean value) {
            addCriterion("plus_or_minus <", value, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusLessThanOrEqualTo(Boolean value) {
            addCriterion("plus_or_minus <=", value, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusIn(List<Boolean> values) {
            addCriterion("plus_or_minus in", values, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusNotIn(List<Boolean> values) {
            addCriterion("plus_or_minus not in", values, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusBetween(Boolean value1, Boolean value2) {
            addCriterion("plus_or_minus between", value1, value2, "plusOrMinus");
            return (Criteria) this;
        }

        public Criteria andPlusOrMinusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("plus_or_minus not between", value1, value2, "plusOrMinus");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andUnitAmtIsNull() {
            addCriterion("unit_amt is null");
            return (Criteria) this;
        }

        public Criteria andUnitAmtIsNotNull() {
            addCriterion("unit_amt is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAmtEqualTo(BigDecimal value) {
            addCriterion("unit_amt =", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtNotEqualTo(BigDecimal value) {
            addCriterion("unit_amt <>", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtGreaterThan(BigDecimal value) {
            addCriterion("unit_amt >", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_amt >=", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtLessThan(BigDecimal value) {
            addCriterion("unit_amt <", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_amt <=", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtIn(List<BigDecimal> values) {
            addCriterion("unit_amt in", values, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtNotIn(List<BigDecimal> values) {
            addCriterion("unit_amt not in", values, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_amt between", value1, value2, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_amt not between", value1, value2, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(String value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(String value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(String value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(String value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(String value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(String value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLike(String value) {
            addCriterion("mode like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotLike(String value) {
            addCriterion("mode not like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<String> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<String> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(String value1, String value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(String value1, String value2) {
            addCriterion("mode not between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andReferenceIdIsNull() {
            addCriterion("reference_id is null");
            return (Criteria) this;
        }

        public Criteria andReferenceIdIsNotNull() {
            addCriterion("reference_id is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceIdEqualTo(Integer value) {
            addCriterion("reference_id =", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdNotEqualTo(Integer value) {
            addCriterion("reference_id <>", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdGreaterThan(Integer value) {
            addCriterion("reference_id >", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reference_id >=", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdLessThan(Integer value) {
            addCriterion("reference_id <", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdLessThanOrEqualTo(Integer value) {
            addCriterion("reference_id <=", value, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdIn(List<Integer> values) {
            addCriterion("reference_id in", values, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdNotIn(List<Integer> values) {
            addCriterion("reference_id not in", values, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdBetween(Integer value1, Integer value2) {
            addCriterion("reference_id between", value1, value2, "referenceId");
            return (Criteria) this;
        }

        public Criteria andReferenceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reference_id not between", value1, value2, "referenceId");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksIsNull() {
            addCriterion("delete_remarks is null");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksIsNotNull() {
            addCriterion("delete_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksEqualTo(String value) {
            addCriterion("delete_remarks =", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksNotEqualTo(String value) {
            addCriterion("delete_remarks <>", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksGreaterThan(String value) {
            addCriterion("delete_remarks >", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("delete_remarks >=", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksLessThan(String value) {
            addCriterion("delete_remarks <", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksLessThanOrEqualTo(String value) {
            addCriterion("delete_remarks <=", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksLike(String value) {
            addCriterion("delete_remarks like", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksNotLike(String value) {
            addCriterion("delete_remarks not like", value, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksIn(List<String> values) {
            addCriterion("delete_remarks in", values, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksNotIn(List<String> values) {
            addCriterion("delete_remarks not in", values, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksBetween(String value1, String value2) {
            addCriterion("delete_remarks between", value1, value2, "deleteRemarks");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksNotBetween(String value1, String value2) {
            addCriterion("delete_remarks not between", value1, value2, "deleteRemarks");
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

        public Criteria andRemarksLikeInsensitive(String value) {
            addCriterion("upper(remarks) like", value.toUpperCase(), "remarks");
            return (Criteria) this;
        }

        public Criteria andModeLikeInsensitive(String value) {
            addCriterion("upper(mode) like", value.toUpperCase(), "mode");
            return (Criteria) this;
        }

        public Criteria andDeleteRemarksLikeInsensitive(String value) {
            addCriterion("upper(delete_remarks) like", value.toUpperCase(), "deleteRemarks");
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