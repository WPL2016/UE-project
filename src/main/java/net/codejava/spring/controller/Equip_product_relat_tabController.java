package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Equip_product_relat_tabDAO;
import net.codejava.spring.model.Equip_product_relat_tab;

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
public class Equip_product_relat_tabController {

	@Autowired
	private Equip_product_relat_tabDAO equip_product_relat_tabDAO;
	
	@RequestMapping(value="/equip_product_relat_tab")
	public ModelAndView listEquip_product_relat_tab(ModelAndView model) throws IOException{
		List<Equip_product_relat_tab> listEquip_product_relat_tab = equip_product_relat_tabDAO.list();
		model.addObject("listEquip_product_relat_tab", listEquip_product_relat_tab);
		model.setViewName("equip_product_relat_tab");
		
		return model;
	}
	
	@RequestMapping(value = "equip_product_relat_tab/newEquip_product_relat_tab", method = RequestMethod.GET)
	public ModelAndView newEquip_product_relat_tab(ModelAndView model) {
		Equip_product_relat_tab newEquip_product_relat_tab = new Equip_product_relat_tab();
		model.addObject("equip_product_relat_tab", newEquip_product_relat_tab);
		model.setViewName("Equip_product_relat_tabForm");
		return model;
	}
	
	@RequestMapping(value = "equip_tab/saveEquip_product_relat_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Equip_product_relat_tab equip_product_relat_tab) {
		equip_product_relat_tabDAO.saveOrUpdate(equip_product_relat_tab);
		return new ModelAndView("redirect:/equip_product_relat_tab");
	}
	
	@RequestMapping(value = "equip_product_relat_tab/deleteEquip_product_relat_tab", method = RequestMethod.GET)
	public ModelAndView deleteEquip_product_relat_tab(HttpServletRequest request) {
		String equip_product_relat_num = request.getParameter("equip_product_relat_num");
		equip_product_relat_tabDAO.delete(equip_product_relat_num);
		return new ModelAndView("redirect:/equip_product_relat_tab");
	}
	
	@RequestMapping(value = "equip_product_relat_tab/editEquip_product_relat_tab", method = RequestMethod.GET)
	public ModelAndView editEquip_tab(HttpServletRequest request) {
		String equip_product_relat_num = request.getParameter("equip_product_relat_num");
		Equip_product_relat_tab equip_product_relat_tab = equip_product_relat_tabDAO.get(equip_product_relat_num);
		ModelAndView model = new ModelAndView("Equip_product_relat_tabForm");
		model.addObject("equip_product_relat_tab", equip_product_relat_tab);
		
		return model;
	}
}
