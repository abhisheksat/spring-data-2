package com.ablive.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ablive.data.domain.Course;
import com.ablive.data.domain.Person;
import com.ablive.data.repo.CourseRepository;
import com.ablive.data.repo.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDemos {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void simpleQueryExamples() {
		
		System.out.println("\nFind 20 year old students...");
		studentRepository.findByAge(20).forEach(System.out::println);
		
		System.out.println("\nFind full time old students...");
		studentRepository.findByFullTime(true).forEach(System.out::println);
		
		System.out.println("\nFind students with 'Doe' as last name...");
		studentRepository.findByAttendeeLastName("Doe").forEach(System.out::println);
	}

	@Test
	public void intermediateQueryExamples() {
		
		System.out.println("\nFind students by name and traverse entities:\n" + studentRepository.findByAttendeeFirstNameAndAttendeeLastName("Jane", "Doe"));
		
		System.out.println("\nFind students by name with Person obj: \n" + studentRepository.findByAttendee(new Person("Jane", "Doe")));

		System.out.println("\nFind students older than 19:");
		studentRepository.findByAgeGreaterThan(19).forEach(System.out::println);
		
		System.out.println("\nFind students under 19:");
		studentRepository.findByAgeLessThan(19).forEach(System.out::println);
		
		System.out.println("\nUsing Ignore case on last name:");
		studentRepository.findByAttendeeLastNameIgnoreCase("doe").forEach(System.out::println);
		
		System.out.println("\nFind students with 'i' in the last name:");
		studentRepository.findByAttendeeLastNameLike("%i%").forEach(System.out::println);
		
		System.out.println("\nFind first student in alphabet:" + studentRepository.findFirstByOrderByAttendeeLastNameAsc());
		
		System.out.println("\nFind oldest student: " + studentRepository.findTopByOrderByAgeDesc());
		
	}
	
	@Test
    public void jpqlQueries() {
     
        System.out.println("Find Courses where Jones is the department Chair with Property Expression");
        courseRepository.findByDepartmentChairMemberLastName("Jones").forEach(System.out::println);

        //Select c from Course c where c.department.chair.member.lastName=:chair
        System.out.println("\nFind Courses where Jones is the department Chair with @Query");
        courseRepository.findByChairLastName("Jones").forEach(System.out::println);

        Course english101 = courseRepository.findByName("English 101");

        //Select c from Course c join c.prerequisites p where p.id = ?1
        System.out.println("\nFind Courses where English 101 is a prerequisite");
        courseRepository.findCourseByPrerequisite(english101.getId()).forEach(System.out::println);

        //Select new com.example.university.view.CourseView
        //  (c.name, c.instructor.member.lastName, c.department.name) from Course c where c.id=?1
//        System.out.println("\nCourseView for English 101 \n" + courseRepository.getCourseView(english101.getId()));
    }
	
}