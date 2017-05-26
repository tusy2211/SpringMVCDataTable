package com.spring.SpringCrudApp.entity;

import java.io.Serializable;

public enum RoleType implements Serializable {

	ROLE_USER("ROLE_USER"),
	ROLE_ADMIN("ROLE_ADMIN");

	String roleType;

	
	private RoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
}
