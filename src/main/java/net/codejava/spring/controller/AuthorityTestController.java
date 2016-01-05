package net.codejava.spring.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.RolesDAO;
import net.codejava.spring.dao.daointerface.UsersDAO;
import net.codejava.spring.model.Roles;
import net.codejava.spring.model.Users;


@Controller
public class AuthorityTestController {
	
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private RolesDAO rolesDAO;
	@RequestMapping(value="/toauthority")
	public ModelAndView toAuthority() {		
		ModelAndView model=new ModelAndView();		
		model.setViewName("authority");		
		return model;
	}
	
	@RequestMapping(value="/admin/admintest")
	public   ModelAndView adminTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	
	@RequestMapping(value="/user/usertest")
	public ModelAndView userTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	@RequestMapping(value="/engineer/engineertest")
	public ModelAndView engineerTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");	
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	
	
	
	
	
	@RequestMapping(value="/useroradmin/firsttest")
	public ModelAndView userOrAdmin(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}

	@RequestMapping(value="/userandadmin/firsttest")
	public ModelAndView userAndAdmin(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="toasignrole")
	public ModelAndView totoasignrole() {		
		ModelAndView model=new ModelAndView();		
		List<Users> users=usersDAO.list();
		model.setViewName("asignrole");	
		model.addObject("users",users);
		return model;
	}

	@RequestMapping(value="/edituserrole")
	public ModelAndView editUserroles(HttpServletRequest request) {		
		ModelAndView model=new ModelAndView();	
		String username=request.getParameter("username");
		List<Roles> roles=rolesDAO.list(username);
		List<Roles> noroles=rolesDAO.listWithout(username);
		model.setViewName("user_roles");	
		model.addObject("roles",roles);
		model.addObject("noroles",noroles);
		return model;
	}
}
	

