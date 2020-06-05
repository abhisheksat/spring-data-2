package com.ablive.data.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Staff_member")
public class Staff {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Embedded
	private Person member;

	public Staff(Person member) {
		this.member = member;
	}

	protected Staff() {
	}

	public Person getMember() {
		return member;
	}

	@Override
	public String toString() {
		return "Staff{" + "id=" + id + ", member=" + member + '}';
	}
	
}