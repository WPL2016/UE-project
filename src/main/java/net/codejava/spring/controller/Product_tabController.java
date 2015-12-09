package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Product_tabDAO;
import net.codejava.spring.model.Product_tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 

 *
 */
@Controller
public class Product_tabController {

	@Autowired
	private Product_tabDAO product_tabDAO;
	
	@RequestMapping(value="/product_tab")
	public ModelAndView listProduct_tab(ModelAndView model) throws IOException{
		List<Product_tab> listProduct_tab = product_tabDAO.list();
		model.addObject("listProduct_tab", listProduct_tab);
		model.setViewName("product_tab");
		
		return model;
	}
	
	@RequestMapping(value = "product_tab/newProduct_tab", method = RequestMethod.GET)
	public ModelAndView newProduct_tab(ModelAndView model) {
		Product_tab newProduct_tab = new Product_tab();
		model.addObject("product_tab", newProduct_tab);
		model.setViewName("Product_tabForm");
		return model;
	}
	
	@RequestMapping(value = "product_tab/saveProduct_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Product_tab product_tab) {
		product_tabDAO.saveOrUpdate(product_tab);
		return new ModelAndView("redirect:/product_tab");
	}
	
	@RequestMapping(value = "product_tab/deleteProduct_tab", method = RequestMethod.GET)
	public ModelAndView deleteProduct_tab(HttpServletRequest request) {
		String product_num = request.getParameter("product_num");
		product_tabDAO.delete(product_num);
		return new ModelAndView("redirect:/product_tab");
	}
	
	@RequestMapping(value = "product_tab/editProduct_tab", method = RequestMethod.GET)
	public ModelAndView editProduct_tab(HttpServletRequest request) {
		String product_num = request.getParameter("product_num");
		Product_tab product_tab = product_tabDAO.get(product_num);
		ModelAndView model = new ModelAndView("Product_tabForm");
		model.addObject("product_tab", product_tab);
		
		return model;
	}
}
