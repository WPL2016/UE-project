package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Atype_use_inf_tabDAO;
import net.codejava.spring.model.Atype_use_inf_tab;

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
public class Atype_use_inf_tabController {

	@Autowired
	private Atype_use_inf_tabDAO atype_use_inf_tabDAO;
	
	@RequestMapping(value="/atype_use_inf_tab")
	public ModelAndView listAtype_use_inf_tab(ModelAndView model) throws IOException{
		List<Atype_use_inf_tab> listAtype_use_inf_tab = atype_use_inf_tabDAO.list();
		model.addObject("listAtype_use_inf_tab", listAtype_use_inf_tab);
		model.setViewName("atype_use_inf_tab");
		
		return model;
	}
	
	@RequestMapping(value = "atype_use_inf_tab/newAtype_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView newAtype_tab(ModelAndView model) {
		Atype_use_inf_tab newAtype_use_inf_tab = new Atype_use_inf_tab();
		model.addObject("atype_use_inf_tab", newAtype_use_inf_tab);
		model.setViewName("Atype_use_inf_tabForm");
		return model;
	}
	
	@RequestMapping(value = "atype_use_inf_tab/saveAtype_use_inf_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Atype_use_inf_tab atype_use_inf_tab) {
		atype_use_inf_tabDAO.saveOrUpdate(atype_use_inf_tab);
		return new ModelAndView("redirect:/atype_use_inf_tab");
	}
	
	@RequestMapping(value = "atype_use_inf_tab/deleteAtype_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView deleteAtype_tab(HttpServletRequest request) {
		String atype_use_inf_num = request.getParameter("atype_use_inf_num");
		atype_use_inf_tabDAO.delete(atype_use_inf_num);
		return new ModelAndView("redirect:/atype_use_inf_tab");
	}
	
	@RequestMapping(value = "atype_use_inf_tab/editAtype_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView editAtype_tab(HttpServletRequest request) {
		String atype_use_inf_num = request.getParameter("atype_use_inf_num");
		Atype_use_inf_tab atype_use_inf_tab = atype_use_inf_tabDAO.get(atype_use_inf_num);
		ModelAndView model = new ModelAndView("Atype_use_inf_tabForm");
		model.addObject("atype_use_inf_tab", atype_use_inf_tab);
		
		return model;
	}
}
