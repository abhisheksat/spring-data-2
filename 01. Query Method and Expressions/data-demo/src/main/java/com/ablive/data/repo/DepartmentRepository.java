package com.ablive.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ablive.data.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}