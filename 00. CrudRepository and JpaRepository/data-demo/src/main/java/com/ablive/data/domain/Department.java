package com.ablive.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();

	public Department(String name) {
		this.name = name;
	}

	protected Department() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + id + ", name='" + name + '\'' + ", courses=" + courses + '}';
	}
	
}