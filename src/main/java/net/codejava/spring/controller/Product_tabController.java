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
import net.codejava.spring.dao.daointerface.Product_tabDAO;

import net.codejava.spring.model.Product_tab;

@Controller 
public class Product_tabController {
	@Autowired
	private Product_tabDAO product_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/toproduct_tab")
	public ModelAndView toproduct_tab(){
		ModelAndView model=new ModelAndView();
		model.setViewName("mater_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showproduct_tab")  	
	public @ResponseBody List<Product_tab> allContact() throws IOException{
		List<Product_tab> allProduct_tab = product_tabDAO.list();		
		return allProduct_tab;
	}
	
	@RequestMapping(value="/editproduct_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Product_tab product_tab=new Product_tab();
		String oper=request.getParameter("oper");
		String product_num=request.getParameter("product_num");
		System.out.println("iiiuui"+product_num);	
		product_tab.setProduct_num(request.getParameter("product_num"));
		product_tab.setProduct_name(request.getParameter("product_name"));
		product_tab.setProduct_recorder_num(request.getUserPrincipal().getName());
		product_tab.setMater_num(request.getParameter("mater_num"));
		
		
		 
	    //System.out.println("½øÈë0");
		System.out.println(product_tab.getProduct_num());
		if(oper != null && oper.equals("edit")){
		if(product_tab.getProduct_num()=="") product_tab.setProduct_num(null);
		product_tabDAO.saveOrUpdate(product_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			if(product_tab.getProduct_num()=="") product_tab.setProduct_num(null);
			product_tabDAO.saveOrUpdate(product_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=product_num.split(",");
			for(int i=0;i<ids.length;i++)
				product_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=product_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {product_tab.setProduct_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+product_tab.getProduct_num());
			      product_tabDAO.updateSingleColumn(product_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
