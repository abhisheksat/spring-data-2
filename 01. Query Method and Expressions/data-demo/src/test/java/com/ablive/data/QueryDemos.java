package com.ablive.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ablive.data.domain.Person;
import com.ablive.data.repo.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDemos {

	@Autowired
	StudentRepository studentRepository;
	
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
	
}