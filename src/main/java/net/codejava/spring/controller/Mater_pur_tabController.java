package net.codejava.spring.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Mater_pur_tabDAO;
import net.codejava.spring.model.Mater_pur_tab;



@Controller 
public class Mater_pur_tabController {
	@Autowired
	private Mater_pur_tabDAO mater_pur_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/tomater_pur_tab")
	public ModelAndView tomatertab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("mater_pur_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showmater_pur_tab")  	
	public @ResponseBody List<Mater_pur_tab> allContact() throws IOException{
		List<Mater_pur_tab> allMater_pur_tab = mater_pur_tabDAO.list();		
		return allMater_pur_tab;
	}
	
	@RequestMapping(value="/editmater_pur_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request,@RequestParam(value ="stock_stat_time",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) throws ParseException{
		Mater_pur_tab mater_pur_tab=new Mater_pur_tab();
		String oper=request.getParameter("oper");
		String stock_stat_num=request.getParameter("stock_stat_num");
			
				
		mater_pur_tab.setMater_num(request.getParameter("mater_num"));
		mater_pur_tab.setStock_stat_per_num(request.getUserPrincipal().getName());
		mater_pur_tab.setStock_stat_num(request.getParameter("stock_stat_num"));
		mater_pur_tab.setStock_stat_time(date);
		if(request.getParameter("stock_quan")!=null)
		{mater_pur_tab.setStock_quan(Float.valueOf(request.getParameter("stock_quan")));}
		
	
		
		 
	    //System.out.println("½øÈë0");
		System.out.println( mater_pur_tab.getStock_stat_num());
		if(oper != null && oper.equals("edit")){
		if(mater_pur_tab.getStock_stat_num()=="") mater_pur_tab.setStock_stat_num(null);
		mater_pur_tabDAO.saveOrUpdate(mater_pur_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			if(mater_pur_tab.getStock_stat_num()=="") mater_pur_tab.setStock_stat_num(null);
			mater_pur_tabDAO.saveOrUpdate(mater_pur_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=stock_stat_num.split(",");
			for(int i=0;i<ids.length;i++)
				mater_pur_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=stock_stat_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {mater_pur_tab.setMater_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+mater_pur_tab.getStock_stat_num());
			      mater_pur_tabDAO.updateSingleColumn(mater_pur_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
