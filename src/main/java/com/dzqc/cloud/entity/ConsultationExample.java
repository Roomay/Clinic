package com.dzqc.cloud.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConsultationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsultationExample() {
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

        public Criteria andConsultationIdIsNull() {
            addCriterion("consultation_id is null");
            return (Criteria) this;
        }

        public Criteria andConsultationIdIsNotNull() {
            addCriterion("consultation_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsultationIdEqualTo(Integer value) {
            addCriterion("consultation_id =", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdNotEqualTo(Integer value) {
            addCriterion("consultation_id <>", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdGreaterThan(Integer value) {
            addCriterion("consultation_id >", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("consultation_id >=", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdLessThan(Integer value) {
            addCriterion("consultation_id <", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdLessThanOrEqualTo(Integer value) {
            addCriterion("consultation_id <=", value, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdIn(List<Integer> values) {
            addCriterion("consultation_id in", values, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdNotIn(List<Integer> values) {
            addCriterion("consultation_id not in", values, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdBetween(Integer value1, Integer value2) {
            addCriterion("consultation_id between", value1, value2, "consultationId");
            return (Criteria) this;
        }

        public Criteria andConsultationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("consultation_id not between", value1, value2, "consultationId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNull() {
            addCriterion("doctor_id is null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIsNotNull() {
            addCriterion("doctor_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorIdEqualTo(Integer value) {
            addCriterion("doctor_id =", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotEqualTo(Integer value) {
            addCriterion("doctor_id <>", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThan(Integer value) {
            addCriterion("doctor_id >", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctor_id >=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThan(Integer value) {
            addCriterion("doctor_id <", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdLessThanOrEqualTo(Integer value) {
            addCriterion("doctor_id <=", value, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdIn(List<Integer> values) {
            addCriterion("doctor_id in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotIn(List<Integer> values) {
            addCriterion("doctor_id not in", values, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doctor_id not between", value1, value2, "doctorId");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNull() {
            addCriterion("doctor_name is null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIsNotNull() {
            addCriterion("doctor_name is not null");
            return (Criteria) this;
        }

        public Criteria andDoctorNameEqualTo(String value) {
            addCriterion("doctor_name =", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotEqualTo(String value) {
            addCriterion("doctor_name <>", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThan(String value) {
            addCriterion("doctor_name >", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
            addCriterion("doctor_name >=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThan(String value) {
            addCriterion("doctor_name <", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLessThanOrEqualTo(String value) {
            addCriterion("doctor_name <=", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameLike(String value) {
            addCriterion("doctor_name like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotLike(String value) {
            addCriterion("doctor_name not like", value, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameIn(List<String> values) {
            addCriterion("doctor_name in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotIn(List<String> values) {
            addCriterion("doctor_name not in", values, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameBetween(String value1, String value2) {
            addCriterion("doctor_name between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDoctorNameNotBetween(String value1, String value2) {
            addCriterion("doctor_name not between", value1, value2, "doctorName");
            return (Criteria) this;
        }

        public Criteria andDaySlotIsNull() {
            addCriterion("day_slot is null");
            return (Criteria) this;
        }

        public Criteria andDaySlotIsNotNull() {
            addCriterion("day_slot is not null");
            return (Criteria) this;
        }

        public Criteria andDaySlotEqualTo(Integer value) {
            addCriterion("day_slot =", value, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotNotEqualTo(Integer value) {
            addCriterion("day_slot <>", value, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotGreaterThan(Integer value) {
            addCriterion("day_slot >", value, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_slot >=", value, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotLessThan(Integer value) {
            addCriterion("day_slot <", value, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotLessThanOrEqualTo(Integer value) {
            addCriterion("day_slot <=", value, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotIn(List<Integer> values) {
            addCriterion("day_slot in", values, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotNotIn(List<Integer> values) {
            addCriterion("day_slot not in", values, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotBetween(Integer value1, Integer value2) {
            addCriterion("day_slot between", value1, value2, "daySlot");
            return (Criteria) this;
        }

        public Criteria andDaySlotNotBetween(Integer value1, Integer value2) {
            addCriterion("day_slot not between", value1, value2, "daySlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotIsNull() {
            addCriterion("time_slot is null");
            return (Criteria) this;
        }

        public Criteria andTimeSlotIsNotNull() {
            addCriterion("time_slot is not null");
            return (Criteria) this;
        }

        public Criteria andTimeSlotEqualTo(Integer value) {
            addCriterion("time_slot =", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotNotEqualTo(Integer value) {
            addCriterion("time_slot <>", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotGreaterThan(Integer value) {
            addCriterion("time_slot >", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_slot >=", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotLessThan(Integer value) {
            addCriterion("time_slot <", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotLessThanOrEqualTo(Integer value) {
            addCriterion("time_slot <=", value, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotIn(List<Integer> values) {
            addCriterion("time_slot in", values, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotNotIn(List<Integer> values) {
            addCriterion("time_slot not in", values, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotBetween(Integer value1, Integer value2) {
            addCriterion("time_slot between", value1, value2, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andTimeSlotNotBetween(Integer value1, Integer value2) {
            addCriterion("time_slot not between", value1, value2, "timeSlot");
            return (Criteria) this;
        }

        public Criteria andAvailStatusIsNull() {
            addCriterion("avail_status is null");
            return (Criteria) this;
        }

        public Criteria andAvailStatusIsNotNull() {
            addCriterion("avail_status is not null");
            return (Criteria) this;
        }

        public Criteria andAvailStatusEqualTo(Integer value) {
            addCriterion("avail_status =", value, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusNotEqualTo(Integer value) {
            addCriterion("avail_status <>", value, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusGreaterThan(Integer value) {
            addCriterion("avail_status >", value, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("avail_status >=", value, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusLessThan(Integer value) {
            addCriterion("avail_status <", value, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusLessThanOrEqualTo(Integer value) {
            addCriterion("avail_status <=", value, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusIn(List<Integer> values) {
            addCriterion("avail_status in", values, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusNotIn(List<Integer> values) {
            addCriterion("avail_status not in", values, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusBetween(Integer value1, Integer value2) {
            addCriterion("avail_status between", value1, value2, "availStatus");
            return (Criteria) this;
        }

        public Criteria andAvailStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("avail_status not between", value1, value2, "availStatus");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andChargeIsNull() {
            addCriterion("charge is null");
            return (Criteria) this;
        }

        public Criteria andChargeIsNotNull() {
            addCriterion("charge is not null");
            return (Criteria) this;
        }

        public Criteria andChargeEqualTo(BigDecimal value) {
            addCriterion("charge =", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotEqualTo(BigDecimal value) {
            addCriterion("charge <>", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThan(BigDecimal value) {
            addCriterion("charge >", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("charge >=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThan(BigDecimal value) {
            addCriterion("charge <", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("charge <=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeIn(List<BigDecimal> values) {
            addCriterion("charge in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotIn(List<BigDecimal> values) {
            addCriterion("charge not in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charge between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charge not between", value1, value2, "charge");
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