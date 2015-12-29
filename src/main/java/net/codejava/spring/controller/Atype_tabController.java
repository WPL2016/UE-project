package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.Atype_tabDAO;
import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.model.Atype_tab;


@Controller 
public class Atype_tabController {
	@Autowired
	private Atype_tabDAO atype_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/toatype_tab")
	public ModelAndView toatypetab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("atype_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showatype_tab")  	
	public @ResponseBody List<Atype_tab> allContact() throws IOException{
		List<Atype_tab> allAtype_tab = atype_tabDAO.list();		
		return allAtype_tab;
	}
	
	@RequestMapping(value="/editatype_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Atype_tab atype_tab=new Atype_tab();
		String oper=request.getParameter("oper");
		String atype_num=request.getParameter("atype_num");
			
		atype_tab.setAtype_num(request.getParameter("atype_num"));
		atype_tab.setAtype_name(request.getParameter("atype_name"));
		atype_tab.setAtype_sup(request.getParameter("atype_sup"));
		atype_tab.setAtype_recorder_num(request.getUserPrincipal().getName());
				
		
		
		 
	    //System.out.println("½øÈë0");
		//System.out.println(atype_tab.getEqu_equip_num());
		if(oper != null && oper.equals("edit")){
		if(atype_tab.getAtype_num()=="") atype_tab.setAtype_num(null);
		atype_tabDAO.saveOrUpdate(atype_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			if(atype_tab.getAtype_num()=="") atype_tab.setAtype_num(null);
			atype_tabDAO.saveOrUpdate(atype_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=atype_num.split(",");
			for(int i=0;i<ids.length;i++)
				atype_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=atype_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {atype_tab.setAtype_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+atype_tab.getAtype_num());
			      atype_tabDAO.updateSingleColumn(atype_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
