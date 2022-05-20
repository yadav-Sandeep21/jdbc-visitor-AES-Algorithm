package com.ty.visitor.dto;

import java.time.LocalDate;

public class Visitor {
	private int id;
	private String name;
	private String email;
	private String phone;
	private int age;
	private String gender;
	private String dob;
	private String visitdatetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getVisitdatetime() {
		return visitdatetime;
	}
	public void setVisitdatetime(String visitdatetime) {
		this.visitdatetime = visitdatetime;
	}
	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", visitdatetime=" + visitdatetime + "]";
	}
	
	
}
