package com.spring.SpringCrudApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.SpringCrudApp.dao.RoleDao;
import com.spring.SpringCrudApp.entity.Role;

@Service("userProfileService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role findRoleById(int id) {
		// TODO Auto-generated method stub
		return roleDao.findRoleById(id);
	}

	@Override
	public Role findRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleDao.findRoleByName(name);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

}
