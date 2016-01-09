package net.codejava.spring.controller;

import java.io.IOException;
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
import net.codejava.spring.dao.daointerface.Product_qual_asse_tabDAO;
import net.codejava.spring.model.Product_qual_asse_tab;

@Controller 
public class Product_qual_asse_tabController {
	@Autowired
	private Product_qual_asse_tabDAO product_qual_asse_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/getsomeproduct")
	public @ResponseBody  List<Product_qual_asse_tab> listSomeEquip(ModelAndView model,HttpServletRequest request) throws IOException{
		List<Product_qual_asse_tab> mainequip=product_qual_asse_tabDAO.getSomeProduct(request.getParameter("type"));
		return mainequip;
	}
	
	
	@RequestMapping(value="/toquality_product")
	public ModelAndView qualitypro(){
		ModelAndView model=new ModelAndView();
		model.setViewName("quality_product");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}

	
	@RequestMapping(value="/showproduct_qual_asse_tab")  	
	public @ResponseBody List<Product_qual_asse_tab> allContact() throws IOException{
		List<Product_qual_asse_tab> allProduct_qual_asse_tab = product_qual_asse_tabDAO.list();		
		return allProduct_qual_asse_tab;
	}
	

	@RequestMapping(value="/editproduct_qual_asse_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request, @RequestParam(value ="product_qual_asse_date",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		Product_qual_asse_tab product_qual_asse_tab=new Product_qual_asse_tab();
		String oper=request.getParameter("oper");
		String product_qual_asse_num=request.getParameter("product_qual_asse_num");
			
		product_qual_asse_tab.setProduct_qual_asse_num(request.getParameter("product_qual_asse_num"));
		product_qual_asse_tab.setProduct_qual_asse_cont(request.getParameter("product_qual_asse_cont"));
		product_qual_asse_tab.setProduct_qual_asse_res(request.getParameter("product_qual_asse_res"));
		product_qual_asse_tab.setProduct_qual_asse_per_num(request.getParameter("product_qual_asse_per_num"));
		product_qual_asse_tab.setProduct_num(request.getParameter("product_num"));
		product_qual_asse_tab.setProduct_qual_asse_date(date);
	
		
		
		System.out.println("oper:"+oper);
		System.out.println("product_qual_asse_num:"+product_qual_asse_num);
		System.out.println("product_qual_asse_cont:"+request.getParameter("product_qual_asse_cont"));
		System.out.println("product_qual_asse_res:"+request.getParameter("product_qual_asse_res"));
		System.out.println("product_qual_asse_per_num:"+request.getParameter("product_qual_asse_per_num"));
		System.out.println("product_qual_asse_date:"+request.getParameter("product_qual_asse_date"));
		System.out.println("product_num:"+request.getParameter("product_num"));
		 
	    //System.out.println("½øÈë0");
		System.out.println(product_qual_asse_tab.getProduct_qual_asse_num());
		if(oper != null && oper.equals("edit")){
		if(product_qual_asse_tab.getProduct_qual_asse_num()=="") product_qual_asse_tab.setProduct_qual_asse_num(null);
		product_qual_asse_tabDAO.saveOrUpdate(product_qual_asse_tab);   
		
		}
		else if(oper != null && oper.equals("add")){
			
	    if(product_qual_asse_tab.getProduct_num()=="") product_qual_asse_tab.setProduct_qual_asse_num(null);
			product_qual_asse_tabDAO.saveOrUpdate(product_qual_asse_tab);
		}
	 	else if(oper != null && oper.equals("del")){
			
	 		String[] ids=product_qual_asse_num.split(",");
			for(int i=0;i<ids.length;i++)
				product_qual_asse_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=product_qual_asse_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {product_qual_asse_tab.setProduct_qual_asse_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+product_qual_asse_tab.getProduct_qual_asse_num());
			      product_qual_asse_tabDAO.updateSingleColumn(product_qual_asse_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	
}
