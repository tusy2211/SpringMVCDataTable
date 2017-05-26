package com.spring.SpringCrudApp.service;

import java.util.List;

import com.spring.SpringCrudApp.entity.User;

public interface UserService {

	public User findUserById(int id);

	public User findUserByName(String username);

	public void saveUser(User user);

	public void deleteUser(int id);
	
	public void updateUser(User user);

	public List<User> findAllUsers();

	boolean isUserUnique(int id, String username);
}
