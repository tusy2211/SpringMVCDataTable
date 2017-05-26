package com.spring.SpringCrudApp.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.spring.SpringCrudApp.entity.Employee;

@Entity
@Table(name="dept")
public class Dept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Employee.class, cascade = CascadeType.ALL, mappedBy = "department")
	private Set<Employee> employees;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmpoyees() {
		return employees;
	}

	public void setEmpoyees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
