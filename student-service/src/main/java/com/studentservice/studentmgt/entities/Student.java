package com.studentservice.studentmgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private int age;
	private String address;
	private Long phoneNumber;

	public Student() {
	}

	public Student(String name, int age, String address, Long phoneNumber) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		Integer hashId = id.hashCode();
		return hashId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null && obj.getClass() != this.getClass()) {
			return false;
		}

		Student that = (Student) obj;
		return this.id == that.id;

	}
}