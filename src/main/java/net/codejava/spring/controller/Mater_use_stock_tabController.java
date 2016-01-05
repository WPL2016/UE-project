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
import net.codejava.spring.dao.daointerface.Mater_use_stock_tabDAO;
import net.codejava.spring.dao.daointerface.Produce_prog_tabDAO;
import net.codejava.spring.model.Mater_stock_stat_tab;
import net.codejava.spring.model.Mater_use_stock_tab;
import net.codejava.spring.model.Produce_prog_tab;
import net.codejava.spring.model.Produce_static_tab;

@Controller 
public class Mater_use_stock_tabController {
	@Autowired
	private  Mater_use_stock_tabDAO  mater_use_stock_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	/*@RequestMapping(value="/tomater_use_stock_tab")
	public ModelAndView tomater_use_stock_tab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("mater_use_stock_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}*/
	
	
	
	/*@RequestMapping(value="/showmater_use_stock_tab")  	
	public @ResponseBody List<Mater_use_stock_tab> allContact() throws IOException{
		List<Mater_use_stock_tab> allMater_use_stock_tab = mater_use_stock_tabDAO.listMater_use_stock_tab();		
		return allMater_use_stock_tab;
	}*/
	
	@RequestMapping(value="/tomater_use_stock_tab")
	public ModelAndView toMater_use_stock_tab(ModelAndView model) throws IOException{
	
		int recordnum=contactDAO.countRecord();		
		model.addObject("recordnum",recordnum+"");		
		model.setViewName("mater_use_stock_tab");		
		return model;
	}
	
	@RequestMapping(value="/showmater_use_stock_tab")  	
	public @ResponseBody List<Mater_use_stock_tab> allMater_tab(HttpServletRequest request) throws IOException{

		List<Mater_use_stock_tab> allMater_use_stock_tab = mater_use_stock_tabDAO.listMater_use_stock_tab();		
		return allMater_use_stock_tab;
	}
	
	@RequestMapping(value="/showsomemater_use_stock_tab")  	
	public @ResponseBody List<Mater_use_stock_tab> someMater_tab(HttpServletRequest request) throws IOException{
		String mater_num=request.getParameter("mater_num");
		System.out.println(mater_num);
		List<Mater_use_stock_tab> someMater_use_stock_tab = mater_use_stock_tabDAO.listMater_use_stock_tab(mater_num);		
		return someMater_use_stock_tab;
	}
	
	
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
