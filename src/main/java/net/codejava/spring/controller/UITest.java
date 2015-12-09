package net.codejava.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;


@Controller
public class UITest {
	
	@Autowired
	private ContactDAO contactDAO;



@RequestMapping(value="/toquality")
public ModelAndView quality(){
	ModelAndView model=new ModelAndView();
	model.setViewName("quality");
	int recordnum=contactDAO.countRecord();
	model.addObject("recordnum",recordnum+"");
	return model;
}

@RequestMapping(value="/toquality_product")
public ModelAndView qualitypro(){
	ModelAndView model=new ModelAndView();
	model.setViewName("quality_product");
	int recordnum=contactDAO.countRecord();
	model.addObject("recordnum",recordnum+"");
	return model;
}


@RequestMapping(value="/toschedule")
public ModelAndView schedule(){
	ModelAndView model=new ModelAndView();
	model.setViewName("schedule");
	int recordnum=contactDAO.countRecord();
	model.addObject("recordnum",recordnum+"");
	return model;
}

@RequestMapping(value="/togas")
public ModelAndView gas(){
	ModelAndView model=new ModelAndView();
	model.setViewName("gas");
	int recordnum=contactDAO.countRecord();
	model.addObject("recordnum",recordnum+"");
	return model;
}

@RequestMapping(value="/toequip_smelter")
public ModelAndView smelter(){
	ModelAndView model=new ModelAndView();
	model.setViewName("equip_smelter");
	int recordnum=contactDAO.countRecord();
	model.addObject("recordnum",recordnum+"");
	return model;
}

@RequestMapping(value="/toequip_A")
public ModelAndView A(){
	ModelAndView model=new ModelAndView();
	model.setViewName("equip_A");
	int recordnum=contactDAO.countRecord();
	model.addObject("recordnum",recordnum+"");
	return model;
}

@RequestMapping(value="/toequip_mould")
public ModelAndView equip_mould(){
	ModelAndView model=new ModelAndView();
	model.setViewName("equip_mould");
	int recordnum=contactDAO.countRecord();
	model.addObject("recordnum",recordnum+"");
	return model;
}



}



