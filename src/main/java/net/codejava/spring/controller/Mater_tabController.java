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
import net.codejava.spring.dao.daointerface.Mater_tabDAO;

import net.codejava.spring.model.Mater_tab;

@Controller 
public class Mater_tabController {
	@Autowired
	private Mater_tabDAO mater_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/tomater_tab")
	public ModelAndView tomatertab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("mater_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showmater_tab")  	
	public @ResponseBody List<Mater_tab> allContact() throws IOException{
		List<Mater_tab> allMater_tab = mater_tabDAO.list();		
		return allMater_tab;
	}
	
	@RequestMapping(value="/editmater_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Mater_tab mater_tab=new Mater_tab();
		String oper=request.getParameter("oper");
		String mater_num=request.getParameter("mater_num");
			
		mater_tab.setMater_num(request.getParameter("mater_num"));
		mater_tab.setMater_name(request.getParameter("mater_name"));
		mater_tab.setMater_sup(request.getParameter("mater_sup"));
		mater_tab.setMater_recorder_num(request.getUserPrincipal().getName());
		mater_tab.setMater_stan(request.getParameter("mater_stan"));
		mater_tab.setMater_unit(request.getParameter("mater_unit"));
		
	
		
		 
	    //System.out.println("½øÈë0");
		System.out.println(mater_tab.getMater_num());
		if(oper != null && oper.equals("edit")){
		if(mater_tab.getMater_num()=="") mater_tab.setMater_num(null);
		mater_tabDAO.saveOrUpdate(mater_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			if(mater_tab.getMater_num()=="") mater_tab.setMater_num(null);
			mater_tabDAO.saveOrUpdate(mater_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=mater_num.split(",");
			for(int i=0;i<ids.length;i++)
				mater_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=mater_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {mater_tab.setMater_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+mater_tab.getMater_num());
			      mater_tabDAO.updateSingleColumn(mater_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
