package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.model.Equip_tab;

@Controller 
public class Equip_tabController {
	@Autowired
	private Equip_tabDAO equip_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/toequip_tab")
	public ModelAndView toequiptab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("equip_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showequip_tab")  	
	public @ResponseBody List<Equip_tab> allContact() throws IOException{
		List<Equip_tab> allEquip_tab = equip_tabDAO.list();		
		return allEquip_tab;
	}
	
	@RequestMapping(value="/editequip_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Equip_tab equip_tab=new Equip_tab();
		String oper=request.getParameter("oper");
		String equip_num=request.getParameter("equip_num");
		
		
		
		equip_tab.setEquip_num(request.getParameter("equip_num"));
		equip_tab.setEquip_name(request.getParameter("equip_name"));
		equip_tab.setEquip_sup(request.getParameter("equip_sup"));
		equip_tab.setEquip_recorder_num(request.getUserPrincipal().getName());
		equip_tab.setEqu_equip_num(request.getParameter("equ_equip_num"));
		
		System.out.println("oper:"+oper);
		System.out.println("equip_num:"+equip_num);
		System.out.println("equip_name:"+request.getParameter("equip_name"));
		System.out.println("equip_sup:"+request.getParameter("equip_sup"));
		System.out.println("equ_equip_num:"+request.getParameter("equ_equip_num"));
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
		equip_tabDAO.saveOrUpdate(equip_tab);   
		}
		else if(oper != null && oper.equals("add")){
			equip_tabDAO.saveOrUpdate(equip_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=equip_num.split(",");
			for(int i=0;i<ids.length;i++)
			      equip_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=equip_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {equip_tab.setEquip_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+equip_tab.getEquip_num());
			      equip_tabDAO.updateSingleColumn(equip_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
