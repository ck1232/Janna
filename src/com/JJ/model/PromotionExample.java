package com.JJ.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public PromotionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
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

        public Criteria andPromotionidIsNull() {
            addCriterion("promotionId is null");
            return (Criteria) this;
        }

        public Criteria andPromotionidIsNotNull() {
            addCriterion("promotionId is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionidEqualTo(Integer value) {
            addCriterion("promotionId =", value, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidNotEqualTo(Integer value) {
            addCriterion("promotionId <>", value, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidGreaterThan(Integer value) {
            addCriterion("promotionId >", value, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotionId >=", value, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidLessThan(Integer value) {
            addCriterion("promotionId <", value, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidLessThanOrEqualTo(Integer value) {
            addCriterion("promotionId <=", value, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidIn(List<Integer> values) {
            addCriterion("promotionId in", values, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidNotIn(List<Integer> values) {
            addCriterion("promotionId not in", values, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidBetween(Integer value1, Integer value2) {
            addCriterion("promotionId between", value1, value2, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionidNotBetween(Integer value1, Integer value2) {
            addCriterion("promotionId not between", value1, value2, "promotionid");
            return (Criteria) this;
        }

        public Criteria andPromotionnameIsNull() {
            addCriterion("promotionName is null");
            return (Criteria) this;
        }

        public Criteria andPromotionnameIsNotNull() {
            addCriterion("promotionName is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionnameEqualTo(String value) {
            addCriterion("promotionName =", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameNotEqualTo(String value) {
            addCriterion("promotionName <>", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameGreaterThan(String value) {
            addCriterion("promotionName >", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameGreaterThanOrEqualTo(String value) {
            addCriterion("promotionName >=", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameLessThan(String value) {
            addCriterion("promotionName <", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameLessThanOrEqualTo(String value) {
            addCriterion("promotionName <=", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameLike(String value) {
            addCriterion("promotionName like", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameNotLike(String value) {
            addCriterion("promotionName not like", value, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameIn(List<String> values) {
            addCriterion("promotionName in", values, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameNotIn(List<String> values) {
            addCriterion("promotionName not in", values, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameBetween(String value1, String value2) {
            addCriterion("promotionName between", value1, value2, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionnameNotBetween(String value1, String value2) {
            addCriterion("promotionName not between", value1, value2, "promotionname");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageIsNull() {
            addCriterion("promotionMessage is null");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageIsNotNull() {
            addCriterion("promotionMessage is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageEqualTo(String value) {
            addCriterion("promotionMessage =", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageNotEqualTo(String value) {
            addCriterion("promotionMessage <>", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageGreaterThan(String value) {
            addCriterion("promotionMessage >", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageGreaterThanOrEqualTo(String value) {
            addCriterion("promotionMessage >=", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageLessThan(String value) {
            addCriterion("promotionMessage <", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageLessThanOrEqualTo(String value) {
            addCriterion("promotionMessage <=", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageLike(String value) {
            addCriterion("promotionMessage like", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageNotLike(String value) {
            addCriterion("promotionMessage not like", value, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageIn(List<String> values) {
            addCriterion("promotionMessage in", values, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageNotIn(List<String> values) {
            addCriterion("promotionMessage not in", values, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageBetween(String value1, String value2) {
            addCriterion("promotionMessage between", value1, value2, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionmessageNotBetween(String value1, String value2) {
            addCriterion("promotionMessage not between", value1, value2, "promotionmessage");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateIsNull() {
            addCriterion("promotionStartDate is null");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateIsNotNull() {
            addCriterion("promotionStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateEqualTo(Date value) {
            addCriterion("promotionStartDate =", value, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateNotEqualTo(Date value) {
            addCriterion("promotionStartDate <>", value, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateGreaterThan(Date value) {
            addCriterion("promotionStartDate >", value, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("promotionStartDate >=", value, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateLessThan(Date value) {
            addCriterion("promotionStartDate <", value, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateLessThanOrEqualTo(Date value) {
            addCriterion("promotionStartDate <=", value, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateIn(List<Date> values) {
            addCriterion("promotionStartDate in", values, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateNotIn(List<Date> values) {
            addCriterion("promotionStartDate not in", values, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateBetween(Date value1, Date value2) {
            addCriterion("promotionStartDate between", value1, value2, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionstartdateNotBetween(Date value1, Date value2) {
            addCriterion("promotionStartDate not between", value1, value2, "promotionstartdate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateIsNull() {
            addCriterion("promotionEndDate is null");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateIsNotNull() {
            addCriterion("promotionEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateEqualTo(Date value) {
            addCriterion("promotionEndDate =", value, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateNotEqualTo(Date value) {
            addCriterion("promotionEndDate <>", value, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateGreaterThan(Date value) {
            addCriterion("promotionEndDate >", value, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("promotionEndDate >=", value, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateLessThan(Date value) {
            addCriterion("promotionEndDate <", value, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateLessThanOrEqualTo(Date value) {
            addCriterion("promotionEndDate <=", value, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateIn(List<Date> values) {
            addCriterion("promotionEndDate in", values, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateNotIn(List<Date> values) {
            addCriterion("promotionEndDate not in", values, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateBetween(Date value1, Date value2) {
            addCriterion("promotionEndDate between", value1, value2, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andPromotionenddateNotBetween(Date value1, Date value2) {
            addCriterion("promotionEndDate not between", value1, value2, "promotionenddate");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNull() {
            addCriterion("isActive is null");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNotNull() {
            addCriterion("isActive is not null");
            return (Criteria) this;
        }

        public Criteria andIsactiveEqualTo(Boolean value) {
            addCriterion("isActive =", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotEqualTo(Boolean value) {
            addCriterion("isActive <>", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThan(Boolean value) {
            addCriterion("isActive >", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isActive >=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThan(Boolean value) {
            addCriterion("isActive <", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThanOrEqualTo(Boolean value) {
            addCriterion("isActive <=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveIn(List<Boolean> values) {
            addCriterion("isActive in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotIn(List<Boolean> values) {
            addCriterion("isActive not in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveBetween(Boolean value1, Boolean value2) {
            addCriterion("isActive between", value1, value2, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isActive not between", value1, value2, "isactive");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table promotion
     *
     * @mbggenerated do_not_delete_during_merge Sun Oct 30 22:47:29 SGT 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table promotion
     *
     * @mbggenerated Sun Oct 30 22:47:29 SGT 2016
     */
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