package com.webbansach.repository;

import com.webbansach.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
    @Query("select name from PublisherEntity ")
    List<String> getNamePublisher();
}
