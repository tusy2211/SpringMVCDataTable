package com.spring.SpringCrudApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.SpringCrudApp.entity.Dept;
import com.spring.SpringCrudApp.entity.Employee;
import com.spring.SpringCrudApp.entity.Role;
import com.spring.SpringCrudApp.service.EmployeeDeptService;
import com.spring.SpringCrudApp.service.RoleService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class EmployeeController {

	@Autowired
	private EmployeeDeptService employeeDeptService;
	
	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	private RoleService roleService;
	
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		return persistentTokenBasedRememberMeServices;
	}

	public void setPersistentTokenBasedRememberMeServices(
			PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices) {
		this.persistentTokenBasedRememberMeServices = persistentTokenBasedRememberMeServices;
	}

	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return authenticationTrustResolver;
	}

	public void setAuthenticationTrustResolver(AuthenticationTrustResolver authenticationTrustResolver) {
		this.authenticationTrustResolver = authenticationTrustResolver;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public EmployeeDeptService getEmployeeDeptService() {
		return employeeDeptService;
	}

	public void setEmployeeDeptService(EmployeeDeptService employeeDeptService) {
		this.employeeDeptService = employeeDeptService;
	}

	@RequestMapping(method = RequestMethod.GET, value = {"/","/emplist.do"})
	public String getEmployee(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession sess = request.getSession();
		List<Employee> empList = new ArrayList<>();
		empList = employeeDeptService.getEmployee();
		sess.setAttribute("emplist", empList);
		model.addAttribute("loggedinuser", getPrincipal());
		return "empList";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addemp.do")
	public String getAddEmployee(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession sess = request.getSession();
		Map<Integer, String> dept = new HashMap<>();
		List<Dept> listDept = employeeDeptService.getDept();
		for (Dept d : listDept) {
			dept.put(d.getDeptId(), d.getDeptName());
		}
		Employee emp = new Employee();
		model.addAttribute("emp", emp);
		sess.setAttribute("eDept", dept);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "addEmp";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addemp.do")
	public ModelAndView AddEmployee(@ModelAttribute("emp") Employee emp, Model model) {
//		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
//		String date = "";
//		date = formatDate.format((Date) emp.geteBirthDay());
//		System.out.println("date === " + date);
//		Date date1 = null;
//		try {
//			date1 = formatDate.parse(emp.geteBirthDay());
//			System.out.println("date1 === " + date1);
//		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		emp.seteBirthDay(date1);
		employeeDeptService.saveEmployee(emp);
		model.addAttribute("loggedinuser", getPrincipal());
		return new ModelAndView("redirect:emplist.do");
	}

	@RequestMapping(value = { "/edit-emp-{empId}" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable("empId") int empId,HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession sess = request.getSession();
		Employee emp = new Employee();
		emp = employeeDeptService.getEmployeeById(empId);
		Map<Integer, String> dept = new HashMap<>();
		List<Dept> listDept = employeeDeptService.getDept();
		for (Dept d : listDept) {
			dept.put(d.getDeptId(), d.getDeptName());
		}
		sess.setAttribute("eDept", dept);
		model.addAttribute("emp", emp);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "addEmp";
	}

	@RequestMapping(value = { "/edit-emp-{empId}" }, method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("emp") Employee emp, Model model) {
//		DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
//		String date = "";
//		date = formatDate.format((Date) emp.geteBirthDay());
//		
//		Date date1 = null;
//		try {
//			date1 = formatDate.parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		emp.seteBirthDay(date1);
		employeeDeptService.updateEmployee(emp);
		model.addAttribute("emp", emp);
		model.addAttribute("loggedinuser", getPrincipal());
		return new ModelAndView("redirect:emplist.do");
	}

	@RequestMapping(value = { "/delete-emp-{empId}" }, method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("empId") int empId, Model model) {
		employeeDeptService.deleteEmployee(empId);
		return new ModelAndView("redirect:emplist.do");
	}
	
	@RequestMapping(value = { "/detail-emp-{empId}" }, method = RequestMethod.GET)
	public String detailEmployee(@PathVariable("empId") int empId,HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession sess = request.getSession();
		Employee emp = new Employee();
		emp = employeeDeptService.getEmployeeById(empId);
		Map<Integer, String> dept = new HashMap<>();
		List<Dept> listDept = employeeDeptService.getDept();
		for (Dept d : listDept) {
			dept.put(d.getDeptId(), d.getDeptName());
		}
		sess.setAttribute("eDept", dept);
		model.addAttribute("employee", emp);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "empDetail";
	}
	
	/**
	 * This method will provide Role list to views
	 */
	@ModelAttribute("roles")
	public List<Role> initializeProfiles() {
		return roleService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}
	
	/**
	 * This method returns the principal[user-name] of logged-in user.
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
	
	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/emplist.do";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	
}
