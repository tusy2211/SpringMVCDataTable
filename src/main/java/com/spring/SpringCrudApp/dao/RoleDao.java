package com.spring.SpringCrudApp.dao;

import java.util.List;

import com.spring.SpringCrudApp.entity.Role;

public interface RoleDao {

	public Role findRoleById(int id);

	public Role findRoleByName(String name);
	
	public List<Role> findAll();
}
