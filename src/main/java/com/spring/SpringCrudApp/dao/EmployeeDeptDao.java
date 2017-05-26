package com.spring.SpringCrudApp.dao;

import java.util.List;

import com.spring.SpringCrudApp.entity.Dept;
import com.spring.SpringCrudApp.entity.Employee;

public interface EmployeeDeptDao {
	public  List<Employee> getEmployee();
	public  List<Dept> getDept();
	public Employee getEmployeeById(int eid);
	public Dept getDeptById(int deptId);
	public void saveEmployee(Employee emp);
	public void deleteEmployee(Employee emp);
	public void updateEmployee(Employee emp);
	public List<Employee> detailsEmployee();
}
