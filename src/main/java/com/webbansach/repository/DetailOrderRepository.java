package com.webbansach.repository;

import com.webbansach.entity.DetailOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DetailOrderRepository extends JpaRepository<DetailOrderEntity, Long> {

    List<DetailOrderEntity> findAllByOrderId(long id);
}
