package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Atype_tabDAO;
import net.codejava.spring.model.Atype_tab;

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
public class Atype_tabController {

	@Autowired
	private Atype_tabDAO atype_tabDAO;
	
	@RequestMapping(value="/atype_tab")
	public ModelAndView listAtype_tab(ModelAndView model) throws IOException{
		List<Atype_tab> listAtype_tab = atype_tabDAO.list();
		model.addObject("listAtype_tab", listAtype_tab);
		model.setViewName("atype_tab");
		
		return model;
	}
	
	@RequestMapping(value = "atype_tab/newAtype_tab", method = RequestMethod.GET)
	public ModelAndView newAtype_tab(ModelAndView model) {
		Atype_tab newAtype_tab = new Atype_tab();
		model.addObject("atype_tab", newAtype_tab);
		model.setViewName("Atype_tabForm");
		return model;
	}
	
	@RequestMapping(value = "atype_tab/saveAtype_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Atype_tab atype_tab) {
		atype_tabDAO.saveOrUpdate(atype_tab);
		return new ModelAndView("redirect:/atype_tab");
	}
	
	@RequestMapping(value = "atype_tab/deleteAtype_tab", method = RequestMethod.GET)
	public ModelAndView deleteAtype_tab(HttpServletRequest request) {
		String atype_num = request.getParameter("atype_num");
		atype_tabDAO.delete(atype_num);
		return new ModelAndView("redirect:/atype_tab");
	}
	
	@RequestMapping(value = "atype_tab/editAtype_tab", method = RequestMethod.GET)
	public ModelAndView editAtype_tab(HttpServletRequest request) {
		String atype_num = request.getParameter("atype_num");
		Atype_tab atype_tab = atype_tabDAO.get(atype_num);
		ModelAndView model = new ModelAndView("Atype_tabForm");
		model.addObject("atype_tab", atype_tab);
		
		return model;
	}
}
