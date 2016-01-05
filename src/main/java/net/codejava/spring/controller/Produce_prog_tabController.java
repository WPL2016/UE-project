package net.codejava.spring.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Produce_prog_tabDAO;
import net.codejava.spring.model.Atype_use_inf_tab;
import net.codejava.spring.model.Produce_prog_tab;
import net.codejava.spring.model.Produce_static_tab;

@Controller 
public class Produce_prog_tabController {
	@Autowired
	private Produce_prog_tabDAO produce_prog_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	/*@RequestMapping(value="/toproduce_prog_tab")
	public ModelAndView toproduce_prog_tab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("produce_prog_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}*/
	
	
	@RequestMapping(value="/toproduce_prog_tab")
	public ModelAndView toProduce_prog_tab(ModelAndView model) throws IOException{
	
		int recordnum=contactDAO.countRecord();		
		model.addObject("recordnum",recordnum+"");		
		model.setViewName("produce_prog_tab");		
		return model;
	}
	
	@RequestMapping(value="/showproduce_static_tab")  	
	public @ResponseBody List<Produce_static_tab> allProduce_plan_tab(HttpServletRequest request) throws IOException{

		List<Produce_static_tab> allProduce_static_tab = produce_prog_tabDAO.listProduce_static_tab();		
		return allProduce_static_tab;
	}
	
	@RequestMapping(value="/showsomeproduce_static_tab")  	
	public @ResponseBody List<Produce_static_tab> someProduce_plan_tab(HttpServletRequest request) throws IOException{
		String produce_plan_num=request.getParameter("produce_plan_num");
		System.out.println(produce_plan_num);
		List<Produce_static_tab> someProduce_static_tab = produce_prog_tabDAO.list(produce_plan_num);		
		return someProduce_static_tab;
	}
	/*@RequestMapping(value="/showproduce_prog_tab")  	
	public @ResponseBody List<Produce_prog_tab> allContact() throws IOException{
		List<Produce_prog_tab> allProduce_prog_tab = produce_prog_tabDAO.list();		
		return allProduce_prog_tab;
	}
	@RequestMapping(value="/showproduce_static_tab")  	
	public @ResponseBody List<Produce_static_tab> allContact() throws IOException{
		List<Produce_static_tab> allProduce_static_tab = produce_prog_tabDAO.listProduce_static_tab();		
		return allProduce_static_tab;
	}*/
	
	/*@RequestMapping(value="/editproduce_prog_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) throws ParseException {
		Produce_prog_tab produce_prog_tab=new Produce_prog_tab();
		String oper=request.getParameter("oper");
		String produce_prog_num=request.getParameter("produce_prog_num");
				
		produce_prog_tab.setProduce_prog_num(request.getParameter("produce_plan_num"));
		
		produce_prog_tab.setBat_produce_start_time(Timestamp.valueOf(request.getParameter("bat_produce_start_time")));
				
		produce_prog_tab.setEquip_product_relat_num(request.getParameter("equip_product_relat_num"));
		 
		System.out.println("oper:"+oper);
		System.out.println("produce_prog_num:"+produce_prog_num);
		System.out.println("bat_produce_start_time:"+request.getParameter("bat_produce_start_time"));
		System.out.println("equip_product_relat_num:"+request.getParameter("equip_product_relat_num"));
		
	    //System.out.println("½øÈë0");
		System.out.println(produce_prog_tab.getProduce_prog_num());
		if(oper != null && oper.equals("edit")){
		if(produce_prog_tab.getProduce_prog_num()=="") produce_prog_tab.setProduce_prog_num(null);
		produce_prog_tabDAO.saveOrUpdate(produce_prog_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			if(produce_prog_tab.getProduce_prog_num()=="")produce_prog_tab.setProduce_prog_num(null);
			produce_prog_tabDAO.saveOrUpdate(produce_prog_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=produce_prog_num.split(",");
			for(int i=0;i<ids.length;i++)
				produce_prog_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=produce_prog_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {produce_prog_tab.setProduce_prog_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+produce_prog_tab.getProduce_prog_num());
			      produce_prog_tabDAO.updateSingleColumn(produce_prog_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}*/
	
	
}
