package org.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_details")
public class StudentDetails {

	private Integer dId;
	private Integer age;
	private double height;
	private double weight;
	private Date dob;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="detail_id")
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	@Column(name="student_age",nullable=false)
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name="student_height",precision=1,scale=2)
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Column(name="student_weight",precision=2,scale=3)
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="student_dob",nullable=false)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "StudentDetails [dId=" + dId + ", age=" + age + ", height=" + height + ", weight=" + weight + ", dob="
				+ dob + "]";
	}
}
