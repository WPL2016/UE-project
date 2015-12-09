package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Mou_tabDAO;
import net.codejava.spring.model.Mou_tab;

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
public class Mou_tabController {

	@Autowired
	private Mou_tabDAO mou_tabDAO;
	
	@RequestMapping(value="/mou_tab")
	public ModelAndView listMou_tab(ModelAndView model) throws IOException{
		List<Mou_tab> listMou_tab = mou_tabDAO.list();
		model.addObject("listMou_tab", listMou_tab);
		model.setViewName("mou_tab");
		
		return model;
	}
	
	@RequestMapping(value = "mou_tab/newMou_tab", method = RequestMethod.GET)
	public ModelAndView newMou_tab(ModelAndView model) {
		Mou_tab newMou_tab = new Mou_tab();
		model.addObject("mou_tab", newMou_tab);
		model.setViewName("Mou_tabForm");
		return model;
	}
	
	@RequestMapping(value = "mou_tab/saveMou_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Mou_tab mou_tab) {
		mou_tabDAO.saveOrUpdate(mou_tab);
		return new ModelAndView("redirect:/mou_tab");
	}
	
	@RequestMapping(value = "mou_tab/deleteMou_tab", method = RequestMethod.GET)
	public ModelAndView deleteMou_tab(HttpServletRequest request) {
		String mou_num = request.getParameter("mou_num");
		mou_tabDAO.delete(mou_num);
		return new ModelAndView("redirect:/mou_tab");
	}
	
	@RequestMapping(value = "mou_tab/editMou_tab", method = RequestMethod.GET)
	public ModelAndView editMou_tab(HttpServletRequest request) {
		String mou_num = request.getParameter("mou_num");
		Mou_tab mou_tab = mou_tabDAO.get(mou_num);
		ModelAndView model = new ModelAndView("Mou_tabForm");
		model.addObject("mou_tab", mou_tab);
		
		return model;
	}
}
