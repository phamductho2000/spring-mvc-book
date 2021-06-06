package com.webbansach.repository;

import com.webbansach.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query("select name from CategoryEntity")
    List<String> getNameCategory();

}
