package com.ablive.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ablive.data.domain.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}