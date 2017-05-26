package com.spring.SpringCrudApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.SpringCrudApp.dao.UserDao;
import com.spring.SpringCrudApp.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(username);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.saveUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAllUsers();
	}

	@Override
	public boolean isUserUnique(int id, String username) {
		// TODO Auto-generated method stub
		User user = findUserByName(username);
		return ( user == null || ((id != 0) && (user.getId() == id)));
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		User entity = userDao.findUserById(user.getId());
		if(entity != null){
			entity.setId(user.getId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setUsername(user.getUsername());
			entity.setRoles(user.getRoles());
		}
	}

}
