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
import net.codejava.spring.dao.daointerface.Equip_product_relat_tabDAO;
import net.codejava.spring.model.Equip_product_relat_tab;


@Controller 
public class Equip_product_relat_tabController {
	@Autowired
	private Equip_product_relat_tabDAO equip_product_relat_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/toequip_product_relat_tab")
	public ModelAndView toequip_product_relattab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("equip_product_relat");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showequip_product_relat")  	
	public @ResponseBody List<Equip_product_relat_tab> allContact() throws IOException{
		List<Equip_product_relat_tab> allEquip_product_relat_tab= equip_product_relat_tabDAO.list();		
		return allEquip_product_relat_tab;
	}
	
	@RequestMapping(value="/editequip_product_relat_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Equip_product_relat_tab equip_product_relat_tab=new Equip_product_relat_tab();
		String oper=request.getParameter("oper");
		String equip_product_relat_num=request.getParameter("equip_product_relat_num");
			
		equip_product_relat_tab.setEquip_product_relat_num(request.getParameter("equip_product_relat_num"));
		equip_product_relat_tab.setEquip_num(request.getParameter("equip_num"));
		equip_product_relat_tab.setProduct_num(request.getParameter("product_num"));
		equip_product_relat_tab.setEquip_product_relat_recorder_num(request.getUserPrincipal().getName());
		
		
		
		
		if(oper != null && oper.equals("edit")){
		if(equip_product_relat_tab.getEquip_product_relat_num()=="") equip_product_relat_tab.setEquip_product_relat_num(null);
		equip_product_relat_tabDAO.saveOrUpdate(equip_product_relat_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			if(equip_product_relat_tab.getEquip_product_relat_num()=="") equip_product_relat_tab.setEquip_product_relat_num(null);
			equip_product_relat_tabDAO.saveOrUpdate(equip_product_relat_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=equip_product_relat_num.split(",");
			for(int i=0;i<ids.length;i++)
				equip_product_relat_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=equip_product_relat_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {equip_product_relat_tab.setEquip_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+equip_product_relat_tab.getEquip_product_relat_num());
			     /* equip_product_relat_tabDAO.updateSingleColumn(equip_product_relat_tab,column_name,column_value);	
				 */ }
		     }
		return "done";
	}
	
	
}
