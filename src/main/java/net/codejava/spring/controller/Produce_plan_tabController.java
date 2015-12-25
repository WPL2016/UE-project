package net.codejava.spring.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Produce_plan_tabDAO;
import net.codejava.spring.model.Produce_plan_tab;

@Controller 
public class Produce_plan_tabController {
	@Autowired
	private Produce_plan_tabDAO produce_plan_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/toproduce_plan_tab")
	public ModelAndView toproduce_plan_tab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("produce_prog_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showproduce_plan_tab")  	
	public @ResponseBody List<Produce_plan_tab> allContact() throws IOException{
		List<Produce_plan_tab> allProduce_plan_tab = produce_plan_tabDAO.list();		
		return allProduce_plan_tab;
	}
	
	@RequestMapping(value="/editproduce_plan_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) throws ParseException {
		Produce_plan_tab produce_plan_tab=new Produce_plan_tab();
		String oper=request.getParameter("oper");
		String produce_plan_num=request.getParameter("produce_plan_num");
				
		produce_plan_tab.setProduce_plan_num(request.getParameter("produce_plan_num"));
		produce_plan_tab.setProduce_plan_recorder_num(request.getUserPrincipal().getName());
		
		
		String date=request.getParameter("plan_time");
		date="2015-12-18 00:00:00.000";
		System.out.println(date);
		Date date1=new Date();
		date1.parse("2015-12-18 00:00:00.000");
		
		produce_plan_tab.setPlan_time(date1);
		
		produce_plan_tab.setPlan_quan(Integer.parseInt(request.getParameter("plan_quan")));		
		produce_plan_tab.setPlan_work_time(Integer.parseInt(request.getParameter("plan_work_time")));
		produce_plan_tab.setEquip_product_relat_num(request.getParameter("Equip_product_relat_num"));
		 
		System.out.println("oper:"+oper);
		System.out.println("produce_plan_num:"+produce_plan_num);
		System.out.println("plan_time:"+request.getParameter("plan_time"));
		System.out.println("plan_quan:"+request.getParameter("plan_quan"));
		System.out.println("plan_work_time:"+request.getParameter("plan_work_time"));
		System.out.println("equip_product_relat_num:"+request.getParameter("equip_product_relat_num"));
		
	    //System.out.println("½øÈë0");
		System.out.println(produce_plan_tab.getProduce_plan_num());
		if(oper != null && oper.equals("edit")){
		if(produce_plan_tab.getProduce_plan_num()=="") produce_plan_tab.setProduce_plan_num(null);
		produce_plan_tabDAO.saveOrUpdate(produce_plan_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			if(produce_plan_tab.getProduce_plan_num()=="")produce_plan_tab.setProduce_plan_num(null);
			produce_plan_tabDAO.saveOrUpdate(produce_plan_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=produce_plan_num.split(",");
			for(int i=0;i<ids.length;i++)
				produce_plan_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=produce_plan_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {produce_plan_tab.setProduce_plan_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+produce_plan_tab.getProduce_plan_num());
			      produce_plan_tabDAO.updateSingleColumn(produce_plan_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
