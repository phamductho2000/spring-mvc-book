package com.webbansach.repository;

import com.webbansach.entity.WishlistEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {

    List<WishlistEntity> findAllByUserEntityId(long id, Pageable pageable);

    @Query("select w from WishlistEntity w where w.bookEntity.id = ?1 and w.userEntity.id = ?2")
    WishlistEntity findOneByBookIdAndUserId(long bId, long uId);
}
