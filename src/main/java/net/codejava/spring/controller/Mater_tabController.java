package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Mater_tabDAO;
import net.codejava.spring.model.Mater_tab;

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
public class Mater_tabController {

	@Autowired
	private Mater_tabDAO mater_tabDAO;
	
	@RequestMapping(value="/mater_tab")
	public ModelAndView listMater_tab(ModelAndView model) throws IOException{
		List<Mater_tab> listMater_tab = mater_tabDAO.list();
		model.addObject("listMater_tab", listMater_tab);
		model.setViewName("mater_tab");
		
		return model;
	}
	
	@RequestMapping(value = "mater_tab/newMater_tab", method = RequestMethod.GET)
	public ModelAndView newMater_tab(ModelAndView model) {
		Mater_tab newMater_tab = new Mater_tab();
		model.addObject("mater_tab", newMater_tab);
		model.setViewName("Mater_tabForm");
		return model;
	}
	
	@RequestMapping(value = "mater_tab/saveMater_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Mater_tab mater_tab) {
		mater_tabDAO.saveOrUpdate(mater_tab);
		return new ModelAndView("redirect:/mater_tab");
	}
	
	@RequestMapping(value = "mater_tab/deleteMater_tab", method = RequestMethod.GET)
	public ModelAndView deleteMater_tab(HttpServletRequest request) {
		String mater_num = request.getParameter("mater_num");
		mater_tabDAO.delete(mater_num);
		return new ModelAndView("redirect:/mater_tab");
	}
	
	@RequestMapping(value = "mater_tab/editMater_tab", method = RequestMethod.GET)
	public ModelAndView editMater_tab(HttpServletRequest request) {
		String mater_num = request.getParameter("mater_num");
		Mater_tab mater_tab = mater_tabDAO.get(mater_num);
		ModelAndView model = new ModelAndView("Mater_tabForm");
		model.addObject("mater_tab", mater_tab);
		
		return model;
	}
}
