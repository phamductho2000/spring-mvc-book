package com.webbansach.repository;

import com.webbansach.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomBookRepository extends JpaRepository<BookEntity, Long>,
                                              JpaSpecificationExecutor<BookEntity> {


}
