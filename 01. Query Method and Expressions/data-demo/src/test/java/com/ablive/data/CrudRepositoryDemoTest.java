package com.ablive.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ablive.data.domain.Person;
import com.ablive.data.domain.Student;
import com.ablive.data.repo.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryDemoTest {

	@Autowired
	StudentRepository studentRepository;

	@Test
	public void simpleStudentCrudExample() {

		boolean isFullTime = true;

		// Adding 4 student records to the database
		studentRepository.save(new Student(new Person("John", "Doe"), isFullTime, 20));
		studentRepository.save(new Student(new Person("Jane", "Doe"), isFullTime, 22));
		studentRepository.save(new Student(new Person("Matt", "Smith"), isFullTime, 18));
		studentRepository.save(new Student(new Person("Mike", "Kim"), !isFullTime, 19));

		// Displaying all student details
		System.out.println("\n *** All Student Details ***");
		studentRepository.findAll().forEach(System.out::println);

		// Adding 1 year to the age of all students
		studentRepository.findAll().forEach(student -> {
			student.setAge(student.getAge() + 1);
			studentRepository.save(student);
		});

		// Displaying updated student details
		System.out.println("\n *** All Students Updated Details ***");
		studentRepository.findAll().forEach(System.out::println);

		// Deleting all student data
		studentRepository.deleteAll();

		System.out.println("\n*** All Students Deleted ***");
		studentRepository.findAll().forEach(System.out::println);

	}
}