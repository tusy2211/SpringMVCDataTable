package com.spring.SpringCrudApp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.spring.SpringCrudApp.entity.User;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		User user = getByKey(id);
		if(user!=null){
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User)crit.uniqueResult();
		if(user!=null){
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		persist(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("Id", id));
		User user = (User)crit.uniqueResult();
		delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("username"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();
		return users;
	}

}
