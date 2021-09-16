package com.webbansach.repository;

import com.webbansach.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findOneByCode(String code);

    @Query("select r.code from RoleEntity r")
    List<String> getAllCode();
}
