package net.codejava.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codejava.spring.dao.daointerface.User_RolesDAO;
import net.codejava.spring.dao.daointerface.User_tabDAO;
import net.codejava.spring.dao.daointerface.UsersDAO;
import net.codejava.spring.model.Contact;
import net.codejava.spring.model.User_Roles;
import net.codejava.spring.model.User_tab;
import net.codejava.spring.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 

 *
 */
@Controller
public class User_tabController {

	@Autowired
	private User_tabDAO user_tabDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private User_RolesDAO user_rolesDAO;
	
	@RequestMapping(value="/toregister")
	public ModelAndView toRegister(ModelAndView model) throws IOException{		
		Users users=new Users();
		model.addObject("users",users);
		model.setViewName("register");	
		return model;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register( @ModelAttribute Users users ,HttpServletResponse response) throws IOException{		
		ModelAndView model=new ModelAndView();
		System.out.println(users.getUsername());
		if(usersDAO.exist(users)==0){
			users.setEnabled(1);
			usersDAO.save(users);
			User_Roles user_roles=new User_Roles();
			user_roles.setUsername(users.getUsername());
			user_roles.setRole_id(2);
			user_rolesDAO.save(user_roles);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('注册成功，请登陆');window.location.href='login'</script>");
			return  null;
		  }
		else {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('该账号已注册，请重新填写');window.location.href='toregister'</script>");
			return  null;
		}
		
	}
	
	@RequestMapping(value="/toedituserinfo")
	public ModelAndView toEditUserInfo(ModelAndView model,HttpServletRequest request) throws IOException{		
		
		Users users=usersDAO.getUser(request.getParameter("username"));
		model.addObject("users",users);
		model.setViewName("edituserinfo");	
		return model;
	}
	

	@RequestMapping(value="/edituserinfo")
	public ModelAndView editUserInfo(@ModelAttribute Users users,HttpServletRequest request,HttpServletResponse response) throws IOException{		
	ModelAndView model=new ModelAndView();
	users.setUsername(request.getUserPrincipal().getName());
	
	if(usersDAO.update(users)==1){	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script language='javascript'>alert('修改成功！');window.location.href=''</script>");
		return  null;
	  }
	else {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script language='javascript'>alert('修改失败，请重新尝试！');window.location.href='toedituserinfo'</script>");
		return  null;
	}
	}
	
	
	
	
	@RequestMapping(value="/user_tab")
	public ModelAndView listUser_tab(ModelAndView model) throws IOException{
		List<User_tab> listUser_tab = user_tabDAO.list();
		model.addObject("listUser_tab", listUser_tab);
		model.setViewName("user_tab");
		
		return model;
	}
	
	@RequestMapping(value = "user_tab/newUser_tab", method = RequestMethod.GET)
	public ModelAndView newUser_tab(ModelAndView model) {
		User_tab newUser_tab = new User_tab();
		model.addObject("user_tab", newUser_tab);
		model.setViewName("User_tabForm");
		return model;
	}
	
	@RequestMapping(value = "user_tab/saveUser_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute User_tab user_tab) {
		user_tabDAO.saveOrUpdate(user_tab);		
		return new ModelAndView("redirect:/user_tab");
	}
	
	@RequestMapping(value = "user_tab/deleteUser_tab", method = RequestMethod.GET)
	public ModelAndView deleteUser_tab(HttpServletRequest request) {
		String user_num = request.getParameter("user_num");
		user_tabDAO.delete(user_num);
		return new ModelAndView("redirect:/user_tab");
	}
	
	@RequestMapping(value = "user_tab/editUser_tab", method = RequestMethod.GET)
	public ModelAndView editUser_tab(HttpServletRequest request) {
		String user_num = request.getParameter("user_num");
		User_tab user_tab = user_tabDAO.get(user_num);
		ModelAndView model = new ModelAndView("User_tabForm");
		model.addObject("user_tab", user_tab);
		
		return model;
	}
}
