package com.spring.SpringCrudApp.service;

import java.util.List;

import com.spring.SpringCrudApp.entity.Role;

public interface RoleService {

	public Role findRoleById(int id);

	public Role findRoleByName(String name);
	
	public List<Role> findAll();
}
