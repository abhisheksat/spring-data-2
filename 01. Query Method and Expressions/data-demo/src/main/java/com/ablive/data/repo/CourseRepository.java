package com.ablive.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ablive.data.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}