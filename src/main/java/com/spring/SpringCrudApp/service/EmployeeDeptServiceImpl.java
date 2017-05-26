package com.spring.SpringCrudApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.SpringCrudApp.dao.EmployeeDeptDao;
import com.spring.SpringCrudApp.entity.Dept;
import com.spring.SpringCrudApp.entity.Employee;
@Service
@Transactional
public class EmployeeDeptServiceImpl implements EmployeeDeptService {

	@Autowired
	private EmployeeDeptDao employeeDeptDao;
	
	public EmployeeDeptDao getEmployeeDeptDao() {
		return employeeDeptDao;
	}

	public void setEmployeeDeptDao(EmployeeDeptDao employeeDeptDao) {
		this.employeeDeptDao = employeeDeptDao;
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return employeeDeptDao.getEmployee();
	}

	@Override
	public List<Dept> getDept() {
		// TODO Auto-generated method stub
		return employeeDeptDao.getDept();
	}

	@Override
	public Employee getEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return employeeDeptDao.getEmployeeById(eid);
	}

	@Override
	public Dept getDeptById(int deptId) {
		// TODO Auto-generated method stub
		return employeeDeptDao.getDeptById(deptId);
	}

	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Dept dept=employeeDeptDao.getDeptById(emp.getDepartment().getDeptId());
		emp.setDepartment(dept);
		employeeDeptDao.saveEmployee(emp);
	}

	@Override
	public void deleteEmployee(int emp) {
		// TODO Auto-generated method stub
		employeeDeptDao.deleteEmployee(employeeDeptDao.getEmployeeById(emp));
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeDeptDao.updateEmployee(emp);
	}

	@Override
	public List<Employee> detailsEmployee() {
		// TODO Auto-generated method stub
		return employeeDeptDao.detailsEmployee();
	}

}
