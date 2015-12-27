package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Maint_reg_tabDAO;
import net.codejava.spring.model.Equip_dyn_record;
import net.codejava.spring.model.Maint_reg_tab;

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
public class Maint_reg_tabController {

	@Autowired
	private Maint_reg_tabDAO maint_reg_tabDAO;
	
	@RequestMapping(value="/showemaint_reg_tab")  	
	public @ResponseBody List<Maint_reg_tab> allMaint(HttpServletRequest request) throws IOException{
		String equip_num=request.getParameter("equip_num");
		System.out.println("Œ¨–ﬁ…Ë±∏£∫"+equip_num);
		List<Maint_reg_tab> allMaint = maint_reg_tabDAO.list(equip_num);		
		return allMaint;
	}
	
	
	@RequestMapping(value="/maint_reg_tab")
	public ModelAndView listMaint_reg_tab(ModelAndView model) throws IOException{
		List<Maint_reg_tab> listMaint_reg_tab = maint_reg_tabDAO.list("");
		model.addObject("listMaint_reg_tab", listMaint_reg_tab);
		model.setViewName("maint_reg_tab");
		
		return model;
	}
	
	@RequestMapping(value = "maint_reg_tab/newMaint_reg_tab", method = RequestMethod.GET)
	public ModelAndView newMaint_reg_tab(ModelAndView model) {
		Maint_reg_tab newMaint_reg_tab = new Maint_reg_tab();
		model.addObject("maint_reg_tab", newMaint_reg_tab);
		model.setViewName("Maint_reg_tabForm");
		return model;
	}
	
	@RequestMapping(value = "maint_reg_tab/saveMaint_reg_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Maint_reg_tab maint_reg_tab) {
		maint_reg_tabDAO.saveOrUpdate(maint_reg_tab);
		return new ModelAndView("redirect:/maint_reg_tab");
	}
	
	@RequestMapping(value = "maint_reg_tab/deleteMaint_reg_tab", method = RequestMethod.GET)
	public ModelAndView deleteMaint_plan_tab(HttpServletRequest request) {
		String maint_reg_num = request.getParameter("maint_reg_num");
		maint_reg_tabDAO.delete(maint_reg_num);
		return new ModelAndView("redirect:/maint_reg_tab");
	}
	
	@RequestMapping(value = "maint_plan_tab/editMaint_reg_tab", method = RequestMethod.GET)
	public ModelAndView editMaint_reg_tab(HttpServletRequest request) {
		String maint_reg_num = request.getParameter("maint_reg_num");
		Maint_reg_tab maint_reg_tab = maint_reg_tabDAO.get(maint_reg_num);
		ModelAndView model = new ModelAndView("Maint_reg_tabForm");
		model.addObject("maint_reg_tab", maint_reg_tab);
		
		return model;
	}
}
