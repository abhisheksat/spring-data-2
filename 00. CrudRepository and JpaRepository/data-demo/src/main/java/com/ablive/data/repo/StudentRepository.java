 package com.ablive.data.repo;

import org.springframework.data.repository.CrudRepository;

import com.ablive.data.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}