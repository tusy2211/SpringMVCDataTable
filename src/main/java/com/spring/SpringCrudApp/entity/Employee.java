package com.spring.SpringCrudApp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import com.spring.SpringCrudApp.entity.Dept;

@Entity
@Table(name="employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int eId;
	
	@Column(name="emp_name")
	private String eName;
	
	@Column(name="emp_gender")
	private int eGender;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="emp_birthday")
	private Date eBirthDay;
	
	@Column(name="emp_email")
	private String eEmail;
	
	@Column(name="emp_image")
	private String eImage;
	
	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	private Dept department;


	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public int geteGender() {
		return eGender;
	}


	public void seteGender(int eGender) {
		this.eGender = eGender;
	}


	public Dept getDepartment() {
		return department;
	}


	public void setDepartment(Dept department) {
		this.department = department;
	}


	public Date geteBirthDay() {
		return eBirthDay;
	}


	public void seteBirthDay(Date eBirthDay) {
		this.eBirthDay = eBirthDay;
	}


	public String geteEmail() {
		return eEmail;
	}


	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}


	public String geteImage() {
		return eImage;
	}


	public void seteImage(String eImage) {
		this.eImage = eImage;
	}
	
	
}
