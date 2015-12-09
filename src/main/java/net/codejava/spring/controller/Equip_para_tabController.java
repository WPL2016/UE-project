package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Equip_para_tabDAO;
import net.codejava.spring.model.Equip_para_tab;

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
public class Equip_para_tabController {

	@Autowired
	private Equip_para_tabDAO equip_para_tabDAO;
	
	@RequestMapping(value="/equip_para_tab")
	public ModelAndView listEquip_para_tab(ModelAndView model) throws IOException{
		List<Equip_para_tab> listEquip_para_tab = equip_para_tabDAO.list();
		model.addObject("listEquip_para_tab", listEquip_para_tab);
		model.setViewName("equip_para_tab");
		
		return model;
	}
	
	@RequestMapping(value = "equip_para_tab/newEquip_para_tab", method = RequestMethod.GET)
	public ModelAndView newEquip_para_tab(ModelAndView model) {
		Equip_para_tab newEquip_para_tab = new Equip_para_tab();
		model.addObject("equip_para_tab", newEquip_para_tab);
		model.setViewName("Equip_para_tabForm");
		return model;
	}
	
	@RequestMapping(value = "equip_para_tab/saveEquip_para_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Equip_para_tab equip_para_tab) {
		equip_para_tabDAO.saveOrUpdate(equip_para_tab);
		return new ModelAndView("redirect:/equip_para_tab");
	}
	
	@RequestMapping(value = "equip_tab/deleteEquip_para_tab", method = RequestMethod.GET)
	public ModelAndView deleteEquip_tab(HttpServletRequest request) {
		String equip_para_num = request.getParameter("equip_para_num");
		equip_para_tabDAO.delete(equip_para_num);
		return new ModelAndView("redirect:/equip_para_tab");
	}
	
	@RequestMapping(value = "equip_para_tab/editEquip_para_tab", method = RequestMethod.GET)
	public ModelAndView editEquip_para_tab(HttpServletRequest request) {
		String equip_para_num = request.getParameter("equip_para_num");
		Equip_para_tab equip_para_tab = equip_para_tabDAO.get(equip_para_num);
		ModelAndView model = new ModelAndView("Equip_para_tabForm");
		model.addObject("equip_para_tab", equip_para_tab);
		
		return model;
	}
}
