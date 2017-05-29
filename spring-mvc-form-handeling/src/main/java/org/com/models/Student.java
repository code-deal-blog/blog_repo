package org.com.models;

import java.util.Date;
import java.util.List;

public class Student {

	private String studentName;
	private Integer studentAge;
	private Date studentDob;
	private List<String> studentHobbies;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	public Date getStudentDob() {
		return studentDob;
	}
	public void setStudentDob(Date studentDob) {
		this.studentDob = studentDob;
	}
	public List<String> getStudentHobbies() {
		return studentHobbies;
	}
	public void setStudentHobbies(List<String> studentHobbies) {
		this.studentHobbies = studentHobbies;
	}
}
