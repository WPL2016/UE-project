package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Maint_plan_tabDAO;
import net.codejava.spring.model.Maint_plan_tab;

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
public class Maint_plan_tabController {

	@Autowired
	private Maint_plan_tabDAO maint_plan_tabDAO;
	
	@RequestMapping(value="/maint_plan_tab")
	public ModelAndView listMaint_plan_tab(ModelAndView model) throws IOException{
		List<Maint_plan_tab> listMaint_plan_tab = maint_plan_tabDAO.list();
		model.addObject("listMaint_plan_tab", listMaint_plan_tab);
		model.setViewName("maint_plan_tab");
		
		return model;
	}
	
	@RequestMapping(value = "maint_plan_tab/newMaint_plan_tab", method = RequestMethod.GET)
	public ModelAndView newMaint_plan_tab(ModelAndView model) {
		Maint_plan_tab newMaint_plan_tab = new Maint_plan_tab();
		model.addObject("maint_plan_tab", newMaint_plan_tab);
		model.setViewName("Maint_plan_tabForm");
		return model;
	}
	
	@RequestMapping(value = "maint_plan_tab/saveMaint_plan_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Maint_plan_tab maint_plan_tab) {
		maint_plan_tabDAO.saveOrUpdate(maint_plan_tab);
		return new ModelAndView("redirect:/maint_plan_tab");
	}
	
	@RequestMapping(value = "maint_plan_tab/deleteMaint_plan_tab", method = RequestMethod.GET)
	public ModelAndView deleteMaint_plan_tab(HttpServletRequest request) {
		String maint_plan_num = request.getParameter("maint_plan_num");
		maint_plan_tabDAO.delete(maint_plan_num);
		return new ModelAndView("redirect:/maint_plan_tab");
	}
	
	@RequestMapping(value = "maint_plan_tab/editMaint_plan_tab", method = RequestMethod.GET)
	public ModelAndView editMaint_plan_tab(HttpServletRequest request) {
		String maint_plan_num = request.getParameter("maint_plan_num");
		Maint_plan_tab maint_plan_tab = maint_plan_tabDAO.get(maint_plan_num);
		ModelAndView model = new ModelAndView("Maint_plan_tabForm");
		model.addObject("maint_plan_tab", maint_plan_tab);
		
		return model;
	}
}
