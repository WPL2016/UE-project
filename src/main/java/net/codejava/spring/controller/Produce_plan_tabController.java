package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Produce_plan_tabDAO;
import net.codejava.spring.model.Produce_plan_tab;

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
public class Produce_plan_tabController {

	@Autowired
	private Produce_plan_tabDAO produce_plan_tabDAO;
	
	@RequestMapping(value="/produce_plan_tab")
	public ModelAndView listProduce_plan_tab(ModelAndView model) throws IOException{
		List<Produce_plan_tab> listProduce_plan_tab = produce_plan_tabDAO.list();
		model.addObject("listProduce_plan_tab", listProduce_plan_tab);
		model.setViewName("produce_plan_tab");
		
		return model;
	}
	
	@RequestMapping(value = "produce_plan_tab/newProduce_plan_tab", method = RequestMethod.GET)
	public ModelAndView newProduce_plan_tab(ModelAndView model) {
		Produce_plan_tab newProduce_plan_tab = new Produce_plan_tab();
		model.addObject("produce_plan_tab", newProduce_plan_tab);
		model.setViewName("Produce_plan_tabForm");
		return model;
	}
	
	@RequestMapping(value = "produce_plan_tab/saveProduce_plan_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Produce_plan_tab produce_plan_tab) {
		produce_plan_tabDAO.saveOrUpdate(produce_plan_tab);
		return new ModelAndView("redirect:/produce_plan_tab");
	}
	
	@RequestMapping(value = "produce_plan_tab/deleteProduce_plan_tab", method = RequestMethod.GET)
	public ModelAndView deleteProduce_plan_tab(HttpServletRequest request) {
		String produce_plan_num = request.getParameter("produce_plan_num");
		produce_plan_tabDAO.delete(produce_plan_num);
		return new ModelAndView("redirect:/produce_plan_tab");
	}
	
	@RequestMapping(value = "produce_plan_tab/editProduce_plan_tab", method = RequestMethod.GET)
	public ModelAndView editProduce_plan_tab(HttpServletRequest request) {
		String produce_plan_num = request.getParameter("produce_plan_num");
		Produce_plan_tab produce_plan_tab = produce_plan_tabDAO.get(produce_plan_num);
		ModelAndView model = new ModelAndView("Produce_plan_tabForm");
		model.addObject("produce_plan_tab", produce_plan_tab);
		
		return model;
	}
}
