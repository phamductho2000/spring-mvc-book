package com.webbansach.repository;

import com.webbansach.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findOneByUsernameAndStatus(String username, int status);

    UserEntity findOneByUsername(String username);

    UserEntity findByEmail(String email);

    @Transactional
    @Modifying
    @Query("delete from UserEntity u where u.id in ?1")
    void removeUsersByIds(List<Long> ids);

    @Query("select u from UserEntity u inner join u.roles r where r.code in ?1")
    List<UserEntity> findAllByRole(List<String> codes, Pageable pageable);

    @Query("select u from UserEntity u where date(u.createdDate) = current_date")
    List<UserEntity> findAllByCurrentDay(Pageable pageable);

    @Query("select u from UserEntity u inner join u.roles r " +
            "where (?1 = '' or (u.name like concat('%',?1,'%'))) " +
            "and (?2 = -1 or (u.status = ?2))" +
            "and (?3 = '' or (r.code = ?3))")
    List<UserEntity> search(String name, int status, String role, Pageable pageable);

    List<UserEntity> findAllByNameContaining(String key, Pageable pageable);
}
