package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductinventoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductinventoryExample() {
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

        public Criteria andProductinventoryidIsNull() {
            addCriterion("productInventoryId is null");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidIsNotNull() {
            addCriterion("productInventoryId is not null");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidEqualTo(Integer value) {
            addCriterion("productInventoryId =", value, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidNotEqualTo(Integer value) {
            addCriterion("productInventoryId <>", value, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidGreaterThan(Integer value) {
            addCriterion("productInventoryId >", value, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productInventoryId >=", value, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidLessThan(Integer value) {
            addCriterion("productInventoryId <", value, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidLessThanOrEqualTo(Integer value) {
            addCriterion("productInventoryId <=", value, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidIn(List<Integer> values) {
            addCriterion("productInventoryId in", values, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidNotIn(List<Integer> values) {
            addCriterion("productInventoryId not in", values, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidBetween(Integer value1, Integer value2) {
            addCriterion("productInventoryId between", value1, value2, "productinventoryid");
            return (Criteria) this;
        }

        public Criteria andProductinventoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("productInventoryId not between", value1, value2, "productinventoryid");
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

        public Criteria andTransferfromIsNull() {
            addCriterion("transferFrom is null");
            return (Criteria) this;
        }

        public Criteria andTransferfromIsNotNull() {
            addCriterion("transferFrom is not null");
            return (Criteria) this;
        }

        public Criteria andTransferfromEqualTo(Integer value) {
            addCriterion("transferFrom =", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromNotEqualTo(Integer value) {
            addCriterion("transferFrom <>", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromGreaterThan(Integer value) {
            addCriterion("transferFrom >", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromGreaterThanOrEqualTo(Integer value) {
            addCriterion("transferFrom >=", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromLessThan(Integer value) {
            addCriterion("transferFrom <", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromLessThanOrEqualTo(Integer value) {
            addCriterion("transferFrom <=", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromIn(List<Integer> values) {
            addCriterion("transferFrom in", values, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromNotIn(List<Integer> values) {
            addCriterion("transferFrom not in", values, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromBetween(Integer value1, Integer value2) {
            addCriterion("transferFrom between", value1, value2, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromNotBetween(Integer value1, Integer value2) {
            addCriterion("transferFrom not between", value1, value2, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransfertoIsNull() {
            addCriterion("transferTo is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoIsNotNull() {
            addCriterion("transferTo is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoEqualTo(Integer value) {
            addCriterion("transferTo =", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoNotEqualTo(Integer value) {
            addCriterion("transferTo <>", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoGreaterThan(Integer value) {
            addCriterion("transferTo >", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoGreaterThanOrEqualTo(Integer value) {
            addCriterion("transferTo >=", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoLessThan(Integer value) {
            addCriterion("transferTo <", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoLessThanOrEqualTo(Integer value) {
            addCriterion("transferTo <=", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoIn(List<Integer> values) {
            addCriterion("transferTo in", values, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoNotIn(List<Integer> values) {
            addCriterion("transferTo not in", values, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoBetween(Integer value1, Integer value2) {
            addCriterion("transferTo between", value1, value2, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoNotBetween(Integer value1, Integer value2) {
            addCriterion("transferTo not between", value1, value2, "transferto");
            return (Criteria) this;
        }

        public Criteria andPlusorminusIsNull() {
            addCriterion("plusOrMinus is null");
            return (Criteria) this;
        }

        public Criteria andPlusorminusIsNotNull() {
            addCriterion("plusOrMinus is not null");
            return (Criteria) this;
        }

        public Criteria andPlusorminusEqualTo(Boolean value) {
            addCriterion("plusOrMinus =", value, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusNotEqualTo(Boolean value) {
            addCriterion("plusOrMinus <>", value, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusGreaterThan(Boolean value) {
            addCriterion("plusOrMinus >", value, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("plusOrMinus >=", value, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusLessThan(Boolean value) {
            addCriterion("plusOrMinus <", value, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusLessThanOrEqualTo(Boolean value) {
            addCriterion("plusOrMinus <=", value, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusIn(List<Boolean> values) {
            addCriterion("plusOrMinus in", values, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusNotIn(List<Boolean> values) {
            addCriterion("plusOrMinus not in", values, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusBetween(Boolean value1, Boolean value2) {
            addCriterion("plusOrMinus between", value1, value2, "plusorminus");
            return (Criteria) this;
        }

        public Criteria andPlusorminusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("plusOrMinus not between", value1, value2, "plusorminus");
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

        public Criteria andUnitcostIsNull() {
            addCriterion("unitCost is null");
            return (Criteria) this;
        }

        public Criteria andUnitcostIsNotNull() {
            addCriterion("unitCost is not null");
            return (Criteria) this;
        }

        public Criteria andUnitcostEqualTo(BigDecimal value) {
            addCriterion("unitCost =", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostNotEqualTo(BigDecimal value) {
            addCriterion("unitCost <>", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostGreaterThan(BigDecimal value) {
            addCriterion("unitCost >", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unitCost >=", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostLessThan(BigDecimal value) {
            addCriterion("unitCost <", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unitCost <=", value, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostIn(List<BigDecimal> values) {
            addCriterion("unitCost in", values, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostNotIn(List<BigDecimal> values) {
            addCriterion("unitCost not in", values, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitCost between", value1, value2, "unitcost");
            return (Criteria) this;
        }

        public Criteria andUnitcostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitCost not between", value1, value2, "unitcost");
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

        public Criteria andReferenceidIsNull() {
            addCriterion("referenceId is null");
            return (Criteria) this;
        }

        public Criteria andReferenceidIsNotNull() {
            addCriterion("referenceId is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceidEqualTo(Integer value) {
            addCriterion("referenceId =", value, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidNotEqualTo(Integer value) {
            addCriterion("referenceId <>", value, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidGreaterThan(Integer value) {
            addCriterion("referenceId >", value, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("referenceId >=", value, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidLessThan(Integer value) {
            addCriterion("referenceId <", value, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidLessThanOrEqualTo(Integer value) {
            addCriterion("referenceId <=", value, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidIn(List<Integer> values) {
            addCriterion("referenceId in", values, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidNotIn(List<Integer> values) {
            addCriterion("referenceId not in", values, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidBetween(Integer value1, Integer value2) {
            addCriterion("referenceId between", value1, value2, "referenceid");
            return (Criteria) this;
        }

        public Criteria andReferenceidNotBetween(Integer value1, Integer value2) {
            addCriterion("referenceId not between", value1, value2, "referenceid");
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

        public Criteria andDeleteremarksIsNull() {
            addCriterion("deleteRemarks is null");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksIsNotNull() {
            addCriterion("deleteRemarks is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksEqualTo(String value) {
            addCriterion("deleteRemarks =", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksNotEqualTo(String value) {
            addCriterion("deleteRemarks <>", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksGreaterThan(String value) {
            addCriterion("deleteRemarks >", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksGreaterThanOrEqualTo(String value) {
            addCriterion("deleteRemarks >=", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksLessThan(String value) {
            addCriterion("deleteRemarks <", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksLessThanOrEqualTo(String value) {
            addCriterion("deleteRemarks <=", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksLike(String value) {
            addCriterion("deleteRemarks like", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksNotLike(String value) {
            addCriterion("deleteRemarks not like", value, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksIn(List<String> values) {
            addCriterion("deleteRemarks in", values, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksNotIn(List<String> values) {
            addCriterion("deleteRemarks not in", values, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksBetween(String value1, String value2) {
            addCriterion("deleteRemarks between", value1, value2, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andDeleteremarksNotBetween(String value1, String value2) {
            addCriterion("deleteRemarks not between", value1, value2, "deleteremarks");
            return (Criteria) this;
        }

        public Criteria andCreatedonIsNull() {
            addCriterion("createdOn is null");
            return (Criteria) this;
        }

        public Criteria andCreatedonIsNotNull() {
            addCriterion("createdOn is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedonEqualTo(Date value) {
            addCriterion("createdOn =", value, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonNotEqualTo(Date value) {
            addCriterion("createdOn <>", value, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonGreaterThan(Date value) {
            addCriterion("createdOn >", value, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonGreaterThanOrEqualTo(Date value) {
            addCriterion("createdOn >=", value, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonLessThan(Date value) {
            addCriterion("createdOn <", value, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonLessThanOrEqualTo(Date value) {
            addCriterion("createdOn <=", value, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonIn(List<Date> values) {
            addCriterion("createdOn in", values, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonNotIn(List<Date> values) {
            addCriterion("createdOn not in", values, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonBetween(Date value1, Date value2) {
            addCriterion("createdOn between", value1, value2, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedonNotBetween(Date value1, Date value2) {
            addCriterion("createdOn not between", value1, value2, "createdon");
            return (Criteria) this;
        }

        public Criteria andCreatedbyIsNull() {
            addCriterion("createdBy is null");
            return (Criteria) this;
        }

        public Criteria andCreatedbyIsNotNull() {
            addCriterion("createdBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedbyEqualTo(String value) {
            addCriterion("createdBy =", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotEqualTo(String value) {
            addCriterion("createdBy <>", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyGreaterThan(String value) {
            addCriterion("createdBy >", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyGreaterThanOrEqualTo(String value) {
            addCriterion("createdBy >=", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyLessThan(String value) {
            addCriterion("createdBy <", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyLessThanOrEqualTo(String value) {
            addCriterion("createdBy <=", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyLike(String value) {
            addCriterion("createdBy like", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotLike(String value) {
            addCriterion("createdBy not like", value, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyIn(List<String> values) {
            addCriterion("createdBy in", values, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotIn(List<String> values) {
            addCriterion("createdBy not in", values, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyBetween(String value1, String value2) {
            addCriterion("createdBy between", value1, value2, "createdby");
            return (Criteria) this;
        }

        public Criteria andCreatedbyNotBetween(String value1, String value2) {
            addCriterion("createdBy not between", value1, value2, "createdby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyIsNull() {
            addCriterion("updatedBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyIsNotNull() {
            addCriterion("updatedBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyEqualTo(String value) {
            addCriterion("updatedBy =", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyNotEqualTo(String value) {
            addCriterion("updatedBy <>", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyGreaterThan(String value) {
            addCriterion("updatedBy >", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyGreaterThanOrEqualTo(String value) {
            addCriterion("updatedBy >=", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyLessThan(String value) {
            addCriterion("updatedBy <", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyLessThanOrEqualTo(String value) {
            addCriterion("updatedBy <=", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyLike(String value) {
            addCriterion("updatedBy like", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyNotLike(String value) {
            addCriterion("updatedBy not like", value, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyIn(List<String> values) {
            addCriterion("updatedBy in", values, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyNotIn(List<String> values) {
            addCriterion("updatedBy not in", values, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyBetween(String value1, String value2) {
            addCriterion("updatedBy between", value1, value2, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedbyNotBetween(String value1, String value2) {
            addCriterion("updatedBy not between", value1, value2, "updatedby");
            return (Criteria) this;
        }

        public Criteria andUpdatedonIsNull() {
            addCriterion("updatedOn is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedonIsNotNull() {
            addCriterion("updatedOn is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedonEqualTo(Date value) {
            addCriterion("updatedOn =", value, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonNotEqualTo(Date value) {
            addCriterion("updatedOn <>", value, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonGreaterThan(Date value) {
            addCriterion("updatedOn >", value, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonGreaterThanOrEqualTo(Date value) {
            addCriterion("updatedOn >=", value, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonLessThan(Date value) {
            addCriterion("updatedOn <", value, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonLessThanOrEqualTo(Date value) {
            addCriterion("updatedOn <=", value, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonIn(List<Date> values) {
            addCriterion("updatedOn in", values, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonNotIn(List<Date> values) {
            addCriterion("updatedOn not in", values, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonBetween(Date value1, Date value2) {
            addCriterion("updatedOn between", value1, value2, "updatedon");
            return (Criteria) this;
        }

        public Criteria andUpdatedonNotBetween(Date value1, Date value2) {
            addCriterion("updatedOn not between", value1, value2, "updatedon");
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