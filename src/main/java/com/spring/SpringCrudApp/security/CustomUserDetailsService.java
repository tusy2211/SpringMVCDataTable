package com.spring.SpringCrudApp.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.SpringCrudApp.entity.Role;
import com.spring.SpringCrudApp.entity.User;
import com.spring.SpringCrudApp.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService  {

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.findUserByName(username);
		logger.info("User : {}", user);
		if(user==null){
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				 true, true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role : user.getRoles()){
			logger.info("Role : {}", role);
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		logger.info("authorities : {}", authorities);
		return authorities;
	}
}
