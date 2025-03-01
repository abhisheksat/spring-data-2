package com.ablive.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer credits;

	@OneToOne
	private Staff instructor;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Course> prerequisites = new ArrayList<>();

	@ManyToOne
	private Department department;

	public Course(String name, Integer credits, Staff instructor, Department department) {
		this.name = name;
		this.credits = credits;
		this.instructor = instructor;
		this.department = department;
	}

	protected Course() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Staff getInstructor() {
		return instructor;
	}

	public Department getDepartment() {
		return department;
	}

	public Course addPrerequisite(Course prerequisite) {
		prerequisites.add(prerequisite);
		return this;
	}

	@Override
	public String toString() {
		return "Course{" + "name='" + name + '\'' + ", id=" + id + ", credits=" + credits + ", instructor=" + instructor
				+ ", department=" + department.getName() + '}';
	}
	
}