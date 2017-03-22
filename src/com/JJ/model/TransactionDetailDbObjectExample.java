package com.JJ.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDetailDbObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionDetailDbObjectExample() {
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

        public Criteria andTplReferenceIdIsNull() {
            addCriterion("tpl_reference_id is null");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdIsNotNull() {
            addCriterion("tpl_reference_id is not null");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdEqualTo(String value) {
            addCriterion("tpl_reference_id =", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdNotEqualTo(String value) {
            addCriterion("tpl_reference_id <>", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdGreaterThan(String value) {
            addCriterion("tpl_reference_id >", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdGreaterThanOrEqualTo(String value) {
            addCriterion("tpl_reference_id >=", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdLessThan(String value) {
            addCriterion("tpl_reference_id <", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdLessThanOrEqualTo(String value) {
            addCriterion("tpl_reference_id <=", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdLike(String value) {
            addCriterion("tpl_reference_id like", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdNotLike(String value) {
            addCriterion("tpl_reference_id not like", value, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdIn(List<String> values) {
            addCriterion("tpl_reference_id in", values, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdNotIn(List<String> values) {
            addCriterion("tpl_reference_id not in", values, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdBetween(String value1, String value2) {
            addCriterion("tpl_reference_id between", value1, value2, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andTplReferenceIdNotBetween(String value1, String value2) {
            addCriterion("tpl_reference_id not between", value1, value2, "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andGiftMessageIsNull() {
            addCriterion("gift_message is null");
            return (Criteria) this;
        }

        public Criteria andGiftMessageIsNotNull() {
            addCriterion("gift_message is not null");
            return (Criteria) this;
        }

        public Criteria andGiftMessageEqualTo(String value) {
            addCriterion("gift_message =", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageNotEqualTo(String value) {
            addCriterion("gift_message <>", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageGreaterThan(String value) {
            addCriterion("gift_message >", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageGreaterThanOrEqualTo(String value) {
            addCriterion("gift_message >=", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageLessThan(String value) {
            addCriterion("gift_message <", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageLessThanOrEqualTo(String value) {
            addCriterion("gift_message <=", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageLike(String value) {
            addCriterion("gift_message like", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageNotLike(String value) {
            addCriterion("gift_message not like", value, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageIn(List<String> values) {
            addCriterion("gift_message in", values, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageNotIn(List<String> values) {
            addCriterion("gift_message not in", values, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageBetween(String value1, String value2) {
            addCriterion("gift_message between", value1, value2, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftMessageNotBetween(String value1, String value2) {
            addCriterion("gift_message not between", value1, value2, "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptIsNull() {
            addCriterion("gift_receipt is null");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptIsNotNull() {
            addCriterion("gift_receipt is not null");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptEqualTo(String value) {
            addCriterion("gift_receipt =", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptNotEqualTo(String value) {
            addCriterion("gift_receipt <>", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptGreaterThan(String value) {
            addCriterion("gift_receipt >", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptGreaterThanOrEqualTo(String value) {
            addCriterion("gift_receipt >=", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptLessThan(String value) {
            addCriterion("gift_receipt <", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptLessThanOrEqualTo(String value) {
            addCriterion("gift_receipt <=", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptLike(String value) {
            addCriterion("gift_receipt like", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptNotLike(String value) {
            addCriterion("gift_receipt not like", value, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptIn(List<String> values) {
            addCriterion("gift_receipt in", values, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptNotIn(List<String> values) {
            addCriterion("gift_receipt not in", values, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptBetween(String value1, String value2) {
            addCriterion("gift_receipt between", value1, value2, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptNotBetween(String value1, String value2) {
            addCriterion("gift_receipt not between", value1, value2, "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameIsNull() {
            addCriterion("gift_wrap_name is null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameIsNotNull() {
            addCriterion("gift_wrap_name is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameEqualTo(String value) {
            addCriterion("gift_wrap_name =", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameNotEqualTo(String value) {
            addCriterion("gift_wrap_name <>", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameGreaterThan(String value) {
            addCriterion("gift_wrap_name >", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameGreaterThanOrEqualTo(String value) {
            addCriterion("gift_wrap_name >=", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameLessThan(String value) {
            addCriterion("gift_wrap_name <", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameLessThanOrEqualTo(String value) {
            addCriterion("gift_wrap_name <=", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameLike(String value) {
            addCriterion("gift_wrap_name like", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameNotLike(String value) {
            addCriterion("gift_wrap_name not like", value, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameIn(List<String> values) {
            addCriterion("gift_wrap_name in", values, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameNotIn(List<String> values) {
            addCriterion("gift_wrap_name not in", values, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameBetween(String value1, String value2) {
            addCriterion("gift_wrap_name between", value1, value2, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameNotBetween(String value1, String value2) {
            addCriterion("gift_wrap_name not between", value1, value2, "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInIsNull() {
            addCriterion("buyer_email_opt_in is null");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInIsNotNull() {
            addCriterion("buyer_email_opt_in is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInEqualTo(String value) {
            addCriterion("buyer_email_opt_in =", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInNotEqualTo(String value) {
            addCriterion("buyer_email_opt_in <>", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInGreaterThan(String value) {
            addCriterion("buyer_email_opt_in >", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_email_opt_in >=", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInLessThan(String value) {
            addCriterion("buyer_email_opt_in <", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInLessThanOrEqualTo(String value) {
            addCriterion("buyer_email_opt_in <=", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInLike(String value) {
            addCriterion("buyer_email_opt_in like", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInNotLike(String value) {
            addCriterion("buyer_email_opt_in not like", value, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInIn(List<String> values) {
            addCriterion("buyer_email_opt_in in", values, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInNotIn(List<String> values) {
            addCriterion("buyer_email_opt_in not in", values, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInBetween(String value1, String value2) {
            addCriterion("buyer_email_opt_in between", value1, value2, "buyerEmailOptIn");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInNotBetween(String value1, String value2) {
            addCriterion("buyer_email_opt_in not between", value1, value2, "buyerEmailOptIn");
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

        public Criteria andTplReferenceIdLikeInsensitive(String value) {
            addCriterion("upper(tpl_reference_id) like", value.toUpperCase(), "tplReferenceId");
            return (Criteria) this;
        }

        public Criteria andGiftMessageLikeInsensitive(String value) {
            addCriterion("upper(gift_message) like", value.toUpperCase(), "giftMessage");
            return (Criteria) this;
        }

        public Criteria andGiftReceiptLikeInsensitive(String value) {
            addCriterion("upper(gift_receipt) like", value.toUpperCase(), "giftReceipt");
            return (Criteria) this;
        }

        public Criteria andGiftWrapNameLikeInsensitive(String value) {
            addCriterion("upper(gift_wrap_name) like", value.toUpperCase(), "giftWrapName");
            return (Criteria) this;
        }

        public Criteria andBuyerEmailOptInLikeInsensitive(String value) {
            addCriterion("upper(buyer_email_opt_in) like", value.toUpperCase(), "buyerEmailOptIn");
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