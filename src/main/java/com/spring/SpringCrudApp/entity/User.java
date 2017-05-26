package com.spring.SpringCrudApp.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@NotEmpty
	@Column(name="password", unique=true, nullable=false)
	private String password;
	
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", 
             joinColumns = { @JoinColumn(name = "user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
