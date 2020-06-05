package com.ablive.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ablive.data.domain.Department;
import com.ablive.data.repo.DepartmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryDemoTest {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void runJpaRepositoryMethods() {
		
		departmentRepository.save(new Department("Computer Science"));
		departmentRepository.flush();
		
		departmentRepository.saveAndFlush(new Department("Fine Arts"));
		
		departmentRepository.save(new Department("Electrical Engineering"));
		
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