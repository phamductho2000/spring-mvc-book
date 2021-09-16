package com.webbansach.repository;

import com.webbansach.entity.ReviewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query("select r from ReviewEntity r where r.bookEntity.id = ?1")
    List<ReviewEntity> findAllByBookId(long id, Pageable pageable);
}
