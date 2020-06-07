package com.ablive.data.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ablive.data.domain.Course;
import com.ablive.data.view.CourseView;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Course findByName(String name);

	List<Course> findByDepartmentChairMemberLastName(String chair);

	@Query("Select c from Course c where c.department.chair.member.lastName=:chair")
	List<Course> findByChairLastName(@Param("chair") String chairLastName);

	@Query("Select c from Course c join c.prerequisites p where p.id = ?1")
	List<Course> findCourseByPrerequisite(int id);

	/*
	 * @Query("Select new com.ablive.data.view.CourseView" +
	 * "(c.name, c.instructor.member.lastName, c.department) from Course c where c.id=?1"
	 * ) CourseView getCourseView(int courseId);
	 */
	
	List<Course> findByCredits(@Param("credits") int credits);
	
	Page<Course> findByCredits(@Param("credits") int credits, Pageable pageable);
	
}