package com.webbansach.specifications;

import com.webbansach.entity.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;


import static org.springframework.data.jpa.domain.Specifications.where;

@Component
public class BookSpecification {

    public static Specification<BookEntity> hasNameLike(String name) {
        return (root, query, cb) -> cb.like(root.get(BookEntity_.NAME), "%"+name+"%");
    }

    public static Specification<BookEntity> hasStatus(int status) {
        return (root, query, cb) -> cb.equal(root.get(BookEntity_.STATUS), status);
    }

    public static Specification<BookEntity> hasId(long id) {
        return (root, query, cb) -> cb.equal(root.get(BookEntity_.ID), id);
    }

    public static Specification<BookEntity> hasPublisherId(long id) {
        if(id == 0){
            return null;
        }
        return (root, query, cb) -> {
            Join<BookEntity, PublisherEntity> publisherEntityJoin = root.join(BookEntity_.PUBLISHER);
            return cb.equal(publisherEntityJoin.get(PublisherEntity_.ID), id);
        };
    }

    public static Specification<BookEntity> hasCateId(long id) {
        if(id == 0){
            return null;
        }
        return (root, query, cb) -> {
            Join<BookEntity, CategoryEntity> categoryEntityJoin = root.join(BookEntity_.CATEGORY);
            return cb.equal(categoryEntityJoin.get(CategoryEntity_.ID), id);
        };
    }

    public static Specification<BookEntity> sort(String input) {
        switch (input) {

            case "DES_PRICE":
                return (root, query, cb) -> (Predicate) query.orderBy(cb.desc(root.get(BookEntity_.PRICE)));
            case "ASC_PRICE":
                return (root, query, cb) -> (Predicate) query.orderBy(cb.asc(root.get(BookEntity_.PRICE)));
            case "NEW":
                return (root, query, cb) -> (Predicate) query.orderBy(cb.desc(root.get(BookEntity_.CREATED_DATE)));
            case "DISCOUNT":
                return (root, query, cb) -> (Predicate) query.orderBy(cb.desc(root.get(BookEntity_.DISCOUNT)));
            default:
                throw new RuntimeException("Operation not supported yet");
        }
    }

    public static Specification<BookEntity> greaterThanMoney(int price) {
        if(price == 0){
            return null;
        }
        return (root, query, cb) -> cb.greaterThan(root.get(BookEntity_.PRICE), price);
    }

    public static Specification<BookEntity> rangeMoney(int min, int max) {
        if(min == 0 && max == 0){
            return null;
        }
        if(min != 0 && max == 0){
            return greaterThanMoney(min);
        }
        return (root, query, cb) -> cb.between(root.get(BookEntity_.PRICE), min, max);
    }

    public static Specification<BookEntity> lessThanMoney(int price) {
        return (root, query, cb) -> cb.lessThan(root.get(BookEntity_.PRICE), price);
    }

    public static Specification<BookEntity> filter(int cateId, int publisherId, int min, int max) {
        Specifications<BookEntity> specification = where(hasCateId(cateId))
                                                    .and(hasPublisherId(publisherId))
                                                    .and(rangeMoney(min, max));
        return specification;
    }

    public static Specification<BookEntity> search(String name, int status, int cateId, int publisherId) {
        Specifications<BookEntity> specification = where(hasNameLike(name))
                                                    .and(hasStatus(status))
                                                    .and(hasCateId(cateId))
                                                    .and(hasPublisherId(publisherId));
        return specification;
    }


}
