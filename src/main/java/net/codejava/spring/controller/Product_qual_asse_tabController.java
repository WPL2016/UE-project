package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Product_qual_asse_tabDAO;
import net.codejava.spring.model.Product_qual_asse_tab;

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
public class Product_qual_asse_tabController {

	@Autowired
	private Product_qual_asse_tabDAO product_qual_asse_tabDAO;
	
	@RequestMapping(value="/product_qual_asse_tab")
	public ModelAndView listProduct_qual_asse_tab(ModelAndView model) throws IOException{
		List<Product_qual_asse_tab> listProduct_qual_asse_tab = product_qual_asse_tabDAO.list();
		model.addObject("listProduct_qual_asse_tab", listProduct_qual_asse_tab);
		model.setViewName("product_qual_asse_tab");
		
		return model;
	}
	
	@RequestMapping(value = "product_qual_asse_tab/newProduct_qual_asse_tab", method = RequestMethod.GET)
	public ModelAndView newProduct_tab(ModelAndView model) {
		Product_qual_asse_tab newProduct_qual_asse_tab = new Product_qual_asse_tab();
		model.addObject("product_qual_asse_tab", newProduct_qual_asse_tab);
		model.setViewName("Product_qual_asse_tabForm");
		return model;
	}
	
	@RequestMapping(value = "product_qual_asse_tab/saveProduct_qual_asse_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Product_qual_asse_tab product_qual_asse_tab) {
		product_qual_asse_tabDAO.saveOrUpdate(product_qual_asse_tab);
		return new ModelAndView("redirect:/product_qual_asse_tab");
	}
	
	@RequestMapping(value = "product_qual_asse_tab/deleteProduct_qual_asse_tab", method = RequestMethod.GET)
	public ModelAndView deleteProduct_tab(HttpServletRequest request) {
		String product_qual_asse_num = request.getParameter("product_qual_asse_num");
		product_qual_asse_tabDAO.delete(product_qual_asse_num);
		return new ModelAndView("redirect:/product_qual_asse_tab");
	}
	
	@RequestMapping(value = "product_tab/editProduct_qual_asse_tab", method = RequestMethod.GET)
	public ModelAndView editProduct_tab(HttpServletRequest request) {
		String product_qual_asse_num = request.getParameter("product_qual_asse_num");
		Product_qual_asse_tab product_qual_asse_tab = product_qual_asse_tabDAO.get(product_qual_asse_num);
		ModelAndView model = new ModelAndView("Product_qual_asse_tabForm");
		model.addObject("product_qual_asse_tab", product_qual_asse_tab);
		
		return model;
	}
}
