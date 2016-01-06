package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.model.Equip_tab;


@Controller
public class StartController {
	
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private Equip_tabDAO equip_tabDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		
		model.setViewName("index");
		
		return model;
	}
	@RequestMapping(value="/login")
	public   ModelAndView login(){
		ModelAndView model=new ModelAndView();
		model.setViewName("login");
		
		return model;
	}
	
	
	@RequestMapping(value="/toadmin")
	public ModelAndView adminTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("admin");
		
		return model;
	}
	@RequestMapping(value="/form")
	public ModelAndView formTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("form");
		
		return model;
	}
	
	@RequestMapping(value="/tohello")
	public ModelAndView tohello(){
		ModelAndView model=new ModelAndView();
		model.setViewName("hello");
		
		return model;
	}
	
	@RequestMapping(value="/tomodule")
	public ModelAndView viewModule(){
		ModelAndView model=new ModelAndView();
		model.setViewName("base_module");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/toinput1")
	public ModelAndView viewinput1(){
		ModelAndView model=new ModelAndView();
		model.setViewName("material");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/toinput2")
	public ModelAndView viewinput2(){
		ModelAndView model=new ModelAndView();
		model.setViewName("energy");
		List<Equip_tab> mainequip=equip_tabDAO.getSomeEquip("main");
		model.addObject("mainequip",mainequip);
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/toinput3")
	public ModelAndView viewinput3(){
		ModelAndView model=new ModelAndView();
		model.setViewName("quality");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}

	
	
}
	