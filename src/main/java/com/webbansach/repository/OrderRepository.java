package com.webbansach.repository;

import com.webbansach.entity.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByUserId(long id, Pageable pageable);

    List<OrderEntity> findAllByStatus(int status, Pageable pageable);

    @Query("SELECT SUM(o.total_price) FROM OrderEntity o")
    Integer totalPriceAllOrder();

    @Query("select o from OrderEntity o where date(o.createdDate) = current_date")
    List<OrderEntity> findAllByCurrentDay(Pageable pageable);

    @Query("select o from OrderEntity o where month(o.createdDate) = month(current_date) and year(o.createdDate) = year(current_date)")
    List<OrderEntity>findAllByCurrentMonth(Pageable pageable);

    @Query("select o from OrderEntity o where date(o.createdDate) = current_date - 1")
    List<OrderEntity> findAllByPreviousDay(Pageable pageable);

    @Query("select o from OrderEntity o where month(o.createdDate) = month(current_date) - 1 and year(o.createdDate) = year(current_date)")
    List<OrderEntity>findAllByPreviousMonth(Pageable pageable);

    @Query("select o from OrderEntity o where date(o.createdDate) = current_date")
    List<OrderEntity> findAllNewOrder(Pageable pageable);

    @Query("select o from OrderEntity o where ( ?1 = 0 or (o.id = ?1) ) " +
            "and ( ?2 = -1 or (o.status = ?2) )" +
            "and ( ?3 = '' or ?4 = '' or (o.createdDate between cast( ?3 as date) and cast( ?4 as date)) )")
    List<OrderEntity> search(int id, int status, String startDate, String endDate, Pageable pageable);
}
