package com.webbansach.specifications;

import com.webbansach.entity.OrderEntity;
import com.webbansach.entity.OrderEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.data.jpa.domain.Specifications.where;

@Component
public class OrderSpecification {

    public static Specification<OrderEntity> hasId(long id) {
        if(id == 0){
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(OrderEntity_.ID), id);
    }

    public static Specification<OrderEntity> hasStatus(int status) {
        if(status == -1){
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(OrderEntity_.STATUS), status);
    }

    public static Specification<OrderEntity> hasMonth(int month) {
        return (root, query, cb) -> cb.equal(cb.function("MONTH", Integer.class, root.get(OrderEntity_.CREATED_DATE)), month);
    }

    public static Specification<OrderEntity> hasYear(int year) {
        return (root, query, cb) -> cb.equal(cb.function("YEAR", Integer.class, root.get(OrderEntity_.CREATED_DATE)), year);
    }

    public static Specification<OrderEntity> greaterThanDate(Date date) {
        return (root, query, cb) -> cb.greaterThan(root.<Date>get(OrderEntity_.CREATED_DATE), date);
    }

    public static Specification<OrderEntity> lessThanDate(Date date) {
        return (root, query, cb) -> cb.lessThan(root.<Date>get(OrderEntity_.CREATED_DATE), date);
    }

    public static Specification<OrderEntity> rangeDate(Date startDate, Date endDate) {
        if(startDate == null && endDate == null){
            return null;
        }
        if(startDate == null && endDate != null){
            return greaterThanDate(startDate);
        }
        if(endDate == null && startDate != null){
            return lessThanDate(endDate);
        }
        return (root, query, cb) -> cb.between(root.<Date>get(OrderEntity_.CREATED_DATE), startDate, endDate);
    }

    public static Specification<OrderEntity> optionDate(String optionDate) {
        LocalDate now = LocalDate.now();
        if (optionDate.equals("TODAY")) {
            return (root, query, cb) -> cb.equal(cb.function("DATE", Date.class, root.get(OrderEntity_.CREATED_DATE)), Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        if (optionDate.equals("YESTERDAY")) {
            return (root, query, cb) -> cb.equal(cb.function("DATE", Date.class, root.get(OrderEntity_.CREATED_DATE)), Date.from(now.minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }
        if (optionDate.equals("CURRENT_MONTH")) {
            return findMonthInYear(now.getMonthValue(), now.getYear());
        }
        if (optionDate.equals("PREVIOUS_MONTH")) {
            return findMonthInYear(now.getMonthValue()-1, now.getYear());
        }
        return null;
    }

    public static Specification<OrderEntity> findMonthInYear(int month, int year) {
        Specifications<OrderEntity> specification = where(hasMonth(month))
                                                    .and(hasYear(year));
        return specification;
    }

    public static Specification<OrderEntity> search(long id, int status, Date startDate, Date endDate, String optionDate) {
        Specifications<OrderEntity> specification = where(hasId(id))
                                                    .and(hasStatus(status))
                                                    .and(rangeDate(startDate, endDate))
                                                    .and(optionDate(optionDate));
        return specification;
    }

}

