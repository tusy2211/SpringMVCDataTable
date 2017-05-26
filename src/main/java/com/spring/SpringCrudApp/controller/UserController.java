package com.spring.SpringCrudApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.SpringCrudApp.entity.Role;
import com.spring.SpringCrudApp.entity.User;
import com.spring.SpringCrudApp.service.RoleService;
import com.spring.SpringCrudApp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
	public String newUser(Model model){
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	@RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model){
		if (result.hasErrors()) {
			return "registration";
		}
		
		userService.saveUser(user);
		model.addAttribute("success", "User " + user.getUsername() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<Role> initializeProfiles() {
		return roleService.findAll();
	}
	
	/**
	 *    This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
}
