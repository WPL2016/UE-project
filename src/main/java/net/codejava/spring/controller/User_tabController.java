package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.User_tabDAO;
import net.codejava.spring.model.User_tab;

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
