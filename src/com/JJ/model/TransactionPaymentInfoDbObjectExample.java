package com.JJ.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionPaymentInfoDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionPaymentInfoDbObjectExample() {
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

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("transaction_id like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("transaction_id not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdIsNull() {
            addCriterion("ebay_transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdIsNotNull() {
            addCriterion("ebay_transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdEqualTo(String value) {
            addCriterion("ebay_transaction_id =", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdNotEqualTo(String value) {
            addCriterion("ebay_transaction_id <>", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdGreaterThan(String value) {
            addCriterion("ebay_transaction_id >", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("ebay_transaction_id >=", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdLessThan(String value) {
            addCriterion("ebay_transaction_id <", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("ebay_transaction_id <=", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdLike(String value) {
            addCriterion("ebay_transaction_id like", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdNotLike(String value) {
            addCriterion("ebay_transaction_id not like", value, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdIn(List<String> values) {
            addCriterion("ebay_transaction_id in", values, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdNotIn(List<String> values) {
            addCriterion("ebay_transaction_id not in", values, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdBetween(String value1, String value2) {
            addCriterion("ebay_transaction_id between", value1, value2, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdNotBetween(String value1, String value2) {
            addCriterion("ebay_transaction_id not between", value1, value2, "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdIsNull() {
            addCriterion("parent_transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdIsNotNull() {
            addCriterion("parent_transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdEqualTo(String value) {
            addCriterion("parent_transaction_id =", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdNotEqualTo(String value) {
            addCriterion("parent_transaction_id <>", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdGreaterThan(String value) {
            addCriterion("parent_transaction_id >", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_transaction_id >=", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdLessThan(String value) {
            addCriterion("parent_transaction_id <", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("parent_transaction_id <=", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdLike(String value) {
            addCriterion("parent_transaction_id like", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdNotLike(String value) {
            addCriterion("parent_transaction_id not like", value, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdIn(List<String> values) {
            addCriterion("parent_transaction_id in", values, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdNotIn(List<String> values) {
            addCriterion("parent_transaction_id not in", values, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdBetween(String value1, String value2) {
            addCriterion("parent_transaction_id between", value1, value2, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdNotBetween(String value1, String value2) {
            addCriterion("parent_transaction_id not between", value1, value2, "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIsNull() {
            addCriterion("receipt_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIsNotNull() {
            addCriterion("receipt_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptIdEqualTo(String value) {
            addCriterion("receipt_id =", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotEqualTo(String value) {
            addCriterion("receipt_id <>", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdGreaterThan(String value) {
            addCriterion("receipt_id >", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdGreaterThanOrEqualTo(String value) {
            addCriterion("receipt_id >=", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLessThan(String value) {
            addCriterion("receipt_id <", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLessThanOrEqualTo(String value) {
            addCriterion("receipt_id <=", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLike(String value) {
            addCriterion("receipt_id like", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotLike(String value) {
            addCriterion("receipt_id not like", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIn(List<String> values) {
            addCriterion("receipt_id in", values, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotIn(List<String> values) {
            addCriterion("receipt_id not in", values, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdBetween(String value1, String value2) {
            addCriterion("receipt_id between", value1, value2, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotBetween(String value1, String value2) {
            addCriterion("receipt_id not between", value1, value2, "receiptId");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIsNull() {
            addCriterion("transaction_type is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIsNotNull() {
            addCriterion("transaction_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeEqualTo(String value) {
            addCriterion("transaction_type =", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotEqualTo(String value) {
            addCriterion("transaction_type <>", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThan(String value) {
            addCriterion("transaction_type >", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_type >=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThan(String value) {
            addCriterion("transaction_type <", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLessThanOrEqualTo(String value) {
            addCriterion("transaction_type <=", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLike(String value) {
            addCriterion("transaction_type like", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotLike(String value) {
            addCriterion("transaction_type not like", value, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeIn(List<String> values) {
            addCriterion("transaction_type in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotIn(List<String> values) {
            addCriterion("transaction_type not in", values, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeBetween(String value1, String value2) {
            addCriterion("transaction_type between", value1, value2, "transactionType");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeNotBetween(String value1, String value2) {
            addCriterion("transaction_type not between", value1, value2, "transactionType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(String value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(String value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(String value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(String value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(String value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLike(String value) {
            addCriterion("payment_type like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotLike(String value) {
            addCriterion("payment_type not like", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<String> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<String> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(String value1, String value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(String value1, String value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeIsNull() {
            addCriterion("refund_source_code_type is null");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeIsNotNull() {
            addCriterion("refund_source_code_type is not null");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeEqualTo(String value) {
            addCriterion("refund_source_code_type =", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeNotEqualTo(String value) {
            addCriterion("refund_source_code_type <>", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeGreaterThan(String value) {
            addCriterion("refund_source_code_type >", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("refund_source_code_type >=", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeLessThan(String value) {
            addCriterion("refund_source_code_type <", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeLessThanOrEqualTo(String value) {
            addCriterion("refund_source_code_type <=", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeLike(String value) {
            addCriterion("refund_source_code_type like", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeNotLike(String value) {
            addCriterion("refund_source_code_type not like", value, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeIn(List<String> values) {
            addCriterion("refund_source_code_type in", values, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeNotIn(List<String> values) {
            addCriterion("refund_source_code_type not in", values, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeBetween(String value1, String value2) {
            addCriterion("refund_source_code_type between", value1, value2, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeNotBetween(String value1, String value2) {
            addCriterion("refund_source_code_type not between", value1, value2, "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateIsNull() {
            addCriterion("expectede_check_clear_date is null");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateIsNotNull() {
            addCriterion("expectede_check_clear_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateEqualTo(String value) {
            addCriterion("expectede_check_clear_date =", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateNotEqualTo(String value) {
            addCriterion("expectede_check_clear_date <>", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateGreaterThan(String value) {
            addCriterion("expectede_check_clear_date >", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateGreaterThanOrEqualTo(String value) {
            addCriterion("expectede_check_clear_date >=", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateLessThan(String value) {
            addCriterion("expectede_check_clear_date <", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateLessThanOrEqualTo(String value) {
            addCriterion("expectede_check_clear_date <=", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateLike(String value) {
            addCriterion("expectede_check_clear_date like", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateNotLike(String value) {
            addCriterion("expectede_check_clear_date not like", value, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateIn(List<String> values) {
            addCriterion("expectede_check_clear_date in", values, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateNotIn(List<String> values) {
            addCriterion("expectede_check_clear_date not in", values, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateBetween(String value1, String value2) {
            addCriterion("expectede_check_clear_date between", value1, value2, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateNotBetween(String value1, String value2) {
            addCriterion("expectede_check_clear_date not between", value1, value2, "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateIsNull() {
            addCriterion("payment_date is null");
            return (Criteria) this;
        }

        public Criteria andPaymentDateIsNotNull() {
            addCriterion("payment_date is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentDateEqualTo(String value) {
            addCriterion("payment_date =", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateNotEqualTo(String value) {
            addCriterion("payment_date <>", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateGreaterThan(String value) {
            addCriterion("payment_date >", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateGreaterThanOrEqualTo(String value) {
            addCriterion("payment_date >=", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateLessThan(String value) {
            addCriterion("payment_date <", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateLessThanOrEqualTo(String value) {
            addCriterion("payment_date <=", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateLike(String value) {
            addCriterion("payment_date like", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateNotLike(String value) {
            addCriterion("payment_date not like", value, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateIn(List<String> values) {
            addCriterion("payment_date in", values, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateNotIn(List<String> values) {
            addCriterion("payment_date not in", values, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateBetween(String value1, String value2) {
            addCriterion("payment_date between", value1, value2, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateNotBetween(String value1, String value2) {
            addCriterion("payment_date not between", value1, value2, "paymentDate");
            return (Criteria) this;
        }

        public Criteria andGrossAmtIsNull() {
            addCriterion("gross_amt is null");
            return (Criteria) this;
        }

        public Criteria andGrossAmtIsNotNull() {
            addCriterion("gross_amt is not null");
            return (Criteria) this;
        }

        public Criteria andGrossAmtEqualTo(BigDecimal value) {
            addCriterion("gross_amt =", value, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtNotEqualTo(BigDecimal value) {
            addCriterion("gross_amt <>", value, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtGreaterThan(BigDecimal value) {
            addCriterion("gross_amt >", value, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_amt >=", value, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtLessThan(BigDecimal value) {
            addCriterion("gross_amt <", value, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_amt <=", value, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtIn(List<BigDecimal> values) {
            addCriterion("gross_amt in", values, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtNotIn(List<BigDecimal> values) {
            addCriterion("gross_amt not in", values, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_amt between", value1, value2, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andGrossAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_amt not between", value1, value2, "grossAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtIsNull() {
            addCriterion("fee_amt is null");
            return (Criteria) this;
        }

        public Criteria andFeeAmtIsNotNull() {
            addCriterion("fee_amt is not null");
            return (Criteria) this;
        }

        public Criteria andFeeAmtEqualTo(BigDecimal value) {
            addCriterion("fee_amt =", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtNotEqualTo(BigDecimal value) {
            addCriterion("fee_amt <>", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtGreaterThan(BigDecimal value) {
            addCriterion("fee_amt >", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_amt >=", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtLessThan(BigDecimal value) {
            addCriterion("fee_amt <", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_amt <=", value, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtIn(List<BigDecimal> values) {
            addCriterion("fee_amt in", values, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtNotIn(List<BigDecimal> values) {
            addCriterion("fee_amt not in", values, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_amt between", value1, value2, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFeeAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_amt not between", value1, value2, "feeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtIsNull() {
            addCriterion("financing_fee_amt is null");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtIsNotNull() {
            addCriterion("financing_fee_amt is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtEqualTo(BigDecimal value) {
            addCriterion("financing_fee_amt =", value, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtNotEqualTo(BigDecimal value) {
            addCriterion("financing_fee_amt <>", value, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtGreaterThan(BigDecimal value) {
            addCriterion("financing_fee_amt >", value, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_fee_amt >=", value, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtLessThan(BigDecimal value) {
            addCriterion("financing_fee_amt <", value, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_fee_amt <=", value, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtIn(List<BigDecimal> values) {
            addCriterion("financing_fee_amt in", values, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtNotIn(List<BigDecimal> values) {
            addCriterion("financing_fee_amt not in", values, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_fee_amt between", value1, value2, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingFeeAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_fee_amt not between", value1, value2, "financingFeeAmt");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostIsNull() {
            addCriterion("financing_total_cost is null");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostIsNotNull() {
            addCriterion("financing_total_cost is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostEqualTo(BigDecimal value) {
            addCriterion("financing_total_cost =", value, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostNotEqualTo(BigDecimal value) {
            addCriterion("financing_total_cost <>", value, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostGreaterThan(BigDecimal value) {
            addCriterion("financing_total_cost >", value, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_total_cost >=", value, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostLessThan(BigDecimal value) {
            addCriterion("financing_total_cost <", value, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_total_cost <=", value, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostIn(List<BigDecimal> values) {
            addCriterion("financing_total_cost in", values, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostNotIn(List<BigDecimal> values) {
            addCriterion("financing_total_cost not in", values, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_total_cost between", value1, value2, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingTotalCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_total_cost not between", value1, value2, "financingTotalCost");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentIsNull() {
            addCriterion("financing_monthly_payment is null");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentIsNotNull() {
            addCriterion("financing_monthly_payment is not null");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentEqualTo(BigDecimal value) {
            addCriterion("financing_monthly_payment =", value, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentNotEqualTo(BigDecimal value) {
            addCriterion("financing_monthly_payment <>", value, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentGreaterThan(BigDecimal value) {
            addCriterion("financing_monthly_payment >", value, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_monthly_payment >=", value, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentLessThan(BigDecimal value) {
            addCriterion("financing_monthly_payment <", value, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("financing_monthly_payment <=", value, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentIn(List<BigDecimal> values) {
            addCriterion("financing_monthly_payment in", values, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentNotIn(List<BigDecimal> values) {
            addCriterion("financing_monthly_payment not in", values, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_monthly_payment between", value1, value2, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andFinancingMonthlyPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("financing_monthly_payment not between", value1, value2, "financingMonthlyPayment");
            return (Criteria) this;
        }

        public Criteria andIsFinancingIsNull() {
            addCriterion("is_financing is null");
            return (Criteria) this;
        }

        public Criteria andIsFinancingIsNotNull() {
            addCriterion("is_financing is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinancingEqualTo(String value) {
            addCriterion("is_financing =", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingNotEqualTo(String value) {
            addCriterion("is_financing <>", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingGreaterThan(String value) {
            addCriterion("is_financing >", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingGreaterThanOrEqualTo(String value) {
            addCriterion("is_financing >=", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingLessThan(String value) {
            addCriterion("is_financing <", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingLessThanOrEqualTo(String value) {
            addCriterion("is_financing <=", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingLike(String value) {
            addCriterion("is_financing like", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingNotLike(String value) {
            addCriterion("is_financing not like", value, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingIn(List<String> values) {
            addCriterion("is_financing in", values, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingNotIn(List<String> values) {
            addCriterion("is_financing not in", values, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingBetween(String value1, String value2) {
            addCriterion("is_financing between", value1, value2, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andIsFinancingNotBetween(String value1, String value2) {
            addCriterion("is_financing not between", value1, value2, "isFinancing");
            return (Criteria) this;
        }

        public Criteria andSettleAmtIsNull() {
            addCriterion("settle_amt is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmtIsNotNull() {
            addCriterion("settle_amt is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmtEqualTo(BigDecimal value) {
            addCriterion("settle_amt =", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtNotEqualTo(BigDecimal value) {
            addCriterion("settle_amt <>", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtGreaterThan(BigDecimal value) {
            addCriterion("settle_amt >", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amt >=", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtLessThan(BigDecimal value) {
            addCriterion("settle_amt <", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amt <=", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtIn(List<BigDecimal> values) {
            addCriterion("settle_amt in", values, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtNotIn(List<BigDecimal> values) {
            addCriterion("settle_amt not in", values, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amt between", value1, value2, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amt not between", value1, value2, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIsNull() {
            addCriterion("tax_amt is null");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIsNotNull() {
            addCriterion("tax_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTaxAmtEqualTo(BigDecimal value) {
            addCriterion("tax_amt =", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotEqualTo(BigDecimal value) {
            addCriterion("tax_amt <>", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtGreaterThan(BigDecimal value) {
            addCriterion("tax_amt >", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_amt >=", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtLessThan(BigDecimal value) {
            addCriterion("tax_amt <", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_amt <=", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIn(List<BigDecimal> values) {
            addCriterion("tax_amt in", values, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotIn(List<BigDecimal> values) {
            addCriterion("tax_amt not in", values, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_amt between", value1, value2, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_amt not between", value1, value2, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNull() {
            addCriterion("exchange_rate is null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNotNull() {
            addCriterion("exchange_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateEqualTo(String value) {
            addCriterion("exchange_rate =", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotEqualTo(String value) {
            addCriterion("exchange_rate <>", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThan(String value) {
            addCriterion("exchange_rate >", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_rate >=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThan(String value) {
            addCriterion("exchange_rate <", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThanOrEqualTo(String value) {
            addCriterion("exchange_rate <=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLike(String value) {
            addCriterion("exchange_rate like", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotLike(String value) {
            addCriterion("exchange_rate not like", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIn(List<String> values) {
            addCriterion("exchange_rate in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotIn(List<String> values) {
            addCriterion("exchange_rate not in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateBetween(String value1, String value2) {
            addCriterion("exchange_rate between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotBetween(String value1, String value2) {
            addCriterion("exchange_rate not between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("payment_status is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("payment_status is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(String value) {
            addCriterion("payment_status =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(String value) {
            addCriterion("payment_status <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(String value) {
            addCriterion("payment_status >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("payment_status >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(String value) {
            addCriterion("payment_status <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(String value) {
            addCriterion("payment_status <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLike(String value) {
            addCriterion("payment_status like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotLike(String value) {
            addCriterion("payment_status not like", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<String> values) {
            addCriterion("payment_status in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<String> values) {
            addCriterion("payment_status not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(String value1, String value2) {
            addCriterion("payment_status between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(String value1, String value2) {
            addCriterion("payment_status not between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNull() {
            addCriterion("invoice_id is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIsNotNull() {
            addCriterion("invoice_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdEqualTo(String value) {
            addCriterion("invoice_id =", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotEqualTo(String value) {
            addCriterion("invoice_id <>", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThan(String value) {
            addCriterion("invoice_id >", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_id >=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThan(String value) {
            addCriterion("invoice_id <", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLessThanOrEqualTo(String value) {
            addCriterion("invoice_id <=", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLike(String value) {
            addCriterion("invoice_id like", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotLike(String value) {
            addCriterion("invoice_id not like", value, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdIn(List<String> values) {
            addCriterion("invoice_id in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotIn(List<String> values) {
            addCriterion("invoice_id not in", values, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdBetween(String value1, String value2) {
            addCriterion("invoice_id between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdNotBetween(String value1, String value2) {
            addCriterion("invoice_id not between", value1, value2, "invoiceId");
            return (Criteria) this;
        }

        public Criteria andCustomIsNull() {
            addCriterion("custom is null");
            return (Criteria) this;
        }

        public Criteria andCustomIsNotNull() {
            addCriterion("custom is not null");
            return (Criteria) this;
        }

        public Criteria andCustomEqualTo(String value) {
            addCriterion("custom =", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomNotEqualTo(String value) {
            addCriterion("custom <>", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomGreaterThan(String value) {
            addCriterion("custom >", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomGreaterThanOrEqualTo(String value) {
            addCriterion("custom >=", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomLessThan(String value) {
            addCriterion("custom <", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomLessThanOrEqualTo(String value) {
            addCriterion("custom <=", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomLike(String value) {
            addCriterion("custom like", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomNotLike(String value) {
            addCriterion("custom not like", value, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomIn(List<String> values) {
            addCriterion("custom in", values, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomNotIn(List<String> values) {
            addCriterion("custom not in", values, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomBetween(String value1, String value2) {
            addCriterion("custom between", value1, value2, "custom");
            return (Criteria) this;
        }

        public Criteria andCustomNotBetween(String value1, String value2) {
            addCriterion("custom not between", value1, value2, "custom");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andSalesTaxIsNull() {
            addCriterion("sales_tax is null");
            return (Criteria) this;
        }

        public Criteria andSalesTaxIsNotNull() {
            addCriterion("sales_tax is not null");
            return (Criteria) this;
        }

        public Criteria andSalesTaxEqualTo(String value) {
            addCriterion("sales_tax =", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxNotEqualTo(String value) {
            addCriterion("sales_tax <>", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxGreaterThan(String value) {
            addCriterion("sales_tax >", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxGreaterThanOrEqualTo(String value) {
            addCriterion("sales_tax >=", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxLessThan(String value) {
            addCriterion("sales_tax <", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxLessThanOrEqualTo(String value) {
            addCriterion("sales_tax <=", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxLike(String value) {
            addCriterion("sales_tax like", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxNotLike(String value) {
            addCriterion("sales_tax not like", value, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxIn(List<String> values) {
            addCriterion("sales_tax in", values, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxNotIn(List<String> values) {
            addCriterion("sales_tax not in", values, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxBetween(String value1, String value2) {
            addCriterion("sales_tax between", value1, value2, "salesTax");
            return (Criteria) this;
        }

        public Criteria andSalesTaxNotBetween(String value1, String value2) {
            addCriterion("sales_tax not between", value1, value2, "salesTax");
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

        public Criteria andTransactionIdLikeInsensitive(String value) {
            addCriterion("upper(transaction_id) like", value.toUpperCase(), "transactionId");
            return (Criteria) this;
        }

        public Criteria andEbayTransactionIdLikeInsensitive(String value) {
            addCriterion("upper(ebay_transaction_id) like", value.toUpperCase(), "ebayTransactionId");
            return (Criteria) this;
        }

        public Criteria andParentTransactionIdLikeInsensitive(String value) {
            addCriterion("upper(parent_transaction_id) like", value.toUpperCase(), "parentTransactionId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLikeInsensitive(String value) {
            addCriterion("upper(receipt_id) like", value.toUpperCase(), "receiptId");
            return (Criteria) this;
        }

        public Criteria andTransactionTypeLikeInsensitive(String value) {
            addCriterion("upper(transaction_type) like", value.toUpperCase(), "transactionType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLikeInsensitive(String value) {
            addCriterion("upper(payment_type) like", value.toUpperCase(), "paymentType");
            return (Criteria) this;
        }

        public Criteria andRefundSourceCodeTypeLikeInsensitive(String value) {
            addCriterion("upper(refund_source_code_type) like", value.toUpperCase(), "refundSourceCodeType");
            return (Criteria) this;
        }

        public Criteria andExpectedeCheckClearDateLikeInsensitive(String value) {
            addCriterion("upper(expectede_check_clear_date) like", value.toUpperCase(), "expectedeCheckClearDate");
            return (Criteria) this;
        }

        public Criteria andPaymentDateLikeInsensitive(String value) {
            addCriterion("upper(payment_date) like", value.toUpperCase(), "paymentDate");
            return (Criteria) this;
        }

        public Criteria andIsFinancingLikeInsensitive(String value) {
            addCriterion("upper(is_financing) like", value.toUpperCase(), "isFinancing");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLikeInsensitive(String value) {
            addCriterion("upper(exchange_rate) like", value.toUpperCase(), "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLikeInsensitive(String value) {
            addCriterion("upper(payment_status) like", value.toUpperCase(), "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andInvoiceIdLikeInsensitive(String value) {
            addCriterion("upper(invoice_id) like", value.toUpperCase(), "invoiceId");
            return (Criteria) this;
        }

        public Criteria andCustomLikeInsensitive(String value) {
            addCriterion("upper(custom) like", value.toUpperCase(), "custom");
            return (Criteria) this;
        }

        public Criteria andMemoLikeInsensitive(String value) {
            addCriterion("upper(memo) like", value.toUpperCase(), "memo");
            return (Criteria) this;
        }

        public Criteria andSalesTaxLikeInsensitive(String value) {
            addCriterion("upper(sales_tax) like", value.toUpperCase(), "salesTax");
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