package com.webbansach.repository;

import com.webbansach.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

   ContactEntity findFirstByOrderByAddressAsc();
}
