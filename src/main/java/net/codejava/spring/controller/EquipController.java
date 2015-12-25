package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.model.Contact;
import net.codejava.spring.model.Equip_tab;  
@Controller  

public class EquipController {  
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private Equip_tabDAO equip_tabDAO;
	
	@RequestMapping(value="/toequip")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		int recordnum=contactDAO.countRecord();
		List<Equip_tab> mainequip=equip_tabDAO.getSomeEquip("main");
		model.addObject("recordnum",recordnum+"");
		model.addObject("mainequip",mainequip);
		model.setViewName("equip_status");
		
		return model;
	}
	
	@RequestMapping(value="/toecharts")
	public ModelAndView echartstest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("maintain");
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

	
