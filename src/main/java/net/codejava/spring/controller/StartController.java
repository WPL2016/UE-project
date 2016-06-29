package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Equip_para_tabDAO;
import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.dao.daointerface.Product_tabDAO;
import net.codejava.spring.dao.daointerface.RolesDAO;
import net.codejava.spring.model.Equip_tab;
import net.codejava.spring.model.Product_tab;
import net.codejava.spring.model.Roles;
import net.codejava.spring.model.User_Roles;


@Controller
public class StartController {
	
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private Equip_tabDAO equip_tabDAO;
	
	@Autowired
	private Product_tabDAO product_tabDAO;
	@Autowired
	private RolesDAO rolesDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model,HttpServletRequest request) throws IOException{
		List<Roles> roles=rolesDAO.list(request.getUserPrincipal().getName());	  
	    HttpSession session = request.getSession();
	    session.setAttribute("user_role_type",roles.get(0).getRole_type() );
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value="/getmenu")
	public @ResponseBody  List<Roles> listRoles(ModelAndView model,HttpServletRequest request) throws IOException{
		 List<Roles> roles=rolesDAO.list(request.getUserPrincipal().getName());
		return roles;
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
	
	@RequestMapping(value="/toenergy")
	public ModelAndView viewinput2(){
		ModelAndView model=new ModelAndView();
		model.setViewName("energy");
		List<Equip_tab> electricequip=equip_tabDAO.getSomeEquipByEnergy("electric");
		model.addObject("electricequip",electricequip);
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/togas")
	public ModelAndView gas(){
		ModelAndView model=new ModelAndView();
		model.setViewName("gas");
		List<Equip_tab> gasequip=equip_tabDAO.getSomeEquipByEnergy("gas");
		model.addObject("gasequip",gasequip);
		
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	
	@RequestMapping(value="/toquality")
	public ModelAndView viewinput3(){
		ModelAndView model=new ModelAndView();
		model.setViewName("quality");
		
		List<Product_tab> product_tab=product_tabDAO.list();
		model.addObject("product_tab",product_tab);
		
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}

	@RequestMapping(value="/todata_acquisition")
	public ModelAndView data_acquisition(){
		ModelAndView model=new ModelAndView();
		model.setViewName("data_acquisition");
		//List<Equip_tab> gasequip=equip_tabDAO.getSomeEquipByEnergy("gas");
		//model.addObject("gasequip",gasequip);
		
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
		
		
		
	}
	
	 
	
}
	