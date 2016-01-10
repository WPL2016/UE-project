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
import net.codejava.spring.dao.daointerface.Equip_para_tabDAO;
import net.codejava.spring.model.Equip_para_tab;


@Controller 
public class Equip_para_tabController {
	@Autowired
	private Equip_para_tabDAO equip_para_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	

	
	
	@RequestMapping(value="/toequip_para")
	public ModelAndView toequip_para_tab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("equip_para");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showequip_para_tab")  	
	public @ResponseBody List<Equip_para_tab> allContact() throws IOException{
		List<Equip_para_tab> allEquip_para_tab = equip_para_tabDAO.list();		
		return allEquip_para_tab;
	}
	
	@RequestMapping(value="/editequip_para_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Equip_para_tab equip_para_tab=new Equip_para_tab();
		String oper=request.getParameter("oper");
		String para_num=request.getParameter("para_num");
		
		
				
		equip_para_tab.setEquip_num(request.getParameter("equip_num"));
		equip_para_tab.setPara_num(request.getParameter("para_num"));
		equip_para_tab.setPara_unit(request.getParameter("para_unit"));
		equip_para_tab.setPara_name(request.getParameter("para_name"));
		equip_para_tab.setPara_recorder_num(request.getUserPrincipal().getName());
		
		if(request.getParameter("up_lim_val")!=null)
		{equip_para_tab.setUp_lim_val(Float.valueOf(request.getParameter("up_lim_val")));}
		if(request.getParameter("down_lim_val")!=null)
		{equip_para_tab.setDown_lim_val(Float.valueOf(request.getParameter("down_lim_val")));}
		
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
		if(equip_para_tab.getPara_num()=="") equip_para_tab.setPara_num(null);
		equip_para_tabDAO.saveOrUpdate(equip_para_tab);   
		}
		else if(oper != null && oper.equals("add")){
			if(equip_para_tab.getPara_num()=="") equip_para_tab.setPara_num(null);
			equip_para_tabDAO.saveOrUpdate(equip_para_tab);
		}
		else if(oper != null && oper.equals("del")){
			
	
			
			String[] ids=para_num.split(",");
			for(int i=0;i<ids.length;i++)
			      equip_para_tabDAO.delete(ids[i]);	
		}
		
		
		
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=para_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {equip_para_tab.setEquip_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+equip_para_tab.getEquip_num());
			      equip_para_tabDAO.updateSingleColumn(equip_para_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
