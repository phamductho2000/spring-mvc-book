package com.webbansach.repository;

import com.webbansach.entity.PublisherEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
    @Query("select name from PublisherEntity ")
    List<String> getNamePublisher();

    @Query("select p from PublisherEntity p where ( ?1 = '' or (p.name like concat('%',?1,'%')) ) " +
            "and ( ?2 = '' or (p.address like concat('%',?2,'%')) )" )
    List<PublisherEntity> search(String name, String address, Pageable pageable);
}
