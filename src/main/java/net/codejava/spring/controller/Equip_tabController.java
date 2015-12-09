package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.model.Equip_tab;

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
public class Equip_tabController {

	@Autowired
	private Equip_tabDAO equip_tabDAO;
	
	@RequestMapping(value="/equip_tab")
	public ModelAndView listEquip_tab(ModelAndView model) throws IOException{
		List<Equip_tab> listEquip_tab = equip_tabDAO.list();
		model.addObject("listEquip_tab", listEquip_tab);
		model.setViewName("equip_tab");
		
		return model;
	}
	
	@RequestMapping(value = "equip_tab/newEquip_tab", method = RequestMethod.GET)
	public ModelAndView newEquip_tab(ModelAndView model) {
		Equip_tab newEquip_tab = new Equip_tab();
		model.addObject("equip_tab", newEquip_tab);
		model.setViewName("Equip_tabForm");
		return model;
	}
	
	@RequestMapping(value = "equip_tab/saveEquip_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Equip_tab equip_tab) {
		equip_tabDAO.saveOrUpdate(equip_tab);
		return new ModelAndView("redirect:/equip_tab");
	}
	
	@RequestMapping(value = "equip_tab/deleteEquip_tab", method = RequestMethod.GET)
	public ModelAndView deleteEquip_tab(HttpServletRequest request) {
		String equip_num = request.getParameter("equip_num");
		equip_tabDAO.delete(equip_num);
		return new ModelAndView("redirect:/equip_tab");
	}
	
	@RequestMapping(value = "equip_tab/editEquip_tab", method = RequestMethod.GET)
	public ModelAndView editEquip_tab(HttpServletRequest request) {
		String equip_num = request.getParameter("equip_num");
		System.out.println(equip_num);
		Equip_tab equip_tab = equip_tabDAO.get(equip_num);
		ModelAndView model = new ModelAndView("Equip_tabForm");
		model.addObject("equip_tab", equip_tab);
		
		return model;
	}
}
