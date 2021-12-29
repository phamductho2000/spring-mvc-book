package com.webbansach.repository;

import com.webbansach.entity.PublisherEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {

    @Query("select p from PublisherEntity p where ( ?1 = 'default' or (p.name like concat('%',?1,'%')) ) " +
            "and ( ?2 = 'default' or (p.address like concat('%',?2,'%')) )" )
    List<PublisherEntity> search(String name, String address, Pageable pageable);

    @Transactional
    @Modifying
    @Query("delete from PublisherEntity p where p.id in ?1")
    void removePublisersByIds(List<Long> ids);

    @Query("select p from PublisherEntity p inner join p.books b inner join b.category c where c.id = ?1 group by p.id" )
    List<PublisherEntity> findAllByCateId(long cateId, Pageable pageable);
}
