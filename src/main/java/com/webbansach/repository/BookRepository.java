package com.webbansach.repository;

import com.opensymphony.module.sitemesh.Page;
import com.webbansach.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findAllByCategoryId(long id, Pageable pageable);

}
