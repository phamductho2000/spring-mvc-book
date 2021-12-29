package com.webbansach.repository;

import com.webbansach.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Transactional
    @Modifying
    @Query("delete from CategoryEntity c where c.id in ?1")
    void removeCategoriesByIds(List<Long> ids);

    List<CategoryEntity> findAllByNameContaining(String key, Pageable pageable);

    List<CategoryEntity> findAllByStatus(int status, Pageable pageable);
}
