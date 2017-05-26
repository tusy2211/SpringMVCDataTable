package com.spring.SpringCrudApp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.spring.SpringCrudApp.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

	@Override
	public Role findRoleById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (Role) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("name"));
		return (List<Role>)crit.list();
	}

}
