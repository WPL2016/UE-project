package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Mou_use_inf_tabDAO;
import net.codejava.spring.model.Mou_use_inf_tab;

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
public class Mou_use_inf_tabController {

	@Autowired
	private Mou_use_inf_tabDAO mou_use_inf_tabDAO;
	
	@RequestMapping(value="/mou_use_inf_tab")
	public ModelAndView listMou_use_inf_tab(ModelAndView model) throws IOException{
		List<Mou_use_inf_tab> listMou_use_inf_tab = mou_use_inf_tabDAO.list();
		model.addObject("listMou_use_inf_tab", listMou_use_inf_tab);
		model.setViewName("mou_use_inf_tab");
		
		return model;
	}
	
	@RequestMapping(value = "mou_use_inf_tab/newMou_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView newMou_use_inf_tab(ModelAndView model) {
		Mou_use_inf_tab newMou_use_inf_tab = new Mou_use_inf_tab();
		model.addObject("mou_use_inf_tab", newMou_use_inf_tab);
		model.setViewName("Mou_use_inf_tabForm");
		return model;
	}
	
	@RequestMapping(value = "mou_use_inf_tab/saveMou_use_inf_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Mou_use_inf_tab mou_use_inf_tab) {
		mou_use_inf_tabDAO.saveOrUpdate(mou_use_inf_tab);
		return new ModelAndView("redirect:/mou_use_inf_tab");
	}
	
	@RequestMapping(value = "mou_use_inf_tab/deleteMou_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView deleteMou_use_inf_tab(HttpServletRequest request) {
		String mou_use_inf_num = request.getParameter("mou_use_inf_num");
		mou_use_inf_tabDAO.delete(mou_use_inf_num);
		return new ModelAndView("redirect:/mou_use_inf_tab");
	}
	
	@RequestMapping(value = "mou_use_inf_tab/editMou_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView editMou_use_inf_tab(HttpServletRequest request) {
		String mou_use_inf_num = request.getParameter("mou_use_inf_num");
		Mou_use_inf_tab mou_use_inf_tab = mou_use_inf_tabDAO.get(mou_use_inf_num);
		ModelAndView model = new ModelAndView("Mou_use_inf_tabForm");
		model.addObject("mou_use_inf_tab", mou_use_inf_tab);
		
		return model;
	}
}
