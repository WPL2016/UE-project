package net.codejava.spring.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;


@Controller
public class AuthorityTestController {
	
	@Autowired
	private ContactDAO contactDAO;
	
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
	
}
	

