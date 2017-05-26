package com.spring.SpringCrudApp.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.SpringCrudApp.entity.Dept;
import com.spring.SpringCrudApp.entity.Employee;
@Repository
@Transactional
public class EmployeeDeptDaoImpl implements EmployeeDeptDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		String hql = "from Employee e";
		List<Employee> elist = sessionFactory.getCurrentSession().createQuery(hql).list();

		return elist;
	}

	@Override
	public List<Dept> getDept() {
		// TODO Auto-generated method stub
		String hql = "from Dept d";
		List<Dept> elist = sessionFactory.getCurrentSession().createQuery(hql).list();

		return elist;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		// TODO Auto-generated method stub
		Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, eid);
		if (employee != null) {
			Hibernate.initialize(employee.getDepartment());
		}

		return employee;
	}

	@Override
	public Dept getDeptById(int deptId) {
		// TODO Auto-generated method stub
		Dept dep = (Dept) sessionFactory.getCurrentSession().load(Dept.class, deptId);
		return dep;
	}

	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(emp);
	}

	@Override
	public List<Employee> detailsEmployee() {
		// TODO Auto-generated method stub
		String hql = "select e.eId, e.eName, e.eGender, d.deptName from Employee e, Dept d where e.department = d.deptId";
		List<Employee> elist = sessionFactory.getCurrentSession().createQuery(hql).list();
		return elist;
	}

	

}
