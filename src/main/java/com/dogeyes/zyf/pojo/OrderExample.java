package com.dogeyes.zyf.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andNewMoneyIsNull() {
            addCriterion("new_money is null");
            return (Criteria) this;
        }

        public Criteria andNewMoneyIsNotNull() {
            addCriterion("new_money is not null");
            return (Criteria) this;
        }

        public Criteria andNewMoneyEqualTo(BigDecimal value) {
            addCriterion("new_money =", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyNotEqualTo(BigDecimal value) {
            addCriterion("new_money <>", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyGreaterThan(BigDecimal value) {
            addCriterion("new_money >", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("new_money >=", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyLessThan(BigDecimal value) {
            addCriterion("new_money <", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("new_money <=", value, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyIn(List<BigDecimal> values) {
            addCriterion("new_money in", values, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyNotIn(List<BigDecimal> values) {
            addCriterion("new_money not in", values, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_money between", value1, value2, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNewMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("new_money not between", value1, value2, "newMoney");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andOldMoneyIsNull() {
            addCriterion("old_money is null");
            return (Criteria) this;
        }

        public Criteria andOldMoneyIsNotNull() {
            addCriterion("old_money is not null");
            return (Criteria) this;
        }

        public Criteria andOldMoneyEqualTo(BigDecimal value) {
            addCriterion("old_money =", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyNotEqualTo(BigDecimal value) {
            addCriterion("old_money <>", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyGreaterThan(BigDecimal value) {
            addCriterion("old_money >", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("old_money >=", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyLessThan(BigDecimal value) {
            addCriterion("old_money <", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("old_money <=", value, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyIn(List<BigDecimal> values) {
            addCriterion("old_money in", values, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyNotIn(List<BigDecimal> values) {
            addCriterion("old_money not in", values, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("old_money between", value1, value2, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andOldMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("old_money not between", value1, value2, "oldMoney");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andDbStatusIsNull() {
            addCriterion("db_status is null");
            return (Criteria) this;
        }

        public Criteria andDbStatusIsNotNull() {
            addCriterion("db_status is not null");
            return (Criteria) this;
        }

        public Criteria andDbStatusEqualTo(Integer value) {
            addCriterion("db_status =", value, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusNotEqualTo(Integer value) {
            addCriterion("db_status <>", value, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusGreaterThan(Integer value) {
            addCriterion("db_status >", value, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("db_status >=", value, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusLessThan(Integer value) {
            addCriterion("db_status <", value, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusLessThanOrEqualTo(Integer value) {
            addCriterion("db_status <=", value, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusIn(List<Integer> values) {
            addCriterion("db_status in", values, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusNotIn(List<Integer> values) {
            addCriterion("db_status not in", values, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusBetween(Integer value1, Integer value2) {
            addCriterion("db_status between", value1, value2, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andDbStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("db_status not between", value1, value2, "dbStatus");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Long> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdIsNull() {
            addCriterion("cinema_hall_session_id is null");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdIsNotNull() {
            addCriterion("cinema_hall_session_id is not null");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdEqualTo(Long value) {
            addCriterion("cinema_hall_session_id =", value, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdNotEqualTo(Long value) {
            addCriterion("cinema_hall_session_id <>", value, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdGreaterThan(Long value) {
            addCriterion("cinema_hall_session_id >", value, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cinema_hall_session_id >=", value, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdLessThan(Long value) {
            addCriterion("cinema_hall_session_id <", value, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdLessThanOrEqualTo(Long value) {
            addCriterion("cinema_hall_session_id <=", value, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdIn(List<Long> values) {
            addCriterion("cinema_hall_session_id in", values, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdNotIn(List<Long> values) {
            addCriterion("cinema_hall_session_id not in", values, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdBetween(Long value1, Long value2) {
            addCriterion("cinema_hall_session_id between", value1, value2, "cinemaHallSessionId");
            return (Criteria) this;
        }

        public Criteria andCinemaHallSessionIdNotBetween(Long value1, Long value2) {
            addCriterion("cinema_hall_session_id not between", value1, value2, "cinemaHallSessionId");
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