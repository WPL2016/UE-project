package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Equip_pres_para_tabDAO;
import net.codejava.spring.model.Equip_dyn_record;
import net.codejava.spring.model.Equip_pres_para_tab;
import net.codejava.spring.model.Equip_pres_record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 

 *
 */
@Controller
public class Equip_pres_para_tabController {

	@Autowired
	private Equip_pres_para_tabDAO equip_pres_para_tabDAO;
	
	@RequestMapping(value="/showequip_pres_para_tab")  	
	public @ResponseBody List<Equip_pres_record> LastState(HttpServletRequest request) throws IOException{
		String equip_num=request.getParameter("equip_num");
		List<Equip_pres_record> lastPresRecord = equip_pres_para_tabDAO.getLastPresStat(equip_num);		
		return lastPresRecord;
	}
	
	
	
	@RequestMapping(value="/equip_pres_para_tab")
	public ModelAndView listEquip_pres_para_tab(ModelAndView model) throws IOException{
		List<Equip_pres_para_tab> listEquip_pres_para_tab = equip_pres_para_tabDAO.list();
		model.addObject("listEquip_pres_para_tab", listEquip_pres_para_tab);
		model.setViewName("equip_pres_para_tab");
		
		return model;
	}
	
	@RequestMapping(value = "equip_pres_para_tab/newEquip_pres_para_tab", method = RequestMethod.GET)
	public ModelAndView newEquip_pres_para_tab(ModelAndView model) {
		Equip_pres_para_tab newEquip_pres_para_tab = new Equip_pres_para_tab();
		model.addObject("equip_pres_para_tab", newEquip_pres_para_tab);
		model.setViewName("Equip_pres_para_tabForm");
		return model;
	}
	
	@RequestMapping(value = "equip_pres_para_tab/saveEquip_pres_para_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Equip_pres_para_tab equip_pres_para_tab) {
		equip_pres_para_tabDAO.saveOrUpdate(equip_pres_para_tab);
		return new ModelAndView("redirect:/equip_pres_para_tab");
	}
	
	@RequestMapping(value = "atype_tab/deleteEquip_pres_para_tab", method = RequestMethod.GET)
	public ModelAndView deleteEquip_pres_para_tab(HttpServletRequest request) {
		String pres_num = request.getParameter("pres_num");
		equip_pres_para_tabDAO.delete(pres_num);
		return new ModelAndView("redirect:/equip_pres_para_tab");
	}
	
	@RequestMapping(value = "equip_pres_para_tab/editEquip_pres_para_tab", method = RequestMethod.GET)
	public ModelAndView editEquip_pres_para_tab(HttpServletRequest request) {
		String pres_num = request.getParameter("pres_num");
		Equip_pres_para_tab equip_pres_para_tab = equip_pres_para_tabDAO.get(pres_num);
		ModelAndView model = new ModelAndView("Equip_pres_para_tabForm");
		model.addObject("equip_pres_para_tab", equip_pres_para_tab);
		
		return model;
	}
}
