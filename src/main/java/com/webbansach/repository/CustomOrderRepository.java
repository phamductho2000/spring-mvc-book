package com.webbansach.repository;

import com.webbansach.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomOrderRepository extends JpaRepository<OrderEntity, Long>,
                                               JpaSpecificationExecutor<OrderEntity> {
}
