package net.codejava.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.model.Contact;  
@Controller  

public class EquipController {  
	@Autowired
	private ContactDAO contactDAO;
	
	
	@RequestMapping(value="/toequip")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		model.setViewName("equip_status");
		
		return model;
	}
	
	@RequestMapping(value="/toecharts")
	public ModelAndView echartstest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("component/1_head");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
   @RequestMapping(value="/equipjax")
	public @ResponseBody List<Contact> allContact() throws IOException{
		List<Contact> allContact = contactDAO.list();
	
		
		return allContact;
	}
	
     
}  

	
