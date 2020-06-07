package com.ablive.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ablive.data.domain.Department;
import com.ablive.data.domain.Person;
import com.ablive.data.domain.Staff;
import com.ablive.data.repo.DepartmentRepository;
import com.ablive.data.repo.StaffRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryDemoTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private StaffRepository staffRepository;
	
	@Test
	public void runJpaRepositoryMethods() {

		Staff deanJones = staffRepository.save(new Staff(new Person("John", "Jones")));
		Staff deanMartin = staffRepository.save(new Staff(new Person("Matthew", "Martin")));
		
		departmentRepository.save(new Department("Computer Science", deanJones));
		departmentRepository.flush();
		
		departmentRepository.saveAndFlush(new Department("Fine Arts", deanMartin));
		
		departmentRepository.save(new Department("Electrical Engineering", deanJones));
		
		System.out.println("\n*** The 3 departments are ***");
		departmentRepository.findAll().forEach(System.out::println);
		
		departmentRepository.deleteInBatch(departmentRepository.findAll().subList(0, 1));
		
		System.out.println("\n*** 1 Department is Deleted ***");
		
		departmentRepository.findAll().forEach(System.out::println);
		departmentRepository.deleteAllInBatch();
		
		System.out.println("\n*** All Departments Deleted ***");
		departmentRepository.findAll().forEach(System.out::println);	
	}
}