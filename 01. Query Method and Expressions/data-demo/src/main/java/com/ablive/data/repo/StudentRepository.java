package com.ablive.data.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ablive.data.domain.Person;
import com.ablive.data.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	List<Student> findByFullTime(boolean fullTime);

	List<Student> findByAge(Integer age);

	List<Student> findByAttendeeLastName(String last);

	Student findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);

	Student findByAttendee(Person person);

	List<Student> findByAgeGreaterThan(int minimumAge);

	List<Student> findByAgeLessThan(int maximumAge);

	List<Student> findByAttendeeLastNameIgnoreCase(String lastName);

	List<Student> findByAttendeeLastNameLike(String likeString);

	Student findFirstByOrderByAttendeeLastNameAsc();

	Student findTopByOrderByAgeDesc();

	List<Student> findTop3ByOrderByAgeDesc();

}