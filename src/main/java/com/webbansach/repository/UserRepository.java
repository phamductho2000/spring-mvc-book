package com.webbansach.repository;

import com.webbansach.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    UserEntity findOneByUsernameAndStatus(String username, int status);
    UserEntity findOneByUsername(String username);

    @Query("select u from UserEntity u inner join u.roles r where r.code = ?1")
    List<UserEntity> findAllByRole(String code, Pageable pageable);

    @Query("select u from UserEntity u where date(u.createdDate) = current_date")
    List<UserEntity> findAllByCurrentDay(Pageable pageable);

    List<UserEntity> findAllByNameContaining(String key, Pageable pageable);
}
