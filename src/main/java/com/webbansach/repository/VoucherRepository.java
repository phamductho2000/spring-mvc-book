package com.webbansach.repository;

import com.webbansach.entity.VoucherEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VoucherRepository extends JpaRepository<VoucherEntity, Long> {

    VoucherEntity findAllByCode(String code);

    @Query("select v from VoucherEntity v where " +
            "( ?1 = '' or (v.code like concat('%',?1,'%')) )" +
            "and ( ?2 = 0 or (v.discount = ?2) )" +
            "and ( ?3 = -1 or (v.status = ?3) )" +
            "and ( ?4 = '' or (v.expiration_date = cast( ?4 as date)) )")
    List<VoucherEntity> search(String code, int discount, int status, String expirationDate, Pageable pageable);
}
