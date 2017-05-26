package com.spring.SpringCrudApp.dao;

import java.util.List;

import com.spring.SpringCrudApp.entity.User;

public interface UserDao {

	public User findUserById(int id);
	
	public User findUserByName(String username);
	
	public void saveUser(User user);
	
	public void deleteUser(int id);
	
	public List<User> findAllUsers();
}
